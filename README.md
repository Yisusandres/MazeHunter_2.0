VERSION DE JAVA REQUERIDA: 22.0.2
LIBRERIAS NECESARIAS
Jackson: Esta librería contiene una clase llamada “ObjectMapper”, el cual su objeto permite serializar (o traducir) objetos de Java al formato JSON y también, deserializar datos del archivo JSON a objetos de Java.
En este caso, se utiliza para guardar todos los datos de cada usuario en el archivo JSON

-	readValue(file, object) permite leer los datos almacenados en el archivo JSON y guardarlos en una variable del programa Java
-	writeValue(file, object) se encarga de guardar los datos de un objecto Java en el archivo JSON
-	enable(SerializationFeature.INDENT_OUTPUT) permite escribir y leer con saltos de línea e identación, es decir cambiar el formato del JSON
