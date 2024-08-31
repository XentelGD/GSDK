package examples;

import gsdk.*;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.window.VideoMode;

public class LocalizationExample
{
    public static void main(String[] args)
    {
        App.window = new RenderWindow(new VideoMode(1000, 800), "MyWindow");

        Localization localization = new Localization(
                "/lang/",
                new String[]{
                        "en-US.ljson",
                        "ru-RU.ljson"
                }
        );

        System.out.println(localization.getLocalizedText("en-US", "copper"));

        while (App.window.isOpen()) {
            App.checkEvents();
            App.window.clear();
            App.window.display();
        }
    }
}