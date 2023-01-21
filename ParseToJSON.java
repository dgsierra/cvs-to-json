import java.io.*;
import java.util.HashMap;
public class ParseToJSON {
    public static void main(String[] args) {
        int passengers = 5;
        System.out.println(passengers);
        String file = "EjemploCSV.csv";
        BufferedReader reader = null;
        String line = "";
        String cvsSplitBy = ",";
        Integer counter = 22;
        HashMap<String, String> data = new HashMap<String, String>();

        try {
            reader = new BufferedReader(new FileReader(file));
            // System.out.println(reader.readLine());
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(cvsSplitBy);
                for (int i = 0; i < 20 ; i++) {
                    data.put(row[i], "");
                }
                System.out.println(data);
                System.out.println(data.keySet());
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

}

}
