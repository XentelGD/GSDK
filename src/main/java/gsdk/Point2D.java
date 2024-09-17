package gsdk;

public class Point2D {
    public float x, y;

    public Point2D(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Point2D(float x, double v) {
    }

    public void add(float addX, float addY) {
        this.x = this.x + addX;
        this.y = this.y + addY;
    }

    public void multiply(float mulX, float mulY) {
        this.x = this.x * mulX;
        this.y = this.y * mulY;
    }

    public void set(float x, float y) {
        this.x = x;
        this.y = y;
    }
}
