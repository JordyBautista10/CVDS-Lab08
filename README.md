# CVDS_LAB08
INTEGRANTES: Ximena Alejandra Rodriguez Salamanca, Jordy Santiago Bautista Sepulveda.

Pagina:


docker run -p 3306:3306 --name some-mysql -e MYSQL_ROOT_PASSWORD=root -d mysql:latest


![image](https://user-images.githubusercontent.com/123812969/232991602-18729dc0-3f6c-4ce7-8b70-cc854a941216.png)



PARTE I. - JUGANDO A SER UNCLIENTEHTTP

1. Abra una terminal Linux o consola de comandos Windows.
2. Realice una conexión síncrona TCP/IP a través de Telnet al siguiente servidor:

Host: www.escuelaing.edu.co
Puerto: 80
Teniendo en cuenta los parámetros del comando telnet:
telnet HOST PORT

3. Antes de que el servidor cierre la conexión por falta de comunicación:
Revise la página 36 del RFC del protocolo HTTP, sobre cómo realizar una petición GET. Con esto, solicite al servidor el recurso ‘sssss/abc.html’,
usando la versión 1.0 de HTTP.

Asegúrese de presionar ENTER dos veces después de ingresar el comando.

Revise el resultado obtenido. ¿Qué codigo de error sale?, revise el significado del mismo en la lista de códigos de estado HTTP.
¿Qué otros códigos de error existen?, ¿En qué caso se manejarán?

![WhatsApp Image 2023-03-18 at 00 32 25](https://user-images.githubusercontent.com/123812969/226087329-e79d0029-64c9-4b08-b59e-a6fe4fb1bdf9.jpeg)

El codigo de erro que nos aparece es un 400, lo cual significa que es unaa solicitud que contiene una sintaxis incorrecta o no se puede cumplir. Toca tener claro que este error es producido por el cliente.

![image](https://user-images.githubusercontent.com/123812969/226087420-95c4a0f7-89ba-436d-a951-189f0fa3b0fb.png)

4. Realice una nueva conexión con telnet, esta vez a:

Host: www.httpbin.org
Puerto: 80
Versión HTTP: 1.1
Ahora, solicite (GET) el recurso /html. ¿Qué se obtiene como resultado?

![WhatsApp Image 2023-03-18 at 00 32 46](https://user-images.githubusercontent.com/123812969/226087502-480f86fe-505a-4956-8317-0daa7dbd145c.jpeg)

5. Seleccione el contenido HTML de la respuesta y copielo al cortapapeles CTRL-SHIFT-C. Ejecute el comando wc (word count) para contar palabras con la
opción -c para contar el número de caracteres.

![WhatsApp Image 2023-03-18 at 00 32 59](https://user-images.githubusercontent.com/123812969/226087553-6b6f4f45-65b1-4e8f-b0ff-43bff4f167e6.jpeg)

Claro está, las peticiones GET son insuficientes en muchos casos. Investigue: ¿Cuál es la diferencia entre los verbos GET y POST? ¿Qué otros tipos de
peticiones existen?

 La diferencia entre get y post radica en el envio de datos, cuando utilizamos el metodo get envia los datos usando una url, mientras que el metodo post los envía de forma que no podemos verlos.
 
 Otros tipos de verbos:
 
 ![image](https://user-images.githubusercontent.com/123812969/226088090-69fd37ed-2528-4a54-adb0-197a561a30db.png)


6. En la practica no se utiliza telnet para hacer peticiones a sitios web sino el comando curl

![WhatsApp Image 2023-03-18 at 00 33 17](https://user-images.githubusercontent.com/123812969/226087580-213d1827-9430-4a3b-99f8-06d6ee11f2ba.jpeg)

Utilice ahora el parámetro -v y con el parámetro -i

![WhatsApp Image 2023-03-18 at 00 33 26](https://user-images.githubusercontent.com/123812969/226087593-408edcc4-3c5c-4cd8-9a6d-7964ae473586.jpeg)

![WhatsApp Image 2023-03-18 at 00 33 36](https://user-images.githubusercontent.com/123812969/226087598-e716a82a-1548-4231-ad98-c1b072449b98.jpeg)

¿Cuáles son las diferencias con los diferentes parámetros?

* El comando curl -v entrega resultados mucho mas detallados
* El comando curl -i entrega el encabezado, es decir incluye cosas como de donde sale la informacion (url), host.

## PARTE II. -HACIENDO UNA APLICACIÓN WEB DINÁMICA A BAJO NIVEL.

En este ejercicio, va a implementar una aplicación Web muy básica, haciendo uso de los elementos de más bajo nivel de Java-EE (Enterprise Edition),con el fin
de revisar losconceptos del protocoloHTTP. En este caso,se trata de un módulo de consulta de clientes Web que hace uso de una librería de acceso a datos
disponible en un repositorio Maven local.

I. Para esto,cree un proyecto maven nuevo usando el arquetipo de aplicación Web estándar maven-archetype-webapp y realice lo siguiente:

Los servlets, que se ejecutan en un servidor web habilitado para Java, amplían las funciones de un servidor web.

arquetipo mvn : generar - DarchetypeGroupId = org . apache _ experto _ arquetipos - DarchetypeArtifactId = maven - arquetipo - aplicación web - DarchetypeVersion = 1.4

se deberia ver de la siguiente manera:

![image](https://user-images.githubusercontent.com/123812926/224491128-fea70863-1a12-4c7b-ac12-3df3d8748312.png)

Luego tendremos que anotar lo siguiente:

" groupId " : edu.eci.cvds
" artifactId " : CVDS_LAB05
" version " : 1.0-SNAPSHOT
" package " : edu.eci.cvds.servlet

una ves anotado eso, damos "ENTER". Se vera lo siguiente:

![image](https://user-images.githubusercontent.com/123812926/224491155-7baf1902-26b1-49cb-b0a3-e7774ecffdbf.png)

2. En el pom.xml, modifique la propiedad "packaging" con el valor "war". Agregue la siguiente dependencia y y agregue la seccion build al final del tag project en el archivo pom.xml:

<dependency>
<groupId>javax</groupId>
<artifactId>javaee-web-api</artifactId>
<version>7.0</version>
<scope>provided</scope>
</dependency>

![image](https://user-images.githubusercontent.com/123812926/225691101-b6a299bd-4e1b-4345-8f43-44ecd547b8a6.png)

3. Revise en el pom.xml para qué puerto TCP/IP está configurado el servidor embebido de Tomcat (ver sección de plugins).

El puerto para Tomcat es 8080.

![image](https://user-images.githubusercontent.com/123812926/225691587-27a835fa-61e6-47e8-b7c1-e8f91b5b35f4.png)

4. Compile y ejecute la aplicación en el servidor embebido Tomcat, a través de Maven con:

mvn package
mvn tomcat7:run

5. Abra un navegador, y en la barra de direcciones ponga la URL con la cual se le enviarán peticiones al ‘SampleServlet’. Tenga en cuenta que la URL tendrá
como host ‘localhost’, como puerto, el configurado en el pom.xml y el path debe ser el del Servlet. Debería obtener un mensaje de saludo.

![image](https://user-images.githubusercontent.com/123812926/224491506-6cc3ff3f-9bf5-452b-8840-c9cf72411867.png)

6. Observe que el Servlet ‘SampleServlet’ acepta peticiones GET, y opcionalmente, lee el parámetro ‘name’. Ingrese la misma URL, pero ahora agregando
un parámetro GET (si no sabe como hacerlo, revise la documentación en http://www.w3schools.com/tags/ref_httpmethods.asp).

![image](https://user-images.githubusercontent.com/123812926/224491495-8f4f08a5-b656-437b-b5f0-2a3a833dabc2.png)

7. Busque el artefacto gson en el repositorio de maven y agregue la dependencia.

<dependency>
 <groupId>com.google.code.gson</groupId>
 <artifactId>gson</artifactId>
 <version>2.10.1</version>
</dependency>

![image](https://user-images.githubusercontent.com/123812926/225692976-ba1325a5-4f30-4329-8198-b20d001119f3.png)

8. En el navegador revise la dirección https://jsonplaceholder.typicode.com/todos/1. Intente cambiando diferentes números al final del path de la url.

La pagina web se ve de esta manera:

![image](https://user-images.githubusercontent.com/123812926/225693255-e1c084b4-29c2-4bd2-9f52-bba3dfd3c9d7.png)

El numero que le asignamos es 5

![image](https://user-images.githubusercontent.com/123812926/225693521-48f90147-6530-4804-ad75-a0dc06b4d1bf.png)

9. Basado en la respuesta que le da el servicio del punto anterior, cree la clase edu.eci.cvds.servlet.model.Todo con un constructor vacío y los
métodos getter y setter para las propiedades de los "To Dos" que se encuentran en la url indicada.

![image](https://user-images.githubusercontent.com/123812926/225700281-e5463b83-3061-4b29-af9f-5d66aefed541.png)

10. Utilice la siguiente clase para consumir el servicio que se encuentra en la dirección url del punto anterior:

![image](https://user-images.githubusercontent.com/123812926/225700485-8daa7c60-dfc1-4dcf-a5ec-5da182977aab.png)

11. Cree una clase que herede de la clase HttpServlet (similar a SampleServlet), y para la misma sobrescriba el método heredado doGet. Incluya la
anotación @Override para verificar –en tiempo de compilación- que efectivamente se esté sobreescribiendo un método de las superclases.

12. Para indicar en qué URL el servlet interceptará las peticiones GET, agregue al método la anotación @WebServlet, y en dicha anotación, defina la
propiedad urlPatterns, indicando la URL (que usted defina) a la cual se asociará el servlet.

13. Teniendo en cuenta las siguientes métodos disponibles en los objetos ServletRequest y ServletResponse recibidos por el método doGet

![image](https://user-images.githubusercontent.com/123812969/226067156-e0921071-12fb-4298-ac9e-9ad4cc8b91a3.png)

15. Intente hacer diferentes consultas desde un navegador Web para probar las diferentes funcionalidades.

![image](https://user-images.githubusercontent.com/123812969/226073513-a960903f-495a-4bb8-aba2-17a288b10ded.png)

![image](https://user-images.githubusercontent.com/123812969/226073589-cda8ada6-ea51-4426-8f53-6e1df53c0eb7.png)

PARTE III.

16. En su servlet, sobreescriba el método doPost, y haga la misma implementación del doGet.

![image](https://user-images.githubusercontent.com/123812969/226068771-0ac8e136-1fe1-4edf-bb9b-3966443c88ff.png)

17. Cree el archivo index.html en el directorio src/main/webapp/index.html 

![image](https://user-images.githubusercontent.com/123812969/226068923-2539d2ed-e0c4-4749-9ebf-df9a472b3015.png)

18. En la página anterior, cree un formulario que tenga un campo para ingresar un número (si no ha manejado html antes, revise
http://www.w3schools.com/html/ ) y un botón. El formulario debe usar como método ‘POST’, y como acción, la ruta relativa del último servlet creado
(es decir la URL pero excluyendo ‘http://localhost:8080/’).

![image](https://user-images.githubusercontent.com/123812969/226074331-a3d67acd-cb74-4001-bdf6-0e522f0d9fb8.png)

19. Revise este ejemplo de validación de formularios con javascript y agruéguelo a su formulario, de manera que -al momento de hacer ‘submit’- desde el
browser se valide que el valor ingresado es un valor numérico.

![image](https://user-images.githubusercontent.com/123812969/226078148-43e792a8-a103-4484-808a-a1ea937537cd.png)

20. Recompile y ejecute la aplicación. Abra en su navegador en la página del formulario, y rectifique que la página hecha anteriormente sea mostrada.
Ingrese los datos y verifique los resultados. Cambie el formulario para que ahora en lugar de POST, use el método GET . Qué diferencia observa?


21. ¿Qué se está viendo? Revise cómo están implementados los métodos de la clase Service.java para entender el funcionamiento interno.

POST

![image](https://user-images.githubusercontent.com/123812969/226079840-74ede1b1-a5f3-4cd6-932a-8b814b96b143.png)

![image](https://user-images.githubusercontent.com/123812969/226079909-ea7b2b1e-1584-497b-b5db-ff7de219652c.png)

para comprobar que si validamos que solo valga datos de tipo numerico

![image](https://user-images.githubusercontent.com/123812969/226080519-777bff9c-d15d-47a2-b682-b90af29e12f3.png)

GET

![image](https://user-images.githubusercontent.com/123812969/226079371-5ba30e23-1099-4aad-ac5c-65a156f12cff.png)

![image](https://user-images.githubusercontent.com/123812969/226079401-a1b5dd15-b517-4f1d-9500-6c978ad137f6.png)

_Las diferencias que pudimos notar es que en la url para el caso de get nos muestra los valores numericos que el usuario escriba, mientras que en el post no pasa esto sino por el contrario estos valores estan ocultos._

PARTE IV. - FRAMEWORKS WEB MVC – JAVA SERVER FACES /
PRIME FACES

En este ejercicio, usted va a desarrollar una aplicación Web basada en el marco JSF, y en una de sus implementaciones más usadas: PrimeFaces. Se trata de un
juego en línea para adivinar un número, en el que el ganador, si atina en la primera oportunidad, recibe $100.000. Luego, por cada intento fallido, el premio
se reduce en $10.000.

1. Al proyecto Maven, debe agregarle las dependencias mas recientes de javax.javaee-api, com.sun.faces.jsf-api, com.sun.faces.jsf-impl,
javax.servlet.jstl y Primefaces (en el archivo pom.xml).

```
</dependencies>
  <dependency>
    <groupId>javax</groupId>
    <artifactId>javaee-api</artifactId>
    <version>8.0.1</version>
    <scope>provided</scope>
  </dependency>

  <!-- https://mvnrepository.com/artifact/com.sun.faces/jsf-api -->
  <dependency>
    <groupId>com.sun.faces</groupId>
    <artifactId>jsf-api</artifactId>
    <version>2.2.20</version>
  </dependency>

  <!-- https://mvnrepository.com/artifact/com.sun.faces/jsf-impl -->
  <dependency>
    <groupId>com.sun.faces</groupId>
    <artifactId>jsf-impl</artifactId>
    <version>2.2.20</version>
  </dependency>

  <!-- https://mvnrepository.com/artifact/javax.servlet/jstl -->
  <dependency>
    <groupId>javax.servlet</groupId>
    <artifactId>jstl</artifactId>
    <version>1.2</version>
  </dependency>


  <dependency>
    <groupId>org.primefaces</groupId>
    <artifactId>primefaces</artifactId>
    <version>5.2</version>
  </dependency>
</dependencies>
```
2. Para que configure automáticamente el descriptor de despliegue de la aplicación (archivo web.xml), de manera que el framework JSF se active al inicio
de la aplicación, en el archivo web.xml.

3. Revise cada una de las configuraciones agregadas anteriormente para saber qué hacen y por qué se necesitan. Elimine las que no se necesiten.

![image](https://user-images.githubusercontent.com/123812969/226081891-de1509d4-05ca-49f6-a23a-bbef1f7a9134.png)

4. Ahora, va a crear un Backing-Bean de sesión, elcual, para cada usuario, mantendrá de lado delservidor lassiguientes propiedades: a. El
número que actualmente debe adivinar (debe ser un número aleatorio).

![image](https://user-images.githubusercontent.com/123812926/226153744-40543e0a-e827-4857-b364-1a055b0452b9.png)

5. 6. 7. 8. Siguiendo las instruciones de estos puntos es archivo guess.xhtml queda de la suiduiente forma: 

![image](https://user-images.githubusercontent.com/123812926/226153790-516cdfe5-a276-441b-b25c-6a3a35c85846.png)

9. Los comandos ```mvn package``` y  ```mvn tomcat7:run``` deberian correr con normalidad

11. Hora se prueba el juego en la pagina web en la siguiente URL http://localhost:8080/faces/guess.xhtml

   a. Prueba en navegador: valores 5, 5, 1, 10, 18                                    Prueba en el modo incognito: 9
        
![image](https://user-images.githubusercontent.com/123812926/226156147-09fd0cf0-c5d4-41f1-a4f6-bf9338a50c67.png)
![image](https://user-images.githubusercontent.com/123812926/226154275-b327d660-59f4-4305-bcda-ec9995c8bfa0.png)
        
   b. cambio de ```@SessionScoped``` a ```@ApplicationScoped``` y vuelvo a correr la aplicacion 
   
![image](https://user-images.githubusercontent.com/123812926/226155549-fea46d3d-1c51-4113-94eb-61f35b1f3bcd.png)

- Ahora los valores del premio coiciden, pues al fallar en la pagina web se restan 10000 y si se vuelve a jugar en la pagina en incognito al fallar vamos a ver que se restan 20000, sin embargo esto no es asi, solamente se restaron 10000, esto se debe a que los datos son compartidos.

![image](https://user-images.githubusercontent.com/123812926/226155807-bc4e5564-d208-4836-84ce-87fef655c616.png)
![image](https://user-images.githubusercontent.com/123812926/226155817-e031af93-3e2a-48ad-91ca-b82cad8d1c6c.png)

c. Verificamos el codigo con el modo desarrollador:

![image](https://user-images.githubusercontent.com/123812926/226155881-f42ccec8-13a3-4a45-8d0c-b0708e82b878.png)
