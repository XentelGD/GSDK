package examples.componentExample;

import gsdk.*;
import org.jsfml.graphics.Color;

public class MovingComponent extends Component {

    @Override
    public void start() {

        new Timer(0.5f, Gsdk.INFINITY, () -> {
            currentGameObject.sprite.setColor(
                    new Color(Random.range(0, 255), Random.range(0, 255), Random.range(0, 255))
            );
        }).start();

        super.start();
    }

    @Override
    public void update() {
        currentGameObject.setPosition(FMouse.x, FMouse.y);

        super.update();
    }
}
