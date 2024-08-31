package examples;

import gsdk.App;
import gsdk.Draw;
import gsdk.mwidgets.TextButton;
import org.jsfml.graphics.Color;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.window.VideoMode;

public class DrawExample {
    public static void main(String[] args)
    {
        App.window = new RenderWindow(new VideoMode(1000, 800), "MyWindow");

        while (App.window.isOpen()) {
            App.checkEvents();
            App.window.clear();

            Draw.circle(0, 0, 200, new Color(144, 234, 21));

            App.window.display();
        }
    }
}