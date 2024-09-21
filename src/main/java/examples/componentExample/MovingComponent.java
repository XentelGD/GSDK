package examples.componentExample;

import gsdk.*;
import org.jsfml.graphics.Color;

public class MovingComponent extends Component {

    @Override
    public void onStart() {

        new Timer(0.5f, Gsdk.INFINITY, () -> {
            currentGameObject.sprite.setColor(
                    new Color(Random.range(0, 255), Random.range(0, 255), Random.range(0, 255))
            );
        }).start();

        super.onStart();
    }

    @Override
    public void onUpdate() {
        currentGameObject.setPosition(FMouse.x, FMouse.y);

        super.onUpdate();
    }
}
