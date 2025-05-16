package Utils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReadFile {


    public List<String> readcarregFile() throws IOException {

        List<String> matches = null;
        try {
            String filePath = System.getProperty("user.dir") + "\\TestData";
            File file = new File(filePath + "\\" + "car_input - V6" + ".txt");// Replace with your actual path

            String regex = "\\b[A-Z]{2}\\d{2}\\s[A-Z]{3}\\b"; // Example: FP79 FGR
            Pattern pattern = Pattern.compile(regex);
            matches = new ArrayList<>();

            FileInputStream fis = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader reader = new BufferedReader(isr);

            String line;
            int lineNumber = 1;

            while ((line = reader.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);

                while (matcher.find()) {
                    //System.out.println(matcher.group());
                    matches.add(matcher.group());
                }
                lineNumber++;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        return matches;
    }

    public Map<String, Map<String, String>> readcarregOutputFile() throws IOException {
        Map<String, Map<String, String>> carDataMap = new HashMap<>();
        String filePath = System.getProperty("user.dir") + "\\TestData\\car_output - V6" + ".txt";
        List<String> lines = Files.readAllLines(Paths.get(filePath));
        for (int i = 1; i < lines.size(); i++) {  // skip header (index 0)
            String line = lines.get(i);
            String[] parts = line.split(",", -1);
            if (parts.length >= 4) {
                String reg = parts[0].trim();
                Map<String, String> details = new HashMap<>();
                details.put("Make", parts[1].trim());
                details.put("Model", parts[2].trim());
                details.put("Year", parts[3].trim());
                carDataMap.put(reg, details);
                    }
                }

        return carDataMap;
    }
}
