package Model.VQ;

/**
 * Created by batto on 10-Apr-17.
 */
public class VQExpression {
    String firstColor, secondColor;
    int firstGradient, secondGradient;

    VQNode vqRootNode;

    public String getFirstColor() {
        return firstColor;
    }

    public void setFirstColor(String firstColor) {
        this.firstColor = firstColor;
    }

    public String getSecondColor() {
        return secondColor;
    }

    public void setSecondColor(String secondColor) {
        this.secondColor = secondColor;
    }

    public int getFirstGradient() {
        return firstGradient;
    }

    public void setFirstGradient(int firstGradient) {
        this.firstGradient = firstGradient;
    }

    public void setFirstGradient(int firstGradient, boolean negative) {
        setFirstGradient(negative ? -firstGradient : firstGradient);
    }

    public int getSecondGradient() {
        return secondGradient;
    }

    public void setSecondGradient(int secondGradient) {
        this.secondGradient = secondGradient;
    }

    public void setSecondGradient(int secondGradient, boolean negative) {
        setSecondGradient(negative ? -secondGradient : secondGradient);
    }
}