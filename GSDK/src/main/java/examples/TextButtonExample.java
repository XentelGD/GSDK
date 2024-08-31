package examples;

import gsdk.App;
import gsdk.Localization;
import gsdk.mwidgets.Listener;
import gsdk.mwidgets.TextButton;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.window.VideoMode;

public class TextButtonExample {

    public static void main(String[] args)
    {
        App.window = new RenderWindow(new VideoMode(1000, 800), "MyWindow");

        TextButton textButton = new TextButton("Hello!", 10, 10, 300, 140);
        textButton.onClick = () -> {
            System.out.println("Hello!");
        };

        while (App.window.isOpen()) {
            App.checkEvents();
            App.window.clear();

            textButton.draw();

            App.window.display();
        }
    }
}
