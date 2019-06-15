#!/bin/bash
set -ex
cd /usr/local/app
exec java -jar "bin/spring-boot-kotlin-example.jar"

