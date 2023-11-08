clear	# limpia la consola
date	# muestra la fecha

echo -n "ingrese cadena 1 (sin espacios): "
read cadena1

echo -n "ingrese cadena 2 (sin espacios): "
read cadena2

if [ -z $cadena1 ] 
then
	echo "cadena 1 VACIA"
else
	echo "cadena 1 NO VACIA"
fi

if [ -z $cadena2 ]
then
	echo "cadena 2 VACIA"
else
	echo "cadena 2 NO VACIA"
fi
	
	
	
	
