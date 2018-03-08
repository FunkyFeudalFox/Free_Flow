package freeFlow.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

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
                if (username == usernameFromTxtFile) {
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






}
