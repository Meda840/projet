#!/bin/sh
mvn clean package && docker build -t com.maven.jee/projet .
docker rm -f projet || true && docker run -d -p 9080:9080 -p 9443:9443 --name projet com.maven.jee/projet