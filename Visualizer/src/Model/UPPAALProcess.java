package Model;

/**
 * Created by rasmu on 23/03/2017.
 */
public class UPPAALProcess {
    String templateName;
    String processName;
    String parameter;
    boolean instantiatedProcess;

    public boolean isInstantiatedProcess() {
        return instantiatedProcess;
    }

    public UPPAALProcess(String templateName, String processName, String parameter, boolean instantiatedProcess) {
        this.templateName = templateName;
        this.processName = processName;
        this.parameter = parameter;
        this.instantiatedProcess = instantiatedProcess;
    }

    public String getProcessName() {
        return processName;
    }

    public void setProcessName(String name) {
        this.processName = name;
    }

    public String getParameter() {
        return parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }

    public String getProcessQueryIdentifier() {
        if(instantiatedProcess) {
            return processName;
        }
        if(parameter== null)
            return templateName;
        return templateName + "("+parameter+")";
    }

    public String getTemplateName() {
        return templateName;
    }
}
