package gsdk;

import org.jsfml.graphics.CircleShape;
import org.jsfml.graphics.Color;
import org.jsfml.graphics.RectangleShape;
import org.jsfml.system.Vector2f;

public class Draw {

    public static void rect(float x, float y, float width, float height, Color color) {
        RectangleShape rectangleShape = new RectangleShape(new Vector2f(width, height));
        rectangleShape.setFillColor(color);
        rectangleShape.setPosition(x, y);
        App.window.draw(rectangleShape);
    }

    public static void circle(float x, float y, float radius, Color color) {
        CircleShape circleShape = new CircleShape(radius, 180);
        if (radius < 50) {
            circleShape.setPointCount(30);
        } else {
            circleShape.setPointCount(180);
        }
        circleShape.setFillColor(color);
        circleShape.setPosition(x, y);
        App.window.draw(circleShape);
    }
}
