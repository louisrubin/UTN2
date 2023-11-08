#color="nose"
clear
# usuario ingresa color y comparar

echo -n "ingrese color: "
read color

case $color in
	"rojo")
		echo "color rojo"
		;;
	"verde")
		echo "color verde"
		;;
	"blanco")
		echo "color blanco"
		;;
	*)
		echo "color desconocido"
		;;
esac
	
