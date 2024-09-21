import gsdk.App;
import org.jsfml.graphics.*;
import org.jsfml.window.VideoMode;
import org.jsfml.window.WindowStyle;

public class Main {
    public static void main(String[] args) {

        App.window = new RenderWindow(new VideoMode(800, 600), "Default GSDK App", WindowStyle.DEFAULT);

        while (App.window.isOpen()) {
            App.window.clear();
            App.checkEvents();

            App.window.display();
        }
    }
}
