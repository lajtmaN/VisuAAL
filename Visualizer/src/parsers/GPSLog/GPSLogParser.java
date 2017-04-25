package parsers.GPSLog;

import java.io.*;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by lajtman on 25-04-2017.
 */
public class GPSLogParser {
    public static List<SeedNode> parse(File gpsLogFile) throws IOException {
        return parseGPSLogLines(readContentFromFile(gpsLogFile));
    }

    private static List<String> readContentFromFile(File gpsLogFile) throws IOException {
        return Files.readAllLines(gpsLogFile.toPath());
    }

    public static List<SeedNode> parseGPSLogLines(List<String> gpsLogFileContent) {
        return gpsLogFileContent.stream()
                .map(GPSLogParser::parseGPSLogLine)
                .filter(c -> c != null)
                .collect(Collectors.toList());
    }

    public static SeedNode parseGPSLogLine(String gpsLogLine) {
        return new GPSLogLineParser(gpsLogLine).parse();
    }
}
