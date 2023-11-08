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

(mkdir -p "$path/$carpeta")	# crea una carpeta si no existe

path="$path/$carpeta"	# asigna y concatena la nueva ruta

#for x in {1..5}
#do
#  touch $path/archivo$x.txt
#done
#(touch $path/alumnos.txt)	# crea diferentes archivos
#(touch $path/registro.txt)
#(touch $path/musicas.txt)
#(touch $path/pelis.txt)
#(touch $path/cuentas.txt)

echo " LISTA DE ARCHIVOS"
echo " "
while read line		# while para imprimir todos los archivos
do
	first_char=$(echo $line | cut -c 1)
	if [ $first_char != "t" ]
	then
		(echo $line | awk '{print $NF}')
	fi
done <<< $(ls -ls $path)

# ===============================================================================
echo " "
echo -n "ingrese letra: "
read letra
# ===============================================================================

while read line
do
	first_char=$(echo $line | awk '{print $NF}' | cut -c 1)	# obtiene el primer caracter de cada línea
	if [ $first_char == $letra ]
	then
		archivo=$(echo $line | awk '{print $NF}')	# obtiene el nombre base sin el '.txt' especificado al final
		extension="${filename##*.}"	# obtiene la extension
		echo "$archivo-$extension" 
		#nuevoArchivo=$archivoBase.sh
		
		if [ ! -e $(echo $line | awk '{print $NF}' | cut -d. -f1)$extension ]
		then
			( mv $path/$archivo$extension $path/$archivo | cut -d. -f1 .sh )	# CAMBIA NOMBRE
			echo "nombre cambiado correctamente."
		fi
	fi
	
done <<< $(ls -ls $path)	# lo qe devuelve el listar de archivos



