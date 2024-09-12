package examples;

import gsdk.*;
import org.jsfml.graphics.Color;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.graphics.Texture;
import org.jsfml.window.VideoMode;

public class GameObjectAndTagExample {
    public static void main(String[] args)
    {
        App.window = new RenderWindow(new VideoMode(1000, 800), "MyWindow");
        // registering 'butterflies' tag
        Tag.register("butterflies");

        // loading texture
        Texture texture = Resource.loadTexture("/img/butterfly.png");

        // creating all gameObjects
        for (int i = 0; i < 5000; i++) {
            GameObject gameObject = new GameObject(
                    (float)(Math.random() * App.window.getSize().x),
                    (float)(Math.random() * App.window.getSize().y),
                    texture
            );
            //                                    red  green blue alpha
            gameObject.sprite.setColor(new Color( 255,   0,  255,  100));
            gameObject.setScale(0.01f, 0.01f);

            // adding every gameObject to the tag
            Tag.addGameObject("butterflies", gameObject);
        }

        // creating an infinite timer
        Timer timer = new Timer(0f, Gsdk.INFINITY, () -> {
            // setting an offset to every object every frame
            Tag.setOffset(
                    "butterflies",
                    (float)(Math.random() * 25 - 12.5),
                    (float)(Math.random() * 25 - 12.5)
            );

        });
        timer.start();

        while (App.window.isOpen()) {
            App.checkEvents();
            App.window.clear();

            // displaying fps
            System.out.println(App.fps);

            // drawing all gameObjects in the tag
            Tag.draw("butterflies");

            App.window.display();
        }
    }
}
