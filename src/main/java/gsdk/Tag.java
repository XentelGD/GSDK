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
            gameObject.x = x;
            gameObject.y = y;
            gameObject.applyChanges();
        }
    }

    public static void setOffset(String name, float offsetX, float offsetY) {
        for (GameObject gameObject : App.tags.get(name)) {
            gameObject.offsetX = offsetX;
            gameObject.offsetY = offsetY;
            gameObject.applyChanges();
        }
    }

    public static void draw(String name) {
        for (GameObject gameObject : App.tags.get(name)) {
            gameObject.draw();
        }
    }
}
