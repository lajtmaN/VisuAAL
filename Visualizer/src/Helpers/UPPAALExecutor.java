package Helpers;

import Model.SimulateOutput;
import parsers.RegexHelper;
import parsers.SimulateParser;
import parsers.UPPAALParser;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by rasmu on 07/02/2017.
 */
public class UPPAALExecutor {

    private static UppaalSystem compileSystem(Engine eng, String filePath) throws EngineException, IOException {
        Document uppaalDocument = new PrototypeDocument().load(new URL("file", null, filePath));
        ArrayList<Problem> problems = new ArrayList<>();
        UppaalSystem sys = eng.getSystem(uppaalDocument, problems);
        if (!problems.isEmpty()) {
            //TODO Show warnings, maybe just "UPPAAL could not Compile"
            // problem.toString() contains the errors
        }
        return sys;
    }

    private static Engine getEngine() throws IOException, EngineException {
        //TODO SW-145 is about to refactor this out
        final String pathToUppaalEngine = "C:\\Program Files (x86)\\UPPAAL\\uppaal-4.1.19\\bin-Win32\\server.exe";
        Engine eng = new Engine();
        eng.setServerPath(pathToUppaalEngine);
        eng.setServerHost("localhost");
        eng.setConnectionMode(EngineStub.BOTH);
        eng.connect();
        return eng;
    }

    //TODO Refactor and use CompletableFuture<T> to run async
    public static SimulateOutput provideQueryResult(String modelPath, String query) throws IOException, EngineException {
        String simulateCountString = RegexHelper.getFirstMatchedValueFromRegex("simulate (\\d+)", query);
        if (simulateCountString == null)
            return null;

        File queryFile = UPPAALParser.generateQueryFile(query);
        Engine eng = getEngine();
        UppaalSystem upp = compileSystem(eng, modelPath);
        String options = "";
        eng.query(upp, options, query, new UppaalQueryFeedback());

<<<<<<< HEAD
<<<<<<< HEAD
        /*ProcessBuilder builder = new ProcessBuilder(
=======
=======
>>>>>>> parent of ac894bd... SW-139: Included uppaal models in application
        ProcessBuilder builder = new ProcessBuilder(
>>>>>>> parent of ac894bd... SW-139: Included uppaal models in application
                "cmd.exe", "/c", "lib\\verifyta.exe \"" + modelPath + "\" " + queryFile
        );
        builder.redirectErrorStream(true);
        try {
            Process p = builder.start();
            BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));

            String line;
            ArrayList<String> lines = new ArrayList<>();
            while ((line = r.readLine()) != null) {
                lines.add(line);
            }

            int simulateCount = Integer.parseInt(simulateCountString);
            return SimulateParser.parse(lines, simulateCount);

        } catch (IOException e) {
            e.printStackTrace();
        }*/
        return null;
    }

    private static class UppaalQueryFeedback implements QueryFeedback {
        @Override
        public void setProgressAvail(boolean b) {

        }

        @Override
        public void setProgress(int i, long l, long l1, long l2, long l3, long l4, long l5, long l6, long l7, long l8) {

        }

        @Override
        public void setSystemInfo(long l, long l1, long l2) {

        }

        @Override
        public void setLength(int i) {

        }

        @Override
        public void setCurrent(int i) {

        }

        @Override
        public void setTrace(char c, String s, ArrayList<SymbolicTransition> arrayList, int i, QueryVerificationResult queryVerificationResult) {

        }

        @Override
        public void setFeedback(String s) {
            if (s != null && s.length() > 0) {
                System.out.println(s);
            }
        }

        @Override
        public void appendText(String s) {
            if (s != null && s.length() > 0) {
                System.out.println(s);
            }
        }

        @Override
        public void setResultText(String s) {
            if (s != null && s.length() > 0) {
                System.out.println(s);
            }
        }
    }
}
