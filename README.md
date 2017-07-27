## springboot-kotlin-example
 
This is an example SpringBoot app using Kotlin.

* Springboot 1.5.2.RELEASE
* Jetty
* Java 8
* Kotlin 1.1.3
* Maven 3

## Running The App
```
mvn clean package
kotlin -jar target/springboot-kotlin-example.jar
```

## Running The App In Docker
This assumes you have a working docker environment

.Run the app inside docker
```
mvn clean package
docker build -t springboot-kotlin-example .
docker run springboot-kotlin-example
```

Note that this uses `supervisord` to run the app inside the docker container. The `app-supervisor.conf`
declares the `run-app.sh` as the command to actually run the executable jar. This allows you to
run other programs by adding entries in `app-supervisor.conf` or perhaps a different `supervisor.conf`
file, when the container runs.

.Run bash shell inside Docker (you know, to check some stuff)
----
docker run -i -t springboot-kotlin-example /bin/bash
----


Testing The Endpoint
--------------------
Point your browser to http://localhost:8080 or use `curl` in command line.

----
curl -v  http://localhost:8080/
----

JSON/XML Serialization Examples
-------------------------------

.GET JSON response
----
curl -v -H "Accept:application/json" http://localhost:8080/user/some-id
----

.GET XML response
----
curl -v -H "Accept:application/xml" http://localhost:8080/user/some-id
----

.PUT JSON request
----
curl -v  -X PUT  -H "Content-Type:application/json"  http://localhost:8080/user -d'{"username":"user","email":"user@example.com"}'
----

.PUT XML request
----
curl -v  -X PUT  -H "Content-Type:application/xml"  http://localhost:8080/user -d'<?xml version="1.0" encoding="UTF-8" standalone="yes"?><user><username>me</username><email>me@example.com</email></user>'
----

Makefile
--------
A wrapper Makefile can save some keystrokes =). Just type `make <target1> <target2> ...` (e.g. `make dist image` creates the jar and docker image)

.Makefile
----
default:
	cat ./Makefile
dist:
	mvn clean package
image:
	docker build -t jecklgamis/springboot-kotlin-example:latest .
run:
	docker run -p 8080:8080 jecklgamis/springboot-kotlin-example:latest
run-bash:
	docker run -i -t jecklgamis/springboot-kotlin-example:latest /bin/bash
----


Have fun!


