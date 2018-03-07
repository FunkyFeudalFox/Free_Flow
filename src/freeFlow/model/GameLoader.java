package freeFlow.model;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Arjan Tammer
 * @version 1.0 3/6/2018 16:02
 */
public class GameLoader {
    private Game model;

    Path resources = Paths.get("src" + File.separator + "resources");
    Path playerFile = Paths.get("src" + File.separator + "resources" + File.separator + "playerFile.txt");
    Path highScoresFile = Paths.get("src" + File.separator + "resources" + File.separator + "highScoresFile.txt");

    public GameLoader (Game model) {
        this.model = model;
    }




}
