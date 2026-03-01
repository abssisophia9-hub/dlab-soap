from zeep import Client

client = Client('../resources/LogAnalyzerService.wsdl').service
logFile = "src/main/resources/logs/app.log"

print("Analyzing access log file...")

count = loganalyzer.count()
print("Status Code Counts:", count)

distribution = loganalyzer.getDistribution()
print("Status Code Distribution:", distribution)
