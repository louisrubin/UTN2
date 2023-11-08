clear
# 1. Listar archivos de un directorio particular y mostrarlos. Solo archivos visibles.
# 2. Los archivos del punto anterior deben listarse con el siguiente formato.
#	a. Archivo 1: nombre_archivo1
#	b. Archivo 2: nombre_archivo2
# En el resultado de salida, solo debe aparecer el nombre del archivo con el prefijo: Archivo X:

path="/$HOME/Documentos"		# ruta de donde lee los archivos, $HOME es una 
					# variable de entorno que obtiene la ruta del sistema del usuario 
					# actual en ubuntu

# codigo para reemplazar "documentos" por "documents" en inglés (si no existe)
if [ ! -d $path ]
then
	path="/$HOME/Documents"
fi


files=$(ls -l $path)		# comando "ls -l" para listar desde la ruta en $path
cont=1

while read line	
do
	first_char=$(echo $line | cut -c 1)	# obtiene el primer caracter de cada línea
	if [ $first_char != "d" -a $first_char != "t" ]	# los archivos que no empiecen con "d" ni "t" de la primera linea 'total'
	then
		archivo=$(echo $line | awk '{print $9}')	# archivo leido de cada linea
		echo "   Archivo $cont: $archivo"
		(( cont += 1 ))
	fi
done <<< $files		# se utiliza la redirección `<<<` para pasar el contenido de `files` al bucle

# En este código, la salida de `ls -l` se almacena en la variable `files` antes de entrar al bucle. Luego, se utiliza la redirección `<<<` para pasar el contenido de `files` al bucle. Esto debería imprimir el mensaje correspondiente para cada línea del archivo "listaArchivos.txt" que no empiecen con 'd'.
