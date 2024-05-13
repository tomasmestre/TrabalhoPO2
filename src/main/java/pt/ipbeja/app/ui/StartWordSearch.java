package pt.ipbeja.app.ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pt.ipbeja.app.model.WSModel;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Start a game with a hardcoded board
 * @author anonymized
 * @version 2024/04/14
 */
public class StartWordSearch extends Application {
    public final static String filePath = "C:/Users/tomas/OneDrive/Documents/1ºAno/PO2/Trabalho/src/main/resources/matriz.csv";
    @Override
    public void start(Stage primaryStage) {

        Map<String, String> mapFromFile = HashMapFromTextFile();

        for (Map.Entry<String, String> entry :
                mapFromFile.entrySet()) {
            System.out.println(entry.getKey() + " : "
                    + entry.getValue());
        }

//        ArrayList<String> boardContent = readWordsFromCSV("C:/Users/tomas/OneDrive/Documents/1ºAno/PO2/Trabalho/src/main/resources/matriz.csv");
//        Collections.shuffle(boardContent);



        // Create WSModel and WSBoard objects
        WSModel WSModel = new WSModel(boardContent);
        WSBoard WSBoard = new WSBoard(WSModel);


        primaryStage.setScene(new Scene(WSBoard));

        WSModel.registerView(WSBoard);
        WSBoard.requestFocus(); // to remove focus from first button
        primaryStage.show();
    }

    public static Map<String, String> HashMapFromTextFile()
    {

        Map<String, String> map
                = new HashMap<String, String>();
        BufferedReader br = null;

        try {

            // create file object
            File file = new File(filePath);

            // create BufferedReader object from the File
            br = new BufferedReader(new FileReader(file));

            String line = null;

            // read file line by line
            while ((line = br.readLine()) != null) {

                // split the line by :
                String[] parts = line.split(":");

                // first part is name, second is number
                String name = parts[0].trim();
                String number = parts[1].trim();

                // put name, number in HashMap if they are
                // not empty
                if (!name.equals("") && !number.equals(""))
                    map.put(name, number);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {

            // Always close the BufferedReader
            if (br != null) {
                try {
                    br.close();
                }
                catch (Exception e) {
                };
            }
        }

        return map;
    }

    private static ArrayList<String> readWordsFromCSV(String filename) {
        ArrayList<String> words = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                words.add(line.trim()); // Assuming one word per line in the CSV file
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return words;
    }

    /**
     * @param args  not used
     */
    public static void main(String[] args) {
        Application.launch(args);
    }
}
