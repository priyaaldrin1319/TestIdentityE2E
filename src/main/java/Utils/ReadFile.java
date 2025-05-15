import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReadFile {


    public String readFile(String fileName) throws IOException {

        Matcher matcher = null;
        try {
            String filePath = System.getProperty("user.dir") + "\\TestData";
            File file = new File(filePath + "\\" + fileName + ".txt");// Replace with your actual path
            String regex = "\\b[A-Z]{2}\\d{2}\\s[A-Z]{3}\\b"; // Example: FP79 FGR
            Pattern pattern = Pattern.compile(regex);

            FileInputStream fis = new FileInputStream(filePath);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader reader = new BufferedReader(isr);

            String line;
            int lineNumber = 1;

            while ((line = reader.readLine()) != null) {
                matcher = pattern.matcher(line);

                while (matcher.find()) {
                    System.out.println(matcher.group());
                }
                lineNumber++;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        return matcher.group();
    }
}
