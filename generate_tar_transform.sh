#!/bin/bash
#mv maven-app-transform.tar.gz maven-app-transform-old.tar.gz
mvn package
mkdir temp
cd temp
cp ../executable.sh .
cp ../target/my-app-1.0-SNAPSHOT.jar .
tar -czvf ../maven-app-transform.tar.gz .
rm -rf temp