package voidcube.quests.tools;

import java.io.*;
import java.util.HashMap;
import java.util.Optional;

public class FileTools {

    public static HashMap<String, Integer> progress = new HashMap<>();

    public static void WriteProgress(){
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(new File(System.getProperty("user.dir") + "/plugins/Quests/progress.txt")));
            for (String key : progress.keySet()) {
                bw.write(key + " " + progress.get(key));
                bw.newLine();
            }
            bw.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static void GetProgress(){
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File(System.getProperty("user.dir") + "/plugins/Quests/progress.txt")));
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.length() > 0) {
                    progress.put(line.split(" ")[0], Integer.parseInt(line.split(" ")[1]));
                }
            }
            reader.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void SetProgress(String nick, Integer num) {
        progress.put(nick, num);
        WriteProgress();
    }

    public static void CheckNew(String nick) {

        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File(System.getProperty("user.dir") + "/plugins/Quests/progress.txt")));
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.length() > 0) {
                    progress.put(line.split(" ")[0], Integer.parseInt(line.split(" ")[1]));
                }
            }
            Optional.of(reader);
            reader.close();

            if (!progress.containsKey(nick)) {
                progress.put(nick, 0);

                BufferedWriter bw = new BufferedWriter(new FileWriter(new File(System.getProperty("user.dir") + "/plugins/Quests/progress.txt")));
                for (String key : progress.keySet()) {
                    bw.write(key + " " + progress.get(key));
                    bw.newLine();
                }
                bw.close();

            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
