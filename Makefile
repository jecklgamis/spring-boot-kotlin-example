default:
	cat ./Makefile
dist:
	./mvnw clean package
image:
	docker build -t spring-boot-kotlin-example:latest .
run:
	docker run -p 8080:8080 -p 8443:8443 spring-boot-kotlin-example:latest
run-bash:
	docker run -i -t spring-boot-kotlin-example:latest /bin/bash
