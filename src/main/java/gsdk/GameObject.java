package gsdk;

import org.jsfml.graphics.Sprite;
import org.jsfml.graphics.Texture;

public class GameObject {

    public float x, y, scaleX = 1, scaleY = 1, offsetX = 0, offsetY = 0;

    public Texture texture;
    public Sprite sprite;

    public GameObject(float x, float y, Texture texture) {
        this.x = x;
        this.y = y;
        this.texture = texture;
        this.sprite = new Sprite(texture);
        this.sprite.setPosition(x, y);
    }

    public void applyChanges() {
        this.sprite.setTexture(texture);
        this.sprite.setScale(scaleX, scaleY);
        this.sprite.setPosition(x + offsetX, y + offsetY);

    }


    public void draw() {
        App.window.draw(this.sprite);
    }

}
