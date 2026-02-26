package ma.aui.sse.paradigms.integration.xs.loganalysis.provider;

import jakarta.jws.WebService;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@WebService
public class LogAnalyzer {

    public StatusCount countByStatus(String filePath) {
        List<String> lines = readFile(filePath);
        int error = 0, warn = 0, info = 0, debug = 0;
        for (String line : lines) {
            if (line.contains("ERROR")) error++;
            else if (line.contains("WARN")) warn++;
            else if (line.contains("INFO")) info++;
            else if (line.contains("DEBUG")) debug++;
        }
        return new StatusCount(error, warn, info, debug);
    }

    public String[] filterByLevel(String filePath, String level) {
        List<String> lines = readFile(filePath);
        List<String> result = new ArrayList<>();
        for (String line : lines) {
            if (line.contains(level.toUpperCase())) result.add(line);
        }
        return result.toArray(new String[0]);
    }

    private List<String> readFile(String filePath) {
        try {
            return Files.readAllLines(Paths.get(filePath));
        } catch (Exception e) {
            throw new RuntimeException("Cannot read file: " + filePath);
        }
    }
}
