clear
# ingresar numero e imprimir todos los pares desde 1 hasta ese num
echo -n "ingrese numero: "
read num
i=1

# while [[ $i -le 20 ]] ; do	# less-equals(?
while [[ $i -le num ]] ; do	# less-equals(?
	if [ $((i % 2)) -eq 0  ]
	then 
		echo "$i"
	fi
	(( i += 1 ))
done


