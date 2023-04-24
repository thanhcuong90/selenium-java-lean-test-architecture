package com.eliasnogueira.helper;
import org.json.JSONArray;
import org.json.JSONObject;

public class Utils {
    public static JSONObject getResources(String fileName) {
        String path = "testData/" + fileName;
        String json = "";
        try {
            InputStream is = Utils.class.getClassLoader().getResourceAsStream(path);
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
                json = reader.lines().collect(Collectors.joining("\n"));
            }
        } catch (IOException ignored) {
        }

        return new JSONObject(json);
    }
}
