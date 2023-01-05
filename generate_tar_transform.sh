#!/bin/bash
rm maven-app-transform.tar.gz
mvn package
mkdir temp
cd temp
cp ../executable.sh .
cp ../target/my-app-1.0-SNAPSHOT.jar .
tar -czvf ../maven-app-transform.tar.gz .
cd ..
rm -rf temp