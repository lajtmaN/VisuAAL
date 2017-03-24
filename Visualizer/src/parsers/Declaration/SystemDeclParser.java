package parsers.Declaration;

import Model.UPPAALProcess;
import org.antlr.v4.runtime.tree.TerminalNode;
import parsers.Declaration.ANTLRGenerated.uppaalBaseListener;
import parsers.Declaration.ANTLRGenerated.uppaalParser;
import parsers.RegexHelper;

import java.util.ArrayList;
import java.util.Optional;

/**
 * Created by rasmu on 23/03/2017.
 */
public class SystemDeclParser extends uppaalBaseListener {
    public ArrayList<UPPAALProcess> getProcesses() {
        return processes;
    }

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
        processes.add(new UPPAALProcess(templateName, processName, parameters));

        parameters = null;
        processName = null;
        templateName = null;
        inProcDecl = false;

    }

    @Override
    public void enterSystem(uppaalParser.SystemContext ctx) {
        super.enterSystem(ctx);
        for(TerminalNode id : ctx.ID()){
            if(id != null && processes.stream().noneMatch(p -> p.getProcessName() != null && p.getProcessName().equals(id.getText()))){
                processes.add(new UPPAALProcess(id.getText(), null, null));
            }
        }
    }
}
