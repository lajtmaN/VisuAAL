package Model.VQ;

import java.util.HashMap;

/**
 * Created by batto on 25-Apr-17.
 */
public class VQColors {
    private HashMap<Integer, String> colors = new HashMap<>();
    private String defaultColor;

    public String getDefaultColor() {
        return defaultColor;
    }

    public void setDefaultColor(String defaultColor) {
        this.defaultColor = defaultColor;
    }

    public void addColor(String color, int value) {
        colors.put(value, color);
    }

    public String getColorForValue(int value) {
        if(colors.containsKey(value))
            return colors.get(value);
        return defaultColor;
    }
}
