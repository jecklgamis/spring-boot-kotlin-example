default:
	cat ./Makefile
dist:
	mvn clean package
image:
	docker build -t jecklgamis/springboot-kotlin-example:latest .
run:
	docker run -p 8080:8080  -p 8081:8081 jecklgamis/springboot-kotlin-example:latest
run-bash:
	docker run -i -t jecklgamis/springboot-kotlin-example:latest /bin/bash
