#!/bin/sh
echo "********************************************************"
echo "Waiting for the eureka server to start on port $EUREKASERVER_PORT"
echo "********************************************************"
while ! `nc -z mockeureka $EUREKASERVER_PORT`; do sleep 3; done
echo "******* Eureka Server has started"

echo "********************************************************"
echo "Starting Service Server ********************************"
echo "********************************************************"
java -Dspring.application.name=server                               \
     -Dserver.port=8083                                             \
     -Deureka.instance.preferIpAddress=true                         \
     -Deureka.client.serviceUrl.defaultZone=$EUREKASERVER_URI       \
     -Deureka.client.registerWithEureka=true                        \
     -Deureka.client.fetchRegistry=true	                            \
     -jar /usr/local/server/@project.build.finalName@.jar