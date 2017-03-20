package Model.topology.generator;

/**
 * Created by lajtman on 17-03-2017.
 */
public class TopologyGenerator {

    private GlobalOptions options;
    private CellOptions[][] cellOptions;

    public TopologyGenerator() {
        options = new GlobalOptions();
        initializeNewCellOptions(options.getCellX(), options.getCellY());
    }

    public GlobalOptions getOptions() {
        return options;
    }

    public void initializeNewCellOptions(int x, int y) {
        //TODO maybe save the old values from cellOptions array

        cellOptions = new CellOptions[x][y];

        for (int i = 0; i < x; i++)
            for (int j = 0; j < y; j++)
                cellOptions[i][j] = new CellOptions(options);
    }

    public CellOptions getOptionsForCell(int x, int y) {
        return cellOptions[x][y];
    }
}
