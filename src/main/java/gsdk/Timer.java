package gsdk;

import gsdk.mwidgets.Listener;

import java.util.concurrent.TimeUnit;

public class Timer {

    public final float time;
    public int repeats, currentRepeats;
    public Listener function, onEndListener = () -> {};
    public float currentTime = 0f;

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

            if (repeats != Gsdk.INFINITY) {

                while (currentRepeats < repeats) {
                    try {
                        TimeUnit.MILLISECONDS.sleep((long) (time * 1000));
                        function.function();
                        currentTime = 0;
                        currentRepeats++;
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            } else {
                while (true) {
                    try {
                        TimeUnit.MILLISECONDS.sleep((long) (time * 1000));
                        function.function();
                        currentTime = 0;
                        currentRepeats++;
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
            onEndListener.function();
        }).start();
    }



}
