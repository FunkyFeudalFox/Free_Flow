package freeFlow.model;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Arjan Tammer
 * @version 1.0 2/8/2018 21:52
 */
public class GameSaver {

    Path resources = Paths.get("src" + File.separator + "resources");
    Path playerFile = Paths.get("src" + File.separator + "resources" + File.separator + "playerFile.txt");


        public void createDirectoriesAndFiles()throws IOException {
            try{
                if (!Files.exists(resources)){
                    Files.createDirectories(resources);

                }
                if (!Files.exists(playerFile)){
                    Files.createFile(playerFile);
                }
            }
            catch (IOException e){
                throw new IOException("Unable to create file or directory " + playerFile, e);
            }
        }



    public void player2TxtFile(Player player) throws IOException {
        createDirectoriesAndFiles();
        try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("src"
                + File.separator + "resources" + File.separator + "playerFile.txt")))) {
            pw.printf("%s#%s#%s#%d%n", player.getName(), player.getUsername(), player.getPassword(), player.getHighscore().getScore());
        } catch (IOException e) {
            throw new IOException("Unable to write to file " + playerFile, e);
        }

    }


}
