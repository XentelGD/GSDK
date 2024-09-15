package examples;

import gsdk.App;
import gsdk.Resource;
import gsdk.mwidgets.TextButton;
import org.jsfml.graphics.Font;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.window.VideoMode;

public class TextButtonExample {

    public static void main(String[] args)
    {
        App.window = new RenderWindow(new VideoMode(1000, 800), "MyWindow");
        Font font = Resource.loadFont("/font/roboto-m.ttf");

        TextButton textButton = new TextButton("Hello!", font, 10, 10, 300, 140);
        textButton.onClick = () -> {
            System.out.println("Hello!");
        };

        while (App.window.isOpen()) {
            App.window.clear();
            App.checkEvents();

            textButton.draw();

            App.window.display();
        }
    }
}
