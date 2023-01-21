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
        Integer counter = 0;
        HashMap<String, String> data = new HashMap<String, String>();

        try {
            reader = new BufferedReader(new FileReader(file));
            String[] keys = new String[0];
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(cvsSplitBy);
                if (counter == 0) {
                    keys = row;
                    for (int i = 0; i < row.length ; i++) {
                        data.put(row[i], "");
                        counter++;
                    }
                }
                else {
                    for (int i = 0; i < row.length ; i++) {
                        data.replace(keys[i], row[i]);
                }
                }
            }
            System.out.println(data.get("SCOPUS_ID"));
            // System.out.println(keys);
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
