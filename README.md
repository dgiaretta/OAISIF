Create executable jar files

mvn build package

- WINDOWS: javaw -jar xxxxx.jar
  - jps - to get list of processes
  - taskkill /F /PID nnn
- UBUNTU:  $JAVA_HOME/bin/java -jar xxxx.jar &

DEFAULTS:
- GA: 8765
- RRORI: 8083

GENERIC ADAPTER
http://www.oais.info:8765/api/GA/GetConfig

http://www.oais.info:8765/api/GA/GetProperty?name=MYDESCRIPTION

http://www.oais.info:8765/api/GA/AIPAll

http://www.oais.info:8765/api/GA/GetAIP?aipid=xxxx 



http://www.oais.info:8765/api/GA/GetIO?aipid=xxxx   - returns JSON containing the Information Object of that AIP

http://www.oais.info:8765/api/GA/GetDO?aipid=xxxx   - returns JSON containing the (Content) Data Object of that AIP

http://www.oais.info:8765/v3/api-docs.yaml

http://www.oais.info:8765/swagger-ui/index.html


SPECIFIC ADAPTER
http://www.oais.info:8510/api/SA/AIPAll

RRORI
http://www.oais.info:8083/RIAll

SWITCHBOARD
http://www.oais.info:8085/api/SB/ArchiveNameAll

On command line for running JAR can set parameter e.g. add --server.port=xxxx