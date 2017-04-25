package parsers.GPSLog;

import java.io.*;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by lajtman on 25-04-2017.
 */
public class GPSLogParser {
    public static SeedNodes parse(File gpsLogFile) throws IOException {
        return parseGPSLogLines(readContentFromFile(gpsLogFile));
    }

    private static List<String> readContentFromFile(File gpsLogFile) throws IOException {
        return Files.readAllLines(gpsLogFile.toPath());
    }

    public static SeedNodes parseGPSLogLines(List<String> gpsLogFileContent) {
        SeedNodes nodes = new SeedNodes();
        nodes.addRange(gpsLogFileContent.stream()
                .map(GPSLogParser::parseGPSLogLine)
                .filter(c -> c != null)
                .collect(Collectors.toList()));

        return nodes;
    }

    public static SeedNode parseGPSLogLine(String gpsLogLine) {
        return new GPSLogLineParser(gpsLogLine).parse();
    }
}
