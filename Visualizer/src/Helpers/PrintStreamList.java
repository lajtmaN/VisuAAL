package Helpers;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by batto on 01-Jun-17.
 */
public class PrintStreamList extends PrintStream {
    private List<String> lines = new ArrayList<>();

    public PrintStreamList() {
        super(new ByteArrayOutputStream());
    }

    @Override
    public void println(String x) {
        lines.add(x);
    }

    public List<String> getLines() {
        return lines;
    }
}
