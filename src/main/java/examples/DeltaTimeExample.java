package examples;

import gsdk.App;
import gsdk.Resource;
import org.jsfml.graphics.Font;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.graphics.Text;
import org.jsfml.window.VideoMode;

public class DeltaTimeExample {
    public static void main(String[] args)
    {
        App.window = new RenderWindow(new VideoMode(1000, 800), "MyWindow");

        Font font = new Font();
        Text text = new Text("", font);
        text.setPosition(40, 40);
        text.setCharacterSize(50);

        App.window.setFramerateLimit(60); // 60 fps limit

        try {
            font.loadFromStream(Resource.getAsStream("/font/roboto-m.ttf")); // loading font
        } catch (Exception e) {}


        while (App.window.isOpen()) {
            App.window.clear();
            App.checkEvents();


            text.setString("Delta time: " + (float)App.deltaTime + " sec");
            App.window.draw(text); // text draw

            App.window.display();
        }
    }
}
