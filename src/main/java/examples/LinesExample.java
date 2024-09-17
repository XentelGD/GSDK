package examples;

import gsdk.App;
import gsdk.Draw;
import gsdk.Point2D;
import gsdk.Random;
import org.jsfml.graphics.Color;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.window.VideoMode;

public class LinesExample {
    public static void main(String[] args)
    {
        App.window = new RenderWindow(new VideoMode(1000, 800), "MyWindow");

        Point2D[] points2D = new Point2D[30];

        while (App.window.isOpen()) {
            App.checkEvents();
            App.window.clear();

            // adding random points to the points2D array
            for (int i = 0; i < points2D.length; i++) {
                points2D[i] = new Point2D(
                        (float) (Random.range(0, App.window.getSize().x)),
                        (float) (Random.range(0, App.window.getSize().y))
                );
            }

            // drawing lines
            Draw.lines(points2D, Random.range(1, 10), new Color(255, 255, 0));


            App.window.display();
        }
    }
}
