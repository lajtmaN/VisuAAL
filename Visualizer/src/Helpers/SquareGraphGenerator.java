package Helpers;

import org.graphstream.algorithm.generator.GridGenerator;

/**
 * Created by lajtman on 06-03-2017.
 */
public class SquareGraphGenerator extends GridGenerator {

    private int squareSize;

    public SquareGraphGenerator(boolean directed, int squareSize) {
        super(false, false, true, directed);
        this.squareSize = squareSize;
    }

    @Override
    protected String nodeName(int x, int y) {
        return String.valueOf(y * squareSize + x);
    }
}
