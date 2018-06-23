#!/bin/sh
echo "********************************************************"
echo "Starting the Eureka Server"
echo "********************************************************"
java -Dserver.port=8761														\
	 -Deureka.client.registerWithEureka=false								\
	 -Deureka.client.fetchRegistry=false									\
	 -Deureka.server.waitTimeInMsWhenSyncEmpty=0							\
	 -Deureka.serviceUrl.defaultZone=http://localhost:8761           		\
     -jar /usr/local/eureka/@project.build.finalName@.jar
