package gsdk;

import java.util.ArrayList;

public class Tag {
    public static void register(String name) {
        App.tags.put(name, new ArrayList<>());
    }

    public static void addGameObject(String name, GameObject gameObject) {
        App.tags.get(name).add(gameObject);
    }


    public static void setPosition(String name, float x, float y) {
        for (GameObject gameObject : App.tags.get(name)) {
            gameObject.setPosition(x, y);
        }
    }

    public static void setScale(String name, float scaleX, float scaleY) {
        for (GameObject gameObject : App.tags.get(name)) {
            gameObject.setScale(scaleX, scaleY);
        }
    }

    public static void setOffset(String name, float offsetX, float offsetY) {
        for (GameObject gameObject : App.tags.get(name)) {
            gameObject.setOffset(offsetX, offsetY);
        }
    }

    public static void draw(String name) {
        for (GameObject gameObject : App.tags.get(name)) {
            gameObject.draw();
        }
    }
}
