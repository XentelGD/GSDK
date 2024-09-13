package gsdk.mwidgets;

import gsdk.App;
import gsdk.GameObject;
import gsdk.Input;
import gsdk.Resource;
import org.jsfml.graphics.*;
import org.jsfml.system.Vector2f;
import org.jsfml.window.Mouse;

public class ImageButton extends Widget {

    public Listener onClick, onRelease, onHover, onHoverEnd;
    public GameObject visualImage;
    public Texture texture;
    public boolean isTouching = false;
    public boolean isActive = true;
    public float imageWidth, imageHeight;

    public Color
            normalColor = new Color(255, 255, 255),
            hoverColor = new Color(210, 210, 210),
            textColor = new Color(0, 0, 0);

    public ImageButton(float x, float y, Texture texture) {
        this.x = x;
        this.y = y;
        this.texture = texture;

        visualImage = new GameObject(x, y, texture);

        applyChanges();

        Input.addBind(new MouseBind(Mouse.Button.LEFT, () -> {
            if (isTouching && isActive && onClick != null) {
                onClick.function();
            }
        }));
    }

    public void applyChanges() {


        visualImage.sprite.setColor(textColor);

        imageWidth =  visualImage.sprite.getGlobalBounds().width;
        imageHeight = visualImage.sprite.getGlobalBounds().height;


        //visualImage.setPosition(x + width / 2 - textWidth / 2, y + height / 2 - textHeight / 1.25f);
    }

    public void draw() {
        imageWidth =  visualImage.sprite.getGlobalBounds().width;
        imageHeight = visualImage.sprite.getGlobalBounds().height;

        if (isActive) {
            visualImage.draw();

            isTouching = (
                    Mouse.getPosition(App.window).x > x && Mouse.getPosition(App.window).x < x + imageWidth &&
                    Mouse.getPosition(App.window).y > y && Mouse.getPosition(App.window).y < y + imageHeight
            );

            if (isTouching) {
                visualImage.sprite.setColor(hoverColor);
            } else {
                visualImage.sprite.setColor(normalColor);
            }
        } else {
            visualImage.sprite.setColor(normalColor);
        }

    }
}
