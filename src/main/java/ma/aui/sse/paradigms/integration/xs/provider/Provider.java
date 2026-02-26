package ma.aui.sse.paradigms.integration.xs.provider;

import jakarta.xml.ws.Endpoint;
import ma.aui.sse.paradigms.integration.xs.loganalysis.provider.LogAnalyzer;

public class Provider {

    public static void main(String[] args) {
        Endpoint.publish("http://localhost:9000/loganalyzer", new LogAnalyzer());
        System.out.println("Published at http://localhost:9000/loganalyzer");
        System.out.println("WSDL: http://localhost:9000/loganalyzer?wsdl");
    }
}
