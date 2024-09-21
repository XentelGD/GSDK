package examples.componentExample;

import gsdk.App;
import gsdk.GameObject;
import gsdk.Resource;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.graphics.Texture;
import org.jsfml.window.VideoMode;

public class Main {

    public static void main(String[] args)
    {
        App.window = new RenderWindow(new VideoMode(1000, 800), "MyWindow");

        Texture texture = Resource.loadTexture("/img/butterfly.png");
        GameObject gameObject = new GameObject(0, 0, texture);
        gameObject.setScale(0.1f, 0.1f);
        gameObject.addComponent("moving", new MovingComponent());

        while (App.window.isOpen()) {
            App.window.clear();
            App.checkEvents();

            gameObject.draw();

            App.window.display();
        }
    }
}
