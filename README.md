Create executable jar files

mvn build package

- WINDOWS: javaw -jar xxxxx.jar
  - jps - to get list of processes
  - taskkill /F /PID nnn
- UBUNTU:  $JAVA_HOME/bin/java -jar xxxx.jar &

DEFAULTS:
- GA: 8765
- RRORI: 8083

http://176.31.232.21:8765/api/GA/AIPAll    to list all AIP

http://176.31.232.21:8765/api/GA/GetConfig  to list config params

OPEN API documentation on localhost
- http://localhost:8765/v3/api-docs
  - Show the Open API docs
- http://localhost:8765/v3/api-docs.yaml
  - generate the YAML file 
- http://localhost:8765/swagger-ui/index.html
  - Show the swagger documentation

