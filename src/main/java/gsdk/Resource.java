package gsdk;

import org.jsfml.graphics.Font;
import org.jsfml.graphics.Texture;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;

import static javax.swing.GroupLayout.DEFAULT_SIZE;

public class Resource {

    public static String readDataFromStream(InputStream inputStream) {
        try {
            StringBuilder textBuilder = new StringBuilder();
            try (Reader reader = new BufferedReader(new InputStreamReader
                    (inputStream, StandardCharsets.UTF_8))) {
                int c = 0;
                while ((c = reader.read()) != -1) {
                    textBuilder.append((char) c);
                }
            }
            return textBuilder.toString();
        } catch (Exception e) {
            System.err.println("[GSDK ERROR] Data reading error");
        }
        return null;
    }

    public static InputStream getAsStream(String path) {
        try {
            return Resource.class.getResourceAsStream(path);
        } catch (Exception ignored) {
        }
        try {
            return Resource.class.getResourceAsStream("/" + path);
        } catch (Exception e) {
            System.err.println("[GSDK ERROR] Resource is not found");
        }
        return null;
    }

    public static Texture loadTexture(String path) {
        Texture texture = new Texture();
        try {
            texture.loadFromStream(getAsStream(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return texture;
    }

    public static Font loadFont(String path) {
        Font font = new Font();
        try {
            font.loadFromStream(getAsStream(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return font;
    }

}
