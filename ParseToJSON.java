import java.io.*;
import java.util.HashMap;
public class ParseToJSON {
    public static void main(String[] args) {
        String file = "EjemploCSV.csv";
        BufferedReader reader = null;
        BufferedWriter writer;
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
            try {
                writer = new BufferedWriter(new FileWriter("EjemploJSON.json"));
                writer.write("{");
                writer.newLine();
                for (int i = 0; i < keys.length; i++) {
                    writer.write("\"" + keys[i] + "\": \"" + data.get(keys[i]) + "\"");
                    if (i != keys.length - 1) {
                        writer.write(",");
                    }
                    writer.newLine();
                }
                writer.write("}");
                writer.close();
                System.out.println("JSON file created");
            } catch (IOException e) {
                e.printStackTrace();
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
