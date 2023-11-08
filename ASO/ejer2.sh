# solicita nota numerica y devuelve de manera alfabetica
clear	# consola

echo -n "ingrese nota en numero: "
read nota

# if (nota >= 7)
if [ $nota -ge 7 ]		# great-equals (?
then
	echo "distinguido"
elif [ $nota -ge 4 ]
then
	echo "regular"
else
	echo "desaprobado"
fi
