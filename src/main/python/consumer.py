from zeep import Client

client = Client("http://localhost:9000/loganalyzer?wsdl")
logFile = "src/main/resources/logs/app.log"

count = client.service.countByStatus(arg0=logFile)
print("ERROR:", count["errorCount"])
print("WARN: ", count["warnCount"])
print("INFO: ", count["infoCount"])
print("DEBUG:", count["debugCount"])

lines = client.service.filterByLevel(arg0=logFile, arg1="ERROR")
print("\nERROR lines:")
for line in (lines or []):
    print(" ", line)
