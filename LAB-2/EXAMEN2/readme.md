# Feedback PARCIAL 2

### RUBIN AZAS MIGUEL A.

 ## :one: Ejercicio 1 (Crear la Clase DBHelper)
 El estudiante implementó la clase ```DBHelper``` correctamente, incluyendo métodos para ejecutar consultas con y sin resultados.
 Se sigue el patrón de excepciones y manejo adecuado de recursos.
 Nota: 0.3/0.3

 ## :two: Ejercicio 2 (Creación de las Clases Producto y Vendedor)
 Las clases ```Producto``` y ```Vendedor``` están implementadas correctamente, con atributos equivalentes a los campos de la base de datos.
 Los constructores también están presentes.
 Nota: 0.7/0.7

 ## :three: Ejercicio 3 (Creación de un Constructor Adicional en la clase Vendedor)
 El estudiante implementó correctamente el constructor adicional en la clase ```Vendedor``` que acepta una consulta SQL para buscar un vendedor por su ID.
 Nota: 0.5/0.5

 ## :four: Ejercicio 4 (Obtener los datos de un Vendedor)
 En la clase ```Comerciales```, el método ```obtenerVendedorPorID``` utiliza la clase ```Vendedor``` y retorna un objeto correctamente.
 Falta implementar el uso de ```DBHelper``` para ejecutar la consulta SQL.
 Nota: 0/1.5 (no cumple con la totalidad del ejercicio)

 ## :five: Ejercicio 5 (Generación de Informe de Productos en Stock)
 El método ```generarInforme``` de la clase ```Productos``` está implementado correctamente y muestra el informe formateado en la consola.
 Nota: 2/2

 ## :six: Ejercicio 6 (Obtener Producto por ID)
 El método ```obtenerProducto``` en la clase ```Productos``` está implementado correctamente y utiliza ```DBHelper``` para ejecutar la consulta SQL.
 Nota: 1/1

 ## :seven: Ejercicio 7 (Obtener el Producto Más Vendido)
 El método ```obtenerProductoMasVendido``` en la clase ```Productos``` está implementado, pero falta la parte que utiliza ```DBHelper``` para ejecutar la consulta SQL y obtener el producto más vendido.
 Nota: 0/2 (no cumple con la totalidad del ejercicio)

 ## :eight: Ejercicio 8 (Obtener el Listado de Vendedores)
 El método ```listadoDeVendedores``` en la clase ```Comerciales``` está implementado correctamente y utiliza ```DBHelper``` para obtener la información.
 Nota: 2/2

 ## :shipit: Observaciones generales:
 En algunos lugares, el código usa directamente consultas SQL sin utilizar PreparedStatements, lo que podría ser un problema de seguridad en un entorno real.
 Falta encapsulamiento en las variables de la clase ```DBHelper```.
 Se deben utilizar trywithresources o un bloque finally para cerrar adecuadamente las conexiones y los recursos.
 En algunos lugares, se utilizan nombres de variables poco descriptivos (por ejemplo, res en lugar de result).
  
 # :moyai: Nota Final:
La suma de las notas es 6.5/10. Como se indicó anteriormente, si no se respeta el encapsulamiento y no se utiliza ```DBHelper``` adecuadamente, se baja 1 punto a la nota final. Por lo tanto, la nota final es 5.5/10, redondeada a 6.
