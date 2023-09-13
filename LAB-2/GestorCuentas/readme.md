# Gestión de Cuentas
1. Crea una clase abstracta llamada `Cuenta` que contenga los siguientes atributos protegidos:
   - `numeroCuenta`
   - `saldo`
   Además, la clase `Cuenta` deberá tener los siguientes métodos abstractos:
   - `depositar(cantidad)`
   - `retirar(cantidad)`
   - `mostrarInformacion()`

2. Crea una clase llamada `CuentaPersona` que herede de la clase `Cuenta` y tenga los siguientes atributos privados adicionales:
   - `nombre`
   - `apellido`

   Implementa los métodos abstractos de la clase base `Cuenta` de la siguiente manera:
   - `depositar(cantidad)` debe aumentar el saldo en la cantidad especificada.
   - `retirar(cantidad)` debe disminuir el saldo en la cantidad especificada si hay suficientes fondos.
   - `mostrarInformacion()` debe mostrar por pantalla el número de cuenta, nombre, apellido y saldo.

3. Crea una clase llamada `CuentaSociedad` que herede de la clase `Cuenta` y tenga los siguientes atributos privados adicionales:
   - `nombreEmpresa`
   - `tipoEmpresa`

   Implementa los métodos abstractos de la clase base `Cuenta` de la siguiente manera:
   - `depositar(cantidad)` debe aumentar el saldo en la cantidad especificada.
   - `retirar(cantidad)` debe disminuir el saldo en la cantidad especificada si hay suficientes fondos.
   - `mostrarInformacion()` debe mostrar por pantalla el número de cuenta, nombre de la empresa, tipo de empresa y saldo.

4. Crea una clase llamada `GestorCuentas` que contenga dos ArrayLists: uno para almacenar objetos de tipo `CuentaPersona` y otro para almacenar objetos de tipo `CuentaSociedad`.

   Implementa los siguientes métodos en la clase `GestorCuentas`:
   - `agregarCuentaPersona(cuenta)` para agregar una cuenta de persona al ArrayList correspondiente.
   - `agregarCuentaSociedad(cuenta)` para agregar una cuenta de sociedad al ArrayList correspondiente.
   - `eliminarCuentaPersona(numeroCuenta)` para eliminar una cuenta de persona según su número de cuenta.
   - `eliminarCuentaSociedad(numeroCuenta)` para eliminar una cuenta de sociedad según su número de cuenta.
   - `editarCuentaPersona(numeroCuenta, nuevoSaldo)` para editar el saldo de una cuenta de persona según su número de cuenta.
   - `editarCuentaSociedad(numeroCuenta, nuevoSaldo)` para editar el saldo de una cuenta de sociedad según su número de cuenta.
   - `mostrarTodasLasCuentas()` para mostrar la información de todas las cuentas (personas y sociedades) almacenadas en los ArrayLists.

5. En el programa principal (clase `Main`), permite al usuario realizar las siguientes acciones:
   - Crear y agregar cuentas de personas y sociedades.
   - Eliminar cuentas de personas y sociedades.
   - Editar el saldo de cuentas de personas y sociedades.
   - Mostrar la información de todas las cuentas almacenadas.
