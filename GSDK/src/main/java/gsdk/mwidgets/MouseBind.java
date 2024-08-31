package gsdk.mwidgets;

import org.jsfml.window.Mouse;

public class MouseBind {
    public Mouse.Button button;
    public Listener listener;

    public MouseBind(Mouse.Button button, Listener listener) {
        this.button = button;
        this.listener = listener;
    }
}
