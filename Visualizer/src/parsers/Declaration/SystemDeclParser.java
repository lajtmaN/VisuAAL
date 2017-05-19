package parsers.Declaration;

import Model.UPPAALProcess;
import org.antlr.v4.runtime.tree.TerminalNode;
import parsers.Declaration.ANTLRGenerated.uppaalBaseListener;
import parsers.Declaration.ANTLRGenerated.uppaalParser;

import java.util.ArrayList;

/**
 * Created by rasmu on 23/03/2017.
 */
public class SystemDeclParser extends uppaalBaseListener {
    public ArrayList<UPPAALProcess> getProcesses() {
        return processes;
    }

    private ArrayList<UPPAALProcess> instantiatedProcesses = new ArrayList<>();
    private ArrayList<UPPAALProcess> processes = new ArrayList<>();
    private boolean inProcDecl= false;
    private String templateName = null;
    private String processName = null;
    private String parameters = null;

    @Override
    public void enterInstantiation(uppaalParser.InstantiationContext ctx) {
        super.enterInstantiation(ctx);
        inProcDecl = true;
        processName = ctx.ID(0).getText();
        templateName = ctx.ID(1).getText();
        parameters = ctx.argList().getText();
    }

    @Override
    public void exitInstantiation(uppaalParser.InstantiationContext ctx) {
        super.exitInstantiation(ctx);
        instantiatedProcesses.add(new UPPAALProcess(templateName, processName, parameters));

        parameters = null;
        processName = null;
        templateName = null;
        inProcDecl = false;

    }

    @Override
    public void enterSystem(uppaalParser.SystemContext ctx) {
        super.enterSystem(ctx);
        for(TerminalNode id : ctx.ID()){
            if(id != null) {
                boolean instantiatedProcessFound = false;
                for(UPPAALProcess up : instantiatedProcesses){
                    if(id.getText().equals(up.getProcessName())){
                        instantiatedProcessFound = true;
                        processes.add(up);
                    }
                }
                if(!instantiatedProcessFound){
                    processes.add(new UPPAALProcess(id.getText(), null, null));
                }
            }
        }
    }
}
