@echo off
call mvn clean package
call docker build -t com.maven.jee/projet .
call docker rm -f projet
call docker run -d -p 9080:9080 -p 9443:9443 --name projet com.maven.jee/projet