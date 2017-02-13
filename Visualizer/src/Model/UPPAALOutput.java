package Model;

/**
 * Created by lajtman on 07-02-2017.
 */
public class UPPAALOutput {

    private String errorDescription;

    public String getErrorDescription() {
        return errorDescription;
    }

    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }

    public Boolean errorState() {
        return !(errorDescription == null || errorDescription.length() == 0);
    }
}
