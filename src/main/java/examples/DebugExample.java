package examples;

import gsdk.*;
import org.jsfml.graphics.Color;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.window.VideoMode;

public class DebugExample {
    public static void main(String[] args)
    {
        App.window = new RenderWindow(new VideoMode(1000, 800), "MyWindow");

        Debug.Mode.displayFps = true;

        while (App.window.isOpen()) {
            App.window.clear();
            App.checkEvents();


            // demonstrating that program doesn't stop while timer is running
            Draw.circle(
                    FMouse.x,
                    FMouse.y, 10, new Color(255, 100, 100)
            );

            // drawing debug elements
            App.drawDebugElements();
            App.window.display();
        }
    }
}
