package examples;

import gsdk.App;
import gsdk.FMouse;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.window.VideoMode;

public class FMouseExample {
    public static void main(String[] args)
    {
        App.window = new RenderWindow(new VideoMode(1000, 800), "MyWindow");

        while (App.window.isOpen()) {
            App.window.clear();
            App.checkEvents();


            System.out.println("X: " + FMouse.x + "   Y:" + FMouse.y);

            App.window.display();
        }
    }
}
