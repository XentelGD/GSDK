package gsdk;

public class Point3D {
    public float x, y, z;

    public Point3D(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void add(float addX, float addY, float addZ) {
        this.x = this.x + addX;
        this.y = this.y + addY;
        this.z = this.z + addZ;
    }

    public void multiply(float mulX, float mulY, float mulZ) {
        this.x = this.x * mulX;
        this.y = this.y * mulY;
        this.z = this.z * mulZ;
    }

    public void set(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}
