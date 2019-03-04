# DNA_MUTATIONS_AWS
aws rest api el proyecto fue desarrollado utilizando lo siguiente:

 - Netbeans 8.2
 - Java 8
 - SpringBoot 2.1.3.RELEASE
 - Jacoco 0.8.2
 - Hibernate 5
 
## Instrucciones:

1. Descargar el codigo y ejecutar con maven las siguientes instrucciones
  - mvn clean install
  - mvn package  
  - java -jar mutations-0.0.1-SNAPSHOT.jar (target)

## Code coverage

1. Abrir una terminal y posicionarse  en la misma ruta en la que se encuentra el pom.xml del proyecto
2. ejecutar la siguiente instruccion:
  - mvn jacoco:report
3. una vez terminado la ejecucion entrar a la siguiente ruta y abrir el index.html  target/site/jacoco/index.html 

- code coverage actual: 85%

<img width="870" alt="code coverage" src="https://user-images.githubusercontent.com/8495787/53712244-abd5f900-3e0b-11e9-8c6c-5a17769c8b12.PNG">

## Endpoints:

 - URL: http://DnaMutations-env.pkzir4m2un.us-east-2.elastic/mutation

POST → /mutation/
{
"dna":["ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"]
}
En caso de verificar una mutación, debería devolver un HTTP 200-OK, en caso contrario un 403-Forbidden

GET → /stats/

 - URL: http://DnaMutations-env.pkzir4m2un.us-east-2.elastic/stats
 
 Devolvera un JSON con las estadísticas de las verificaciones de ADN en el siguiente formato:
   {“count_mutations”:40, “count_no_mutation”: 100 : “ratio”:0.4}
 
Se puede probar en postman utilizando el siguiente boton: [![Run in Postman](https://run.pstmn.io/button.svg)](https://app.getpostman.com/run-collection/5ec3c0ae28ed10d4e51e)
 
