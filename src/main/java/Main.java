import gsdk.*;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.window.VideoMode;


public class Main
{
    public static void main(String[] args)
    {
        App.window = new RenderWindow(new VideoMode(1000, 800), "MyWindow");

        while (App.window.isOpen()) {
            App.checkEvents();
            App.window.clear();

            // your code

            App.window.display();
        }
    }
}