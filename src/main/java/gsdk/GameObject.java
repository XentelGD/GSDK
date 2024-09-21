package gsdk;

import org.jsfml.graphics.Color;
import org.jsfml.graphics.Sprite;
import org.jsfml.graphics.Texture;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GameObject {

    private float x, y, scaleX = 1, scaleY = 1, offsetX = 0, offsetY = 0;

    public Texture texture;
    public Sprite sprite;
    public HashMap<String, Component> components = new HashMap<>();

    public void addComponent(String name, Component component) {

        components.put(name, component);

        this.components.get(name).currentGameObject = this;
        this.components.get(name).onStart();
    }

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

    public GameObject setX(float x) {
        this.x = x;
        updatePos();
        return this;
    }

    public GameObject setPosition(float x, float y) {
        this.x = x;
        this.y = y;
        updatePos();
        return this;
    }

    public float getY() {
        return y;
    }

    public GameObject setY(float y) {
        this.y = y;
        updatePos();
        return this;
    }

    public float getScaleX() {
        return scaleX;
    }

    public GameObject setColor(Color color) {
        this.sprite.setColor(color);
        return this;
    }

    public Color getColor() {
        return this.sprite.getColor();
    }

    public GameObject setScale(float scaleX, float scaleY) {
        this.scaleX = scaleX;
        this.scaleY = scaleY;
        updateScale();
        return this;
    }

    public GameObject setScaleX(float scaleX) {
        this.scaleX = scaleX;
        updateScale();
        return this;
    }

    public float getScaleY() {
        return scaleY;
    }

    public GameObject setScaleY(float scaleY) {
        this.scaleY = scaleY;
        updateScale();
        return this;
    }

    public float getOffsetX() {
        return offsetX;
    }

    public GameObject setOffset(float offsetX, float offsetY) {
        this.offsetX = offsetX;
        this.scaleY = offsetY;
        updateOffset();
        return this;
    }

    public GameObject setOffsetX(float offsetX) {
        this.offsetX = offsetX;
        updateOffset();
        return this;
    }

    public float getOffsetY() {
        return offsetY;
    }

    public GameObject setOffsetY(float offsetY) {
        this.offsetY = offsetY;
        updateOffset();
        return this;
    }

    public Texture getTexture() {
        return texture;
    }

    public GameObject setTexture(Texture texture) {
        this.texture = texture;
        this.sprite.setTexture(texture);
        return this;
    }

    public Sprite getSprite() {
        return sprite;
    }

    public GameObject setSprite(Sprite sprite) {
        this.sprite = sprite;
        return this;
    }

    public void draw() {
        for (Component component : components.values()) {
            component.onUpdate();
        }
        App.window.draw(this.sprite);
    }

}
