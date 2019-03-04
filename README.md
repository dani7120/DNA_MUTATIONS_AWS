# DNA_MUTATIONS_AWS
aws rest api 
El proyecto fue desarrollado utilizando lo siguiente:
 - Netbeans 8.2
 - Java 8
 - SpringBoot 2.1.3.RELEASE
 - Jacoco 0.8.2
 - Hibernate 5
 
# Instrucciones:

1. Descargar el codigo y ejecutar con maven las siguientes instrucciones
  - mvn clean install
  - mvn package  
  - java -jar mutations-0.0.1-SNAPSHOT.jar (target)

# Code coverage

1. Abrir una terminal y posicionarse  en la misma ruta en la que se encuentra el pom.xml del proyecto
2. ejecutar la siguiente instruccion:
  - mvn jacoco:report
3. una vez terminado la ejecucion entrar a la siguiente ruta y abrir el index.html  target/site/jacoco/index.html 

- code coverage actual: 85%

# Aplicacion deployada en aws.

Endpoints:
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
 
