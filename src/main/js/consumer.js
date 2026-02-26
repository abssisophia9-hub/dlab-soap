"use strict";
const soap = require("soap");

async function main() {
    const client = await soap.createClientAsync("http://localhost:9000/loganalyzer?wsdl");
    const logFile = "src/main/resources/logs/app.log";

    const [countRes] = await client.countByStatusAsync({ filePath: logFile });
    const count = countRes["return"];
    console.log("ERROR:", count.errorCount);
    console.log("WARN: ", count.warnCount);
    console.log("INFO: ", count.infoCount);
    console.log("DEBUG:", count.debugCount);

    const [filterRes] = await client.filterByLevelAsync({ filePath: logFile, level: "ERROR" });
    const lines = filterRes["return"];
    console.log("\nERROR lines:");
    const arr = Array.isArray(lines) ? lines : (lines ? [lines] : []);
    for (const line of arr) console.log(" ", line);
}

main();
