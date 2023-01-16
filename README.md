# maven-read-write-app

#### Create maven app

`mvn archetype:generate -DgroupId=com.mycompany.app -DartifactId=my-app -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4 -DinteractiveMode=false`

#### build maven app

`mvn archetype:generate -DgroupId=com.mycompany.app -DartifactId=my-app -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4 -DinteractiveMode=false`

#### Run app from shell

`cat dummy_data.txt | bash executable.sh`

#### compress app

Add executable file and jar file to a folder and compress the files folder
`tar -czvf ../maven1-app.tar.gz .`

#### create pipeline
```
CREATE PIPELINE url_pipeline_transform
AS LOAD DATA KAFKA '<kafka-url>:<kafka-port>/<topic-name>'
WITH TRANSFORM('https://raw.githubusercontent.com/Madhuri1518/maven-read-write-app/master/maven-app-transform.tar.gz','executable.sh','')
INTO TABLE test_transform
FIELDS TERMINATED BY ',';
```

If pipeline is in private repository
```
CREATE PIPELINE url_pipeline_transform
AS LOAD DATA KAFKA '<kafka-url>:<kafka-port>/<topic-name>'
WITH TRANSFORM('https://<github_username>:<github_token>@raw.githubusercontent.com/Madhuri1518/maven-read-write-app/master/maven-app-transform.tar.gz','executable.sh','')
INTO TABLE test_transform
FIELDS TERMINATED BY ',';
```
