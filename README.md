# springboot-kotlin-example
An example Springboot app using Kotlin

[![Build Status](https://travis-ci.org/jecklgamis/springboot-kotlin-example.svg?branch=master)](https://travis-ci.org/jecklgamis/springboot-kotlin-example)

* Springboot 1.5.2.RELEASE
* Kotlin 1.1.3
* Java 8
* Maven 3

# Running The App
```
mvn clean package
java -jar target/springboot-kotlin-example.jar server src/main/resources/config.yml
```

# Running The App In Docker
This assumes you have a working docker environment

.Create docker image
```
docker build -t springboot-kotlin-example .
```

Run the app inside docker
```
docker run springboot-kotlin-example
```

Run bash shell inside docker (you know, to check some stuff)
```
docker run -i -t springboot-kotlin-example /bin/bash
```

