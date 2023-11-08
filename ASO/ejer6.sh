# lee un archivo TXT e imprime cada linea que contiene


while read line
do
	echo $line
done < archivoLS.txt	# ese archivo será la entrada donde se lee

# cuando listo todos los directorios la "d" como primer caracter significa
# que es un directorio y el nombre de ese archivo es violeta


