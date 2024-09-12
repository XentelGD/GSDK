package gsdk;

import org.jsfml.graphics.Sprite;
import org.jsfml.graphics.Texture;

public class GameObject {

    private float x, y, scaleX = 1, scaleY = 1, offsetX = 0, offsetY = 0;

    public Texture texture;
    public Sprite sprite;

    public GameObject(float x, float y, Texture texture) {
        this.x = x;
        this.y = y;
        this.texture = texture;
        this.sprite = new Sprite(texture);
        this.sprite.setPosition(x, y);
    }

    protected void updatePos() {
        this.sprite.setPosition(x + offsetX, y + offsetY);
    }

    protected void updateScale() {
        this.sprite.setScale(scaleX, scaleY);
    }

    protected void updateOffset() {
        updatePos();
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
        updatePos();
    }

    public void setPosition(float x, float y) {
        this.x = x;
        this.y = y;
        updatePos();
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
        updatePos();
    }

    public float getScaleX() {
        return scaleX;
    }

    public void setScale(float scaleX, float scaleY) {
        this.scaleX = scaleX;
        this.scaleY = scaleY;
        updateScale();
    }

    public void setScaleX(float scaleX) {
        this.scaleX = scaleX;
        updateScale();
    }

    public float getScaleY() {
        return scaleY;
    }

    public void setScaleY(float scaleY) {
        this.scaleY = scaleY;
        updateScale();
    }

    public float getOffsetX() {
        return offsetX;
    }

    public void setOffset(float offsetX, float offsetY) {
        this.offsetX = offsetX;
        this.scaleY = offsetY;
        updateOffset();
    }

    public void setOffsetX(float offsetX) {
        this.offsetX = offsetX;
        updateOffset();
    }

    public float getOffsetY() {
        return offsetY;
    }

    public void setOffsetY(float offsetY) {
        this.offsetY = offsetY;
        updateOffset();
    }

    public Texture getTexture() {
        return texture;
    }

    public void setTexture(Texture texture) {
        this.texture = texture;
        this.sprite.setTexture(texture);
    }

    public Sprite getSprite() {
        return sprite;
    }

    public void setSprite(Sprite sprite) {
        this.sprite = sprite;
    }

    public void draw() {
        App.window.draw(this.sprite);
    }

}
