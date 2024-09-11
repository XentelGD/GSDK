package examples;

import gsdk.App;
import gsdk.Draw;
import gsdk.FMouse;
import gsdk.Timer;
import org.jsfml.graphics.Color;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.window.VideoMode;

public class TimerExample {
    public static void main(String[] args)
    {
        App.window = new RenderWindow(new VideoMode(1000, 800), "MyWindow");
        // creating the timer
        Timer timer = new Timer(0.5f, 10, () -> {
            System.out.println("timer is working!");
        });

        // optional! adding onEndListener to the timer
        timer.addOnEndListener(() -> {
            System.out.println("timer ended");
        });

        // starting the timer
        timer.start();

        while (App.window.isOpen()) {
            App.checkEvents();
            App.window.clear();

            // demonstrating that program doesn't stop while timer is running
            Draw.circle(
                    FMouse.x,
                    FMouse.y, 10, new Color(255, 100, 100)
            );

            App.window.display();
        }
    }
}
