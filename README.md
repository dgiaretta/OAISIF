Create executable jar files

mvn build package

- WINDOWS: javaw -jar xxxxx.jar
  - jps - to get list of processes
  - taskkill /F /PID nnn
- UBUNTU:  $JAVA_HOME/bin/java -jar xxxx.jar &

On command line for running JAR one can set parameter e.g. add --server.port=xxxx

# DEFAULTS:
- GA: 8765
- RRORI: 8083
- SWITCHBOARD: 8085
- SPECIFIC ADAPTER: 8510

# SWITCHBOARD
http://www.oais.info:8085/api/SB/ArchiveNameAll
- note the one with archiveURL http://www.oais.info:8765

# GENERIC ADAPTER
http://www.oais.info:8765/api/GA/GetConfig
- shows the properties needed to communicate with the server

http://www.oais.info:8765/api/GA/GetProperty?name=MYDESCRIPTION
- to select the value of one of the properties

http://www.oais.info:8765/api/GA/AIPAll		
- returns table listing the AIPs and their Package Descriptions.
- The table is in the form of an array (i.e. the rows) of arrays (containing the values in the columns). The first row gives the names of the columns.
- Note that JSON arrays maintain the order of the elements see https://datatracker.ietf.org/doc/html/rfc8259#page-7

http://www.oais.info:8765/api/GA/GetAIP?aipid=xxxx 
- e.g. http://www.oais.info:8765/api/GA/GetAIP?aipid=1212093495 - returns JSON AIP for a FITS file with links to "reasonable" RepInfo etc.

http://www.oais.info:8765/api/GA/GetIO?aipid=xxxx   
- returns JSON containing the Information Object of that AIP

http://www.oais.info:8765/api/GA/GetDO?aipid=xxxx   
- returns JSON containing the (Content) Data Object of that AIP

http://www.oais.info:8765/v3/api-docs.yaml
- returns the YAML
- 
http://www.oais.info:8765/swagger-ui/index.html
- SWAGGER page which can ge used to test the interfaces


# SPECIFIC ADAPTER
http://www.oais.info:8510/api/SA/AIPAll
- list all the AIPs

# RRORI
http://www.oais.info:8083/api/RI/RIAll
- list all the pieces of RepInfo
- NOTE - this must be updated to be consistent with other interfaces. Should return Info Packages and use Identifiers

