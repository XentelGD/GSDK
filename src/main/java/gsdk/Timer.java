package gsdk;

import gsdk.mwidgets.Listener;
import org.jsfml.system.Clock;

import java.util.concurrent.TimeUnit;

public class Timer {

    public float time;
    public int repeats, currentRepeats;
    public Listener function, onEndListener = () -> {};
    public float currentTime = 0f;
    private boolean isActive = true;

    public void pause() {
        isActive = false;
    }

    public void resume() {
        isActive = true;
    }

    public Timer(float time, int repeats, Listener function) {
        this.time = time;
        this.repeats = repeats;
        this.function = function;
        currentRepeats = 0;
    }

    public void addOnEndListener(Listener onEndListener) {
        this.onEndListener = onEndListener;
    }

    public void start() {
        new Thread(() -> {
            currentRepeats = 0;
            if (repeats == Gsdk.INFINITY) {
                currentRepeats = -2;
            }
            while (currentRepeats < repeats) {
                while (!isActive) {}

                try {
                    TimeUnit.MILLISECONDS.sleep((long) (time * 1000));
                    function.function();
                    currentTime = 0;
                    if (repeats != Gsdk.INFINITY) {
                        currentRepeats++;
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            onEndListener.function();
        }).start();
    }



}
