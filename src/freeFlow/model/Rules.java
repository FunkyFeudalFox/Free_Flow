package freeFlow.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Rules {
    public static final String RULES_FILE = "rules.txt";

    private String rules = "";

    public Rules() throws FreeFlowException {
        try (BufferedReader reader = new BufferedReader(new FileReader("src"
                + File.separator + "resources" + File.separator + RULES_FILE))) {
            String line = "";
            while ((line = reader.readLine()) != null) {
                rules += line + "\n";
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new FreeFlowException("De spelregels konden niet gevonden worden...");
        }
    }

    public String getRules() {
        return rules;
    }
}
