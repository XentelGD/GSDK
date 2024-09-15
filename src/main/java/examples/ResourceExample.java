package examples;

import gsdk.App;
import gsdk.Resource;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.window.VideoMode;

import java.io.InputStream;

public class ResourceExample {
    public static void main(String[] args)
    {
        App.window = new RenderWindow(new VideoMode(1000, 800), "MyWindow");

        InputStream res = Resource.getAsStream("/data/text.txt");
        String resData = Resource.readDataFromStream(res);
        System.out.println(resData);

        while (App.window.isOpen()) {
            App.window.clear();
            App.checkEvents();

            App.window.display();
        }
    }
}
