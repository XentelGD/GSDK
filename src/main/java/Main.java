import gsdk.*;
import org.jsfml.graphics.Color;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.window.VideoMode;

public class Main
{
    public static void main(String[] args)
    {
        App.window = new RenderWindow(new VideoMode(1000, 800), "MyWindow");
        float x = 0, y = 0;

        while (App.window.isOpen()) {
            App.checkEvents();
            //App.window.clear();
            for (int i = 0; i < (int)(Math.random() * 300000); i++) {
                System.out.println("werew");
            }
            // game logic
            x += (float)(250 * 0.0004 * 1.5);
            y += (float)(200 * 0.001 * 1.5);
            Draw.rect(x, y, 5, 5, new Color(0, 25, 100));

            App.window.display();
        }
    }
}