package gsdk;

import gsdk.mwidgets.*;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.system.Clock;
import org.jsfml.window.Mouse;
import org.jsfml.window.event.Event;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class App {

    public static RenderWindow window;
    public static float deltaTime, fps = 0f;
    public static Clock clock = new Clock();
    public static HashMap<String, List<GameObject>> tags = new HashMap<>();

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

        }

        FMouse.x = Mouse.getPosition(App.window).x;
        FMouse.y = Mouse.getPosition(App.window).y;
    }

    public static void update() {

    }

}
