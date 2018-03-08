package freeFlow.model;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.StringTokenizer;

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


    public void highScore2TxtFile(Score highscore) throws IOException {
            createDirectoryAndFile(highScoresFile);
        String line = "";
        try (BufferedReader br = new BufferedReader(new FileReader("src"
                + File.separator + "resources" + File.separator + "highScoresFile.txt"))) {
            while ((line = br.readLine()) != null){
                StringTokenizer tokenizer = new StringTokenizer(line, "#");
                String username = tokenizer.nextToken();
                String score = tokenizer.nextToken();
                if ((highscore.getPlayer().getUsername() != username) ||
                        (highscore.getPlayer().getUsername() == username && Integer.toString(highscore.getScore()) !=  score) ){
                    try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("src"
                            + File.separator + "resources" + File.separator + "highScoresFile.txt")))) {
                        pw.printf("%s#%d%n", highscore.getPlayer().getUsername(), highscore.getScore());
                    }
                    catch (IOException e) {
                        throw new IOException("Unable to write to file " + highScoresFile, e);
                    }
                }
            }
        }
        catch (IOException e2){
            throw new IOException("Unable to write to file " + highScoresFile, e2);
        }

    }



}
