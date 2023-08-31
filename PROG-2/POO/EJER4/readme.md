# PROBLEMA N° 3
- ### Crear una superclase llamada ```Electrodoméstico``` con las siguientes características:
- Sus atributos son ```precio base```, ```color```, ```consumo energético``` (letras entre A y F) y ```peso```. Indicar que se pueden
heredar.

---

- Por defecto, el color será blanco, el consumo energético será F, el precio Base es de ```$100.00``` y el peso de 5
kg. Se puede usar constantes para definirlo.
- Los colores disponibles son blanco, negro, rojo, azul y gris. No importa si el nombre está en mayúsculas o en
minúsculas.

---

#### Los constructores que se implementaran serán


- Un constructor por defecto.
- Un constructor con el ```precio``` y ```peso```. El resto por defecto.
- Un constructor con todos los atributos.

---

#### Los métodos a implementar son:


- Métodos get de todos los atributos.
- ```comprobarConsumoEnergetico(char letra)```: comprueba que la letra es correcta, sino es correcta usara la
letra por defecto.
- ```comprobarColor(String color)```: comprueba que el color es correcto, sino lo es usa el color por defecto.
- ```precioFinal()```: según el consumo energético, aumentara su precio, y según su tamaño, también. Esta es la
lista de precios:

![tabla](https://github.com/louisrubin/UTN2/assets/72027738/7785e44f-789e-437f-b7cb-350fa18090b9)

---

- # Crear una subclase llamada ```Lavarropas``` con las siguientes características:

- Su atributo es ```carga```, además de los atributos heredados.
- Por defecto, la carga es de 5 kg. Usa una constante para ello.

---

#### Los constructores que se implementaran serán:
- Un constructor por defecto.
- Un constructor con el ```precio``` y ```peso```. El resto por defecto.
- Un constructor con la ```carga``` y el resto de atributos heredados. Recuerden que deben llamar al constructor de
la clase padre.

---

#### Los métodos que se implementara serán:

- Método get de ```carga```.
- ```precioFinal()```:, si tiene una carga mayor de 30 kg, aumentará el precio $50 , sino es así no se incrementara el
precio. Llamar al método padre y añade el código necesario. Las condiciones en la clase Electrodoméstico
también deben afectar al precio.

---

- # Crear una subclase llamada ```Televisión``` con las siguientes características:
- Sus atributos son ```resolución``` (en pulgadas) y ```sintonizador TDT``` (booleano), además de los atributos
heredados.
- Por defecto, la resolución será de 20 pulgadas y el sintonizador será false.

---

#### Los constructores que se implementaran serán:
- Un constructor por defecto.
- Un constructor con el ```precio``` y ```peso```. El resto por defecto.
- Un constructor con la ```resolución```, ```sintonizador TDT``` y el resto de atributos heredados. Recuerda que
debes llamar al constructor de la clase padre.

---

#### Los métodos que se implementara serán:
- Método get de ```resolución``` y ```sintonizador TDT```.
- ```precioFinal()```: si tiene una resolución mayor de 40 pulgadas, se incrementará el precio un
30% y si tiene un sintonizador TDT incorporado, aumentará $50. Recuerden que las
condiciones de la clase Electrodoméstico también deben afectar al precio

---

- # Ahora crea una clase ejecutable que realice lo siguiente:  
- Crea un array de Electrodomésticos de 10 posiciones.
- Asigna a cada posición un objeto de las clases anteriores con los valores que desees.
- Ahora, recorre este array y ejecuta el método ```precioFinal()```.


Deberás mostrar la sumatoria de los precios de cada clase, es decir, el precio de todas las televisiones por un
lado, el de las lavadoras por otro y la suma de los Electrodomésticos (puedes crear objetos
Electrodoméstico, pero recuerda que Televisión y Lavadora también son electrodomésticos). Hay que utilizar
el método ```instanceof``` para saber de a qué Clase pertenece la instancia.


Por ejemplo, si tenemos un Electrodoméstico con un precio final de 300, una lavadora de 200 y una
televisión de 500, el resultado final será de 1000 (300+200+500) para electrodomésticos, 200 para lavadora
y 500 para televisión.

---

- ## Demostración en ejecución
![ejecutando](https://github.com/louisrubin/UTN2/assets/72027738/dce89e66-644a-4fea-8e7f-4d7318e6ddc9)

###### Rubín Azás Miguel A. Luis - Programación 2 (TUP 23) 