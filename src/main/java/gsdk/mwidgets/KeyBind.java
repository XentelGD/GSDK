package gsdk.mwidgets;

import org.jsfml.window.Keyboard;

public class KeyBind {
    public Keyboard.Key key;
    public Listener listener;

    public KeyBind(Keyboard.Key key, Listener listener) {
        this.key = key;
        this.listener = listener;
    }
}
