package Model;

/**
 * Created by rasmu on 23/03/2017.
 */
public class UPPAALProcess {
    String templateName;
    String processName;
    String parameter;


    public UPPAALProcess(String templateName, String processName, String parameter) {
        this.templateName = templateName;
        this.processName = processName;
        this.parameter = parameter;
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
        if(isInstantiatedProcess()) {
            return processName;
        }
        if(parameter== null)
            return templateName;
        return templateName + "("+parameter+")";
    }

    public String getTemplateName() {
        return templateName;
    }

    public boolean isInstantiatedProcess() {
        return processName != null;
    }
}
