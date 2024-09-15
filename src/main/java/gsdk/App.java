package gsdk;

import gsdk.mwidgets.*;
import org.jsfml.graphics.*;
import org.jsfml.system.Clock;
import org.jsfml.system.Vector2f;
import org.jsfml.window.Mouse;
import org.jsfml.window.event.Event;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class App {

    public static RenderWindow window;
    public static View view = new View();
    public static float deltaTime, fps = 0f;
    public static Clock clock = new Clock();
    public static HashMap<String, List<GameObject>> tags = new HashMap<>();
    public static Font defaultFont = Resource.loadFont("/font/roboto-r.ttf");

    public static void checkEvents() {

        deltaTime = clock.restart().asSeconds() / 2;
        fps = 1 / deltaTime;



        for (Event event : App.window.pollEvents()) {
            if (event.type == Event.Type.CLOSED) {
                App.window.close();
            }

            if (event.type == Event.Type.MOUSE_BUTTON_PRESSED) {
                for (MouseBind bind : Input.mouseButtons) {
                    if (bind.button == event.asMouseButtonEvent().button) {
                        bind.listener.function();
                    }
                }
            }

            if (event.type == Event.Type.KEY_PRESSED) {
                for (KeyBind bind : Input.keyboardKeys) {
                    if (bind.key == event.asKeyEvent().key) {
                        bind.listener.function();
                    }
                }

            }

            if (event.type == Event.Type.RESIZED) {
                // resize my view
                view.setSize(new Vector2f(
                        event.asSizeEvent().size.x,
                        event.asSizeEvent().size.y
                ));
                view.setCenter(App.window.getSize().x / 2, App.window.getSize().y / 2);
                window.setView(view);
            }

        }

        FMouse.x = Mouse.getPosition(App.window).x;
        FMouse.y = Mouse.getPosition(App.window).y;


    }

    public static void drawDebugElements() {
        if (Debug.Mode.displayFps) {
            Text text = new Text(String.valueOf((int)fps), defaultFont);
            text.setPosition(new Vector2f(5, 5));
            text.setCharacterSize(20);
            text.setColor(new Color(100, 250, 100));
            window.draw(text);
        }
    }

    public static void update() {

    }

}
