package examples;


import gsdk.*;
import gsdk.mwidgets.*;
import org.jsfml.graphics.*;
import org.jsfml.window.*;


public class InputExample {

    public static void main(String[] args)
    {
        // creating the main window
        App.window = new RenderWindow(new VideoMode(1000, 800), "MyWindow");

        // creating a bind of the "space" key
        KeyBind spaceBind = new KeyBind(Keyboard.Key.SPACE, new Listener() {
            @Override
            public void function() {
                System.out.println("Space clicked!");
            }
        });

        // creating a bind of the left mouse button
        MouseBind lmbBind = new MouseBind(Mouse.Button.LEFT, new Listener() {
            @Override
            public void function() {
                System.out.println("LMB clicked!");
            }
        });

        // adding a listener to the "space" key
        Input.addBind(spaceBind);

        // adding a listener to the left mouse button
        Input.addBind(lmbBind);



        while (App.window.isOpen()) {
            App.window.clear();
            App.checkEvents();

            // your game logic...

            App.window.display();
        }
    }
}
