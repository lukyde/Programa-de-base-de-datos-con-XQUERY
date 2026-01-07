Aquí tienes una propuesta de archivo `README.md` basada en el contenido de tu tarea de Acceso a Datos sobre bases de datos XML.

---

# Tarea AD05: Bases de Datos XML con BaseX

Este proyecto consiste en el desarrollo de una aplicación con interfaz gráfica (Java Swing) conectada a una base de datos XML (**BaseX**) para gestionar la información de un taller mecánico.

## 📋 Descripción del Proyecto

La aplicación permite realizar operaciones de lectura, inserción, modificación y borrado sobre el archivo `taller.xml`, que contiene colecciones de **Vehículos**, **Reparaciones** y **Marcas**.

### Tecnologías Utilizadas

* **Java SE** con librería **Swing** para la interfaz.


* **BaseX** como motor de base de datos XML.


* **XQuery** para las consultas y actualizaciones de datos.



---

## 🚀 Funcionalidades Principales

### 1. Gestión de Ficheros Locales

Al inicio del programa, la clase `GestionDatos` procesa el archivo XML principal y genera copias locales individuales para cada entidad en el directorio `AD52425`:

* Generación de archivos secuenciales: `vehiculox.xml`, `reparacionx.xml` y `marcax.xml`.


* Uso de `StringBuilder`, `BufferedReader` y `BufferedWriter` para la optimización de lectura y escritura.



### 2. Consultas (XQuery)

Se han implementado consultas almacenadas en scripts `.xq` ejecutadas a través de la clase `ConsultasBaseDatos`:

* **Filtrado por año:** Matrícula de vehículos fabricados en 2024.


* **Filtrado por kilómetros:** Marca y modelo de vehículos con menos de 75,000 km.


* **Búsqueda avanzada:** Propietarios de un modelo específico (Golf) y listado de mecánicos.



### 3. Actualizaciones de Datos

La aplicación permite modificar la base de datos en tiempo real mediante sentencias de actualización:

* **Actualización de valores:** Cambio de kilometraje a un vehículo específico por su matrícula.


* **Renombrado de nodos:** Modificación masiva del nodo `<kilometros>` por `<kms>` en toda la colección.


* **Inserción de registros:** Registro de nuevas reparaciones incluyendo matrícula, fecha y datos del mecánico.



---

## 🛠️ Estructura del Código

### Clase `ConsultasBaseDatos`

Gestiona la conexión y ejecución de consultas mediante los métodos:

* `AbrirBaseDatos(String consulta)`: Crea/abre la base de datos `Taller` usando el contexto de BaseX.


* `leerArchivo(String ruta)`: Carga los scripts `.xq` externos para su ejecución.


* `Actualizar(String consulta, String update)`: Ejecuta simultáneamente una consulta de selección y una de modificación.



### Interfaz de Usuario

* **Panel de Consultas:** Resultados mostrados en tablas dinámicas.


* **Panel de Modificaciones:** Uso de `RadioButtons` y `TextAreas` para gestionar los cambios y visualizar los nodos afectados.



---

## 🔧 Instalación

1. Clonar el repositorio.
2. Asegurarse de incluir el driver `Basex.jar` en las librerías del proyecto.


3. Colocar el archivo `taller.xml` en la ruta especificada por la aplicación.

---

**Autor:** Raúl Manuel Luna Palma
