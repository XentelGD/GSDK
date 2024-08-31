package gsdk;



import gsdk.mwidgets.*;

import java.util.ArrayList;
import java.util.List;

public class Input {

    public static List<MouseBind> mouseButtons = new ArrayList<>();
    public static List<KeyBind> keyboardKeys = new ArrayList<>();

    public static void addBind(MouseBind bind) {
        mouseButtons.add(bind);
    }

    public static void addBind(KeyBind bind) {
        keyboardKeys.add(bind);
    }
}
