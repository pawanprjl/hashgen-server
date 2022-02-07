#!/bin/bash -e

./gradlew clean bootJar

echo "starting docker build"
docker build -t hashgen-server:latest .

echo "starting container build"
docker container rm -f hashgen || true
docker image prune -f
docker run -d -p 8080:8080 --network hashgen --name hashgen hashgen-server
echo "completed deploying docker in local container"