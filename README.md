# maven-read-write-app

#### Create maven app

`mvn archetype:generate -DgroupId=com.mycompany.app -DartifactId=my-app -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4 -DinteractiveMode=false`

#### build maven app

`mvn clean package`

#### Run app from shell

`cat dummy_data.txt | bash executable.sh`

#### compress app

Add executable file and jar file to a folder and compress the files folder
`tar -czvf ../maven1-app.tar.gz .`

#### kafka pipeline
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

#### S3 pipeline
```
CREATE PIPELINE s3_tranform_data_pipeline
AS LOAD DATA S3 'singlestore-spike/hl7'
CONFIG '{"region": "us-east-1"}'
CREDENTIALS '{"aws_access_key_id": "xxx", "aws_secret_access_key": "xxxx"}'
WITH TRANSFORM('file://localhost/executable.sh','','')
INTO TABLE `test_patient`
FIELDS TERMINATED BY '\t';
```
