package gsdk.mwidgets;

import gsdk.*;
import org.jsfml.graphics.Color;
import org.jsfml.graphics.Font;
import org.jsfml.graphics.RectangleShape;
import org.jsfml.graphics.Text;
import org.jsfml.system.Vector2f;
import org.jsfml.window.Mouse;

public class TextButton extends Widget {

    public Listener onClick, onRelease, onHover, onHoverEnd;
    public final RectangleShape rectangleShape;
    public final Text visualText;
    public boolean isTouching = false;
    public boolean isActive = true;
    public String text;

    public int textSize = 20;

    public Color
            normalColor = new Color(255, 255, 255),
            hoverColor = new Color(210, 210, 210),
            textColor = new Color(0, 0, 0);

    public TextButton(String text, Font font, float x, float y, float width, float height) {
        this.text = text;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        rectangleShape = new RectangleShape(new Vector2f(width, height));
        rectangleShape.setPosition(x, y);

        visualText = new Text(text, font);

        applyChanges();

        Input.addBind(new MouseBind(Mouse.Button.LEFT, () -> {
            if (isTouching && isActive && onClick != null) {
                onClick.function();
            }
        }));
    }

    public void applyChanges() {
        rectangleShape.setPosition(x, y);
        rectangleShape.setSize(new Vector2f(width, height));


        visualText.setColor(textColor);
        visualText.setCharacterSize(textSize);
        visualText.setString(text);

        float textWidth = visualText.getGlobalBounds().width;
        float textHeight = visualText.getGlobalBounds().height;


        visualText.setPosition(x + width / 2 - textWidth / 2, y + height / 2 - textHeight / 1.25f);
    }

    public void draw() {

        if (isActive) {
            App.window.draw(rectangleShape);
            App.window.draw(visualText);

            isTouching = (
                    Mouse.getPosition(App.window).x > x && Mouse.getPosition(App.window).x < x + width &&
                    Mouse.getPosition(App.window).y > y && Mouse.getPosition(App.window).y < y + height
            );

            if (isTouching) {
                rectangleShape.setFillColor(hoverColor);
            } else {
                rectangleShape.setFillColor(normalColor);
            }
        } else {
            rectangleShape.setFillColor(normalColor);
        }

    }
}
