# LINUX
clear
# Crear dentro de un directorio varios archivos con la extensión txt que empiecen con diferentes letras.
#	a. Renombrar solo los archivos que empiecen con una letra indicada por el usuario.
# 	b. Los archivos a renombrar, deben cambiar su extensión a sh.
#	c. Ejemplo: prueba.txt. El usuario ingresa: p, entonces se renombra a prueba.sh

path="$HOME/Documentos"	# ruta de documentos (español)

# codigo para reemplazar "documentos" por "documents" en inglés (si no existe)
if [ ! -d $path ]
then
	path="$HOME/Documents"	# en ingles
fi
# ===============================================================================

carpeta="archivosTxt"	# nombre de la nueva carpeta

if [ ! -d "$path/$carpeta" ]	# si no existe la ruta
then
	(mkdir -p "$path/$carpeta")	# crea una carpeta si no existe
	(touch $path/$carpeta/alumnos.txt)	# crea diferentes archivos
	(touch $path/$carpeta/registros.txt)
	(touch $path/$carpeta/musicas.txt)
	(touch $path/$carpeta/peliculas.txt)
	(touch $path/$carpeta/cuentas.txt)
fi

path="$path/$carpeta"	# concatena la ruta con la nueva carpeta

# ===============================================================================

echo " LISTA DE ARCHIVOS"
echo " "
while read line		# while para imprimir todos los archivos
do
	first_char=$(echo $line | cut -c 1)
	(echo $line | awk '{print $NF}')	# imprime solo el nombre del archivo y su ext.
	
done <<< $(ls -ls $path  | tail -n +2 )	# 'tail -n +2' para omitir la primera línea que muestra el total

# ===============================================================================
echo " "
echo -n "Ingrese letra: "
read letra
letra=$(echo $letra | tr '[:upper:]' '[:lower:]')	# `tr` convertirá la letra a minúscula
# ===============================================================================

while read line
do
	first_char=$(echo $line | awk '{print $NF}' | cut -c 1)	# obtiene el primer caracter de cada línea
	if [ $first_char == $letra ]
	then
		archivo=$(echo $line | awk '{print $NF}')	# obtiene el nombre con su extension
		extension="${archivo##*.}"			# obtiene solo la extension de "$archivo"
		archivo=$(echo $archivo |  cut -d. -f1 )	# quita la extension del $archivo
		
		nuevoArchivo="$path/$archivo.sh"		# variable con el nuevo nombre a cambiar (.sh)
		
		if [ ! -e $nuevoArchivo ]		# si el nombre nuevo a cambiar ya existe
		then
			( mv $path/$archivo.$extension $nuevoArchivo )	# CAMBIA NOMBRE con nueva extension
			echo "Nombre cambiado correctamente."
			echo " "
			exit 0
		else
			echo "El archivo '$archivo' ya tiene extensión .SH"
			echo " "
			exit 0		# "exit 0" para salir exitosamente o "exit 1" para indicar un error
		fi
	fi
	
done <<< $(ls -ls $path)	# lo qe devuelve el listar de archivos dentro de esa ruta
echo ""


# ${archivo##*.} se utiliza para extraer la extensión de un nombre de archivo
# 	elimina todo antes del último punto en el nombre del archivo ($archivo), dejando solo la extensión.
