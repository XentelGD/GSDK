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

    public static void rect(float x, float y, float width, float height, Color color, float rotation) {
        RectangleShape rectangleShape = new RectangleShape(new Vector2f(width, height));
        rectangleShape.setFillColor(color);
        rectangleShape.setPosition(x, y);
        rectangleShape.setRotation(rotation);
        App.window.draw(rectangleShape);
    }

    public static void rectOutline(float x, float y, float width, float height, float outlineThickness, Color color) {
        RectangleShape rectangleShape = new RectangleShape(new Vector2f(width, height));
        rectangleShape.setFillColor(new Color(0, 0, 0, 0));
        rectangleShape.setPosition(x, y);
        rectangleShape.setOutlineColor(color);
        rectangleShape.setOutlineThickness(outlineThickness);
        App.window.draw(rectangleShape);
    }

    public static void rectOutline(float x, float y, float width, float height, float outlineThickness, Color color, float rotation) {
        RectangleShape rectangleShape = new RectangleShape(new Vector2f(width, height));
        rectangleShape.setFillColor(new Color(0, 0, 0, 0));
        rectangleShape.setPosition(x, y);
        rectangleShape.setOutlineColor(color);
        rectangleShape.setOutlineThickness(outlineThickness);
        rectangleShape.setRotation(rotation);
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

    public static void circleOutline(float x, float y, float radius, float outlineThickness, Color color) {
        CircleShape circleShape = new CircleShape(radius, 180);
        if (radius < 50) {
            circleShape.setPointCount(30);
        } else {
            circleShape.setPointCount(180);
        }
        circleShape.setFillColor(new Color(0, 0, 0, 0));
        circleShape.setOutlineThickness(outlineThickness);
        circleShape.setOutlineColor(color);
        circleShape.setPosition(x, y);
        App.window.draw(circleShape);
    }

    public static void line(float x1, float y1, float x2, float y2, float thickness, Color color) {
        RectangleShape rectangleShape = new RectangleShape(
                new Vector2f(
                    (float) Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2)), thickness
                )
        );
        rectangleShape.setFillColor(color);
        rectangleShape.setPosition(x1, y1);
        rectangleShape.setRotation((float)(Math.atan2(Math.toRadians(y2 - y1), Math.toRadians(x2 - x1)) * (180 / 3.14)));

        App.window.draw(rectangleShape);
    }
}
