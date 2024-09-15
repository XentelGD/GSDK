package examples;

import gsdk.App;
import gsdk.Resource;
import gsdk.mwidgets.ImageButton;
import gsdk.mwidgets.TextButton;
import org.jsfml.graphics.Font;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.graphics.Texture;
import org.jsfml.window.VideoMode;

public class ImageButtonExample {

    public static void main(String[] args)
    {
        App.window = new RenderWindow(new VideoMode(1000, 800), "MyWindow");
        // loading texture
        Texture texture = Resource.loadTexture("/img/button.png");

        ImageButton textButton = new ImageButton(100, 100, texture);
        // scaling button
        textButton.visualImage.setScale(0.5f, 0.5f);
        // setting onClick listener
        textButton.onClick = () -> {
            System.out.println("Hello!");
        };

        while (App.window.isOpen()) {
            App.window.clear();
            App.checkEvents();


            // drawing button
            textButton.draw();

            App.window.display();
        }
    }
}
