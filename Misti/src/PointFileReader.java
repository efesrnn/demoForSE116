import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class PointFileReader {
    private HashMap<String, Integer> pointValues;

    public PointFileReader(String filename) {
        pointValues = new HashMap<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\efese\\OneDrive\\Masaüstü\\points.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\s+"); // Change the delimiter to whitespace (or another delimiter if needed)
                String key = parts[0].trim();
                int value = Integer.parseInt(parts[1].trim());
                pointValues.put(key, value);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getPointValue(Card card) {
        String identifier = card.getSuit() + card.getNumber(); // Change this to the desired identifier
        return pointValues.getOrDefault(identifier, 0); // Returns 0 if the identifier is not in the HashMap
    }
}