import gsdk.*;
import org.jsfml.graphics.Color;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.graphics.Texture;
import org.jsfml.window.VideoMode;

import java.util.ArrayList;
import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        App.window = new RenderWindow(new VideoMode(1000, 800), "MyWindow");


        while (App.window.isOpen()) {
            App.checkEvents();
            App.window.clear();

            // game logic

            App.window.display();
        }
    }
}