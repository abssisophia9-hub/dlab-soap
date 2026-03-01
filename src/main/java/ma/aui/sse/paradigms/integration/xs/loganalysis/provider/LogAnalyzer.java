package loganalyzer.provider;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.*;

@WebService
public class LogAnalyzer {

    @WebMethod
    public Integer count() {

        this.log("Count method has been invoked");

        Path filePath = Paths.get("src/main/resources/access-log.txt");
        int lineCount = 0;
        try {
            lineCount = (int) Files.lines(filePath).count();
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }

        return lineCount;
    }

    @WebMethod
    public List<StatusCount> getDistribution() {

        this.log("GetDistribution method has been invoked");

        List<StatusCount> result = new ArrayList<>();
        Path filePath = Paths.get("src/main/resources/access-log.txt");

        try {
            Files.lines(filePath).forEach(line -> {
                String[] parts = line.split(" ");
                if (parts.length >= 2) {
                    String statusCode = parts[parts.length - 2];

                    Optional<StatusCount> existing = result.stream()
                            .filter(sc -> sc.getStatus().equals(statusCode))
                            .findFirst();

                    if (existing.isPresent()) {
                        existing.get().setCount(existing.get().getCount() + 1);
                    } else {
                        result.add(new StatusCount(statusCode, 1));
                    }
                }
            });
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }

        return result;
    }

    public void log(String message) {
        System.out.println("LogAnalyzer: " + message);
    }
}
