# listar todos los archivos de una ubicacion ignorando los directorios
clear

# ls -l > archivoLS.txt
while read line
do
	if [ $((expr substr $line 1 1)) -eq "d" ]
	then
		echo "D"
	fi
done < archivoLS.txt
