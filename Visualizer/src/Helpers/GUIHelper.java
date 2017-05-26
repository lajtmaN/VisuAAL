package Helpers;

import Model.Settings;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

import java.io.File;

/**
 * Created by batto on 10-Feb-17.
 */
public class GUIHelper {
    public static void showError(String error) {showAlert(Alert.AlertType.ERROR, error); }
    public static void showInformation(String information) {
        showAlert(Alert.AlertType.INFORMATION, information);
    }
    public static void showAlert(Alert.AlertType alertType, String message) {
        showAlert(alertType, message, "");
    }

    public static void showAlert(Alert.AlertType alertType, String message, String alertTitle){
        Alert alert = new Alert(alertType);
        alert.setHeaderText(message);
        alert.setTitle(alertTitle);
        alert.show();
    }

    public static boolean showPrompt(String message) {return showPrompt(message, "");}
    public static boolean showPrompt(String message, String promptTitle) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, message, ButtonType.YES, ButtonType.NO);
        alert.setTitle(promptTitle);
        alert.showAndWait();
        return alert.getResult() == ButtonType.YES;
    }

    public static void showExtendedInformation(String title, String resume, String largeDescription) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(title);
        alert.setContentText(resume);
        TextArea largeDescriptionField = new TextArea(largeDescription);
        largeDescriptionField.setEditable(false);
        largeDescriptionField.setWrapText(true);
        largeDescriptionField.setMaxWidth(Double.MAX_VALUE);
        largeDescriptionField.setMaxHeight(Double.MAX_VALUE);
        GridPane.setVgrow(largeDescriptionField, Priority.ALWAYS);
        GridPane.setHgrow(largeDescriptionField, Priority.ALWAYS);

        alert.getDialogPane().setExpandableContent(largeDescriptionField);

        alert.showAndWait();
    }

    public static String getVerifytaLocationFromUser() {
        String verifytaLocation = Settings.Instance().getVerifytaLocation();

        if (verifytaLocation != null && (
                verifytaLocation.endsWith("verifyta") || verifytaLocation.endsWith("verifyta.exe") //Win & Linux
        )) {
            if (new File(verifytaLocation).exists())
                return verifytaLocation;
        }

        File verifytaFile = FileHelper.chooseFileToLoad("Select verifyta executable from UPPAAL", null, ExtensionFilters.VerifytaExtensionFilter);
        if (verifytaFile == null)
            return null;

        verifytaLocation = verifytaFile.getPath();
        Settings.Instance().setVerifytaLocation(verifytaLocation);

        return verifytaLocation;
    }

    public static final String ShortVQHelp =
            "Following is a number of examples of VQs:\n" +
            "\n" +
            "[white, red] Node.OUTPUT_error\n" +
            "[black, green:*] OUTPUT_ready ? 0 : 1\n" +
            "[ghostwhite, black:1000] OUTPUT_elements_in_queue\n" +
            "[red:1, blue:2, green:3, black:*] node.OUTPUT_mode + gateway.OUTPUT_mode";

    public static final String VQHelp =
            "How to write VQ expressions:\n" +
            "* VQ expressions consist of two parts: a color specification and an expression.\n" +
            "* Conceptually, you write an expression, and the valuation of this expression is then used to lookup a color, depending on your color specification.\n" +
            "* A color specification can be either a gradient with an upper and lower bound (and color for each) OR a color list, consisting of values and the matching colors.\n" +
            "* For a gradient, valuations result in a mixed color between the two specified colors, where values outside of the bounds are rounded to either the upper or lower bound.\n" +
            "* For a color list, there must be a wildcard, which any non-specified values will choose.\n" +
            "* When a VQ is entered, the text entry box will have a red outline while the VQ is invalid, and blue while it is valid.\n" +
            "* The compile errors can be obtained by hovering over the text field.\n" +
            "\n" +
            "There are some limitations for VQs:\n" +
            "* You MUST use at least one output variable from your model, since the expression will otherwise be constant. If you absolutely NEED a constant expression, take any output variable, and multiply it by 0 and use this in your VQ.\n" +
            "* In a single VQ, you can only use either node output variables OR edge output variables, because it must be decidable which element in the graph to color.\n" +
            "* Note that ALL variables are treated as real numbers, where booleans are treated with the semantics known from C.\n" +
            "\n" +
            "The semantics for VQs is as naturally would be expected, and the syntax for VQs, presented in ANTLR4 format is as follows:\n" +
            "\n" +
            "grammar vq;\n" +
            "query\n" +
            "      : (gradient | colors)? exp EOF;\n" +
            "\n" +
            "gradient\n" +
            "      : '[' oneGradient ',' oneGradient ']';\n" +
            "\n" +
            "oneGradient \n" +
            "      : ID ':' NEG? NAT\n" +
            "      | ID;\n" +
            "\n" +
            "colors\n" +
            "      : '[' color+ ID ':' '*' ']';\n" +
            "\n" +
            "color\n" +
            "      : ID ':' NEG? NAT ',';\n" +
            "\n" +
            "exp \n" +
            "      : '(' exp ')'                                    #par\n" +
            "      | <assoc=right> op ='-' exp                      #unOp\n" +
            "      | <assoc=right> op ='!' exp                      #unOp\n" +
            "      | exp op=('*' | '/') exp                         #binOp\n" +
            "      | exp op=('+' | '-') exp                         #binOp\n" +
            "      | exp op=('<' | '<=' | '>' | '>=') exp           #binOp\n" +
            "      | exp op=('==' | '!=') exp                       #binOp\n" +
            "      | exp op='&&' exp                                #binOp\n" +
            "      | exp op='||' exp                                #binOp\n" +
            "      | <assoc=right> exp '?' exp ':' exp              #condOp\n" +
            "      | ID                                             #id\n" +
            "      | ID '.' ID                                      #idDot\n" +
            "      | NAT                                            #nat\n" +
            "      | FLOAT                                          #float\n" +
            "      | BOOL                                           #bool\n" +
            "      ;\n" +
            "\n" +
            "BOOL  : 'true' | 'false';\n" +
            "NEG   : '-';\n" +
            "ID    : [a-zA-Z_]([a-zA-Z0-9_])*;\n" +
            "NAT   : [0-9]+;\n" +
            "FLOAT : [0-9]+('.'[0-9]+)?;\n" +
            "WS    : [ \\n\\t\\r]+ -> channel(HIDDEN);";
}

