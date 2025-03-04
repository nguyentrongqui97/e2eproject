package e2eproject.resources;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonReader {
    public static JSONObject readJson(String dataFilePath) throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        FileReader reader = new FileReader(dataFilePath);
        JSONObject jsonObject = (JSONObject) parser.parse(reader);
        return jsonObject;
    }
}
