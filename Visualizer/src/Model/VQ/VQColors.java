package Model.VQ;

import Helpers.Pair;

import java.util.ArrayList;

/**
 * Created by batto on 25-Apr-17.
 */
public class VQColors {
    private ArrayList<Pair<Double, String>> colors = new ArrayList<>();
    private String defaultColor;

    public String getDefaultColor() {
        return defaultColor;
    }

    public void setDefaultColor(String defaultColor) {
        this.defaultColor = defaultColor;
    }

    public void addColor(String color, double value) {
        colors.add(new Pair<>(value, color));
    }

    public String getColorForValue(double value) {
        for(Pair<Double, String> p : colors) {
            if(value == p.getFirst())
                return p.getSecond();
        }

        return getDefaultColor();
    }
}
