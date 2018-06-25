#!/bin/sh
echo "********************************************************"
echo "Waiting for the eureka server to start on port $EUREKASERVER_PORT"
echo "********************************************************"
while ! `nc -z mockeureka $EUREKASERVER_PORT`; do sleep 3; done
echo "******* Eureka Server has started"

echo "********************************************************"
echo "Starting Service Client ********************************"
echo "********************************************************"
java -Dspring.application.name=client                           \
     -Dserver.port=8085                                         \
     -Deureka.instance.preferIpAddress=true                     \
     -Deureka.client.serviceUrl.defaultZone=$EUREKASERVER_URI   \
     -Deureka.client.registerWithEureka=true                    \
     -Deureka.client.fetchRegistry=true                         \
     -jar /usr/local/client/@project.build.finalName@.jar