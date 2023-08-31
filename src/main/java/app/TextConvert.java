package app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TextConvert {


    private String content;

    public TextConvert(String path){
        content = loadTxtTemplate(path);
    }
    private String loadTxtTemplate(String path) {
        try (InputStream inputStream = getClass().getResourceAsStream(path);
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line);
            }
            return content.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    public TextConvert textReplace(String key,String value){
        content = content.replace("{"+key+"}", value);
        return this;
    }

    public String getContent() {
        return content;
    }
}
