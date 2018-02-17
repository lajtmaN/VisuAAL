package parsers.GPSLog;

import exceptions.GPSLogParseException;

import java.io.*;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by lajtman on 25-04-2017.
 */
public class GPSLogParser {
    public static GPSLogNodes parse(File gpsLogFile) throws IOException {
        return parseGPSLogLines(readContentFromFile(gpsLogFile));
    }

    private static List<String> readContentFromFile(File gpsLogFile) throws IOException {
        return Files.readAllLines(gpsLogFile.toPath());
    }

    public static GPSLogNodes parseGPSLogLines(List<String> gpsLogFileContent) {
        GPSLogNodes nodes = new GPSLogNodes();
        nodes.addRange(gpsLogFileContent.stream()
                .map(GPSLogParser::parseGPSLogLine)
                .filter(c -> c != null)
                .collect(Collectors.toList()));
        nodes.setEarliestTimestampAsZeroOnAllEntries();
        nodes.validateNodeIds();

        return nodes;
    }

    public static GPSLogEntry parseGPSLogLine(String gpsLogLine) {
        return new GPSLogLineParser(gpsLogLine).parse();
    }
}
