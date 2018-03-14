package freeFlow.model;

import com.sun.media.jfxmedia.events.PlayerStateEvent;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

/**
 * @author Arjan Tammer
 * @version 1.0 2/8/2018 21:52
 */
public class GameSaver {



    Path resources = Paths.get("src" + File.separator + "resources");
    Path playerFile = Paths.get("src" + File.separator + "resources" + File.separator + "playerFile.txt");
    Path highScoresFile = Paths.get("src" + File.separator + "resources" + File.separator + "highScoresFile.txt");
    Path gameFile = Paths.get("src" + File.separator + "resources" + File.separator + "gameFile.csv");

    List<Player> playerList;




    public GameSaver() {
        try{
            playerList = playerFile2List();
        }
        catch (IOException e){
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
        }
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
                throw new IOException("Unable to create file or directory " + path, e);
            }
    }

    public static List<Player> playerFile2List() throws IOException {
        List<Player> playerList = new ArrayList<>();
        String line = "";
        try (BufferedReader br = new BufferedReader(new FileReader("src"
                + File.separator + "resources" + File.separator + "playerFile.txt"))) {
            while ((line = br.readLine()) != null) {
                StringTokenizer tokenizer = new StringTokenizer(line, "#");
                String name = tokenizer.nextToken();
                String username = tokenizer.nextToken();
                String password = tokenizer.nextToken();
                int score = Integer.parseInt(tokenizer.nextToken());
                Player currentPlayer = new Player(name, username, password, score);
                playerList.add(currentPlayer);
            }
            return playerList;
        } catch (IOException e) {
            throw new IOException("File can't be opened" + e);
        }
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    public void playerList2TxtFile(List<Player> playerList) throws IOException {
        createDirectoryAndFile(playerFile);
        try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("src"
                + File.separator + "resources" + File.separator + "playerFile.txt")))) {
            for (Player player : playerList)
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

    public static ObservableList<String> txtFile2LoginList() throws IOException{
        ObservableList<String> playerList = FXCollections.observableArrayList();
        String line = "";
        try (BufferedReader br = new BufferedReader(new FileReader("src"
                + File.separator + "resources" + File.separator + "playerFile.txt"))) {
            while ((line = br.readLine()) != null){
                StringTokenizer tokenizer = new StringTokenizer(line, "#");
                String unused = tokenizer.nextToken();
                String username = tokenizer.nextToken();
                unused = tokenizer.nextToken();
                String unusedNumber = tokenizer.nextToken();
                playerList.add(username);
            }
            return playerList;
        }
        catch (NoSuchElementException | NumberFormatException e1) {
            throw new IOException("Read error in line: " + line, e1);
        } catch (IOException e2) {
            throw new IOException("Source file " + line + " can't be opened", e2);
        }
    }

    public static String lookUpPasswordForUsername(String username) throws IOException{
        String line = "";
        try (BufferedReader br = new BufferedReader(new FileReader("src"
                + File.separator + "resources" + File.separator + "playerFile.txt"))) {
            while ((line = br.readLine()) != null) {
                StringTokenizer tokenizer = new StringTokenizer(line, "#");
                String unused = tokenizer.nextToken();
                String usernameFromTxtFile = tokenizer.nextToken();
                String password = tokenizer.nextToken();
                unused = tokenizer.nextToken();
                if (username.equals(usernameFromTxtFile)) {
                    return password;
                }
            }
            return "0";
        }
        catch (NoSuchElementException | NumberFormatException e1) {
            throw new IOException("Read error " + e1);
        } catch (IOException e2) {
            throw new IOException("Source file can't be opened", e2);
        }
    }

    public Player assignPlayer(String username) throws IOException{
        String line = "";
        try (BufferedReader br = new BufferedReader(new FileReader("src"
                + File.separator + "resources" + File.separator + "playerFile.txt"))) {
            while ((line = br.readLine()) != null) {
                StringTokenizer tokenizer = new StringTokenizer(line, "#");
                String name = tokenizer.nextToken();
                String usernameFromTxtFile = tokenizer.nextToken();
                String password = tokenizer.nextToken();
                int score = Integer.parseInt(tokenizer.nextToken());
                if (username.equals(usernameFromTxtFile)) {
                    Player player = new Player(name, username, password, score);
                    return player;
                }
            }
        }
        return new Player("0", "0", "0", 0);
    }

    public static String showHighScores() throws IOException{
        StringBuilder sb = new StringBuilder();
        String line = "";
        try (BufferedReader br = new BufferedReader(new FileReader("src"
                + File.separator + "resources" + File.separator + "highScoresFile.txt"))) {
            while ((line = br.readLine()) != null) {
                StringTokenizer tokenizer = new StringTokenizer(line, "#");
                String username = tokenizer.nextToken();
                String score = tokenizer.nextToken();
                sb.append(String.format("%s %s\n", username, score));
            }
            return sb.toString();
        }
        catch (NoSuchElementException | NumberFormatException e1) {
            throw new IOException("Read error " + e1);
        } catch (IOException e2) {
            throw new IOException("Source file can't be opened", e2);
        }
    }

    public void saveGame2CSV() throws IOException {
        createDirectoryAndFile(gameFile);
        String line = "";
        try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter("src"
                + File.separator + "resources" + File.separator + "gameFile.csv"))){
                //
                //
                //fileWriter.append()
                //

            StringTokenizer tokenizer = new StringTokenizer(line, "#");
            //
            //for-loop om Level.playingField op te slaan
            //

        }

    }

    public void loadGame() throws IOException {

    }

}
