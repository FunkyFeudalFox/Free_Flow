package freeFlow.model;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * @author Arjan Tammer
 * @version 1.0 2/8/2018 21:52
 */
public class GameSaver {

    private Game model;

    Path resources = Paths.get("src" + File.separator + "resources");
    Path playerFile = Paths.get("src" + File.separator + "resources" + File.separator + "playerFile.txt");
    Path highScoresFile = Paths.get("src" + File.separator + "resources" + File.separator + "highScoresFile.txt");

    public GameSaver(Game model) {
        this.model = model;
    }

    public void createDirectoryAndFile(Path path)throws IOException {
            try{
                if (!Files.exists(resources)){
                    Files.createDirectories(resources);

                }
                if (!Files.exists(path)){
                    Files.createFile(path);
                }
            }
            catch (IOException e){
                throw new IOException("Unable to create file or directory " + playerFile, e);
            }
    }


    public void player2TxtFile(Player player) throws IOException {
        createDirectoryAndFile(playerFile);
        try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("src"
                + File.separator + "resources" + File.separator + "playerFile.txt")))) {
            pw.printf("%s#%s#%s#%d%n", player.getName(), player.getUsername(), player.getPassword(), player.getHighscore().getScore());
        } catch (IOException e) {
            throw new IOException("Unable to write to file " + playerFile, e);
        }

    }


    public void highScores2TxtFile(List <Score> highScores) throws IOException {
            createDirectoryAndFile(highScoresFile);
            try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("src"
                    + File.separator + "resources" + File.separator + "highScoresFile.txt")))) {
                for (Score score : model.getLevel().getHighScores())
                pw.printf("%s#%d%n", score.getPlayer().getUsername(), score.getScore());
            }
            catch (IOException e) {
                throw new IOException("Unable to write to file " + highScoresFile, e);
            }
    }



}
