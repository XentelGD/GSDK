package gsdk;

import gsdk.mwidgets.*;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.window.event.Event;

public class App {

    public static RenderWindow window;

    public static void checkEvents() {
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
    }

    public static void update() {

    }

}