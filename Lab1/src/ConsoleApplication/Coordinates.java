//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package ConsoleApplication;

public class Coordinates {
    private float x;
    private float y;
    private static float MaxValueX = 429.0F;
    private static float MaxValueY = 398.0F;

    public Coordinates(float x, float y) throws NotCorrectValueException {
        this.setX(x);
        this.setY(y);
    }

    public void setX(float x) throws NotCorrectValueException {
        if (x <= MaxValueX) {
            this.x = x;
        } else {
            throw new NotCorrectValueException("Число превысило допустимое значение. Вы вели:", x);
        }
    }

    public void setY(float y) throws NotCorrectValueException {
        if (y <= MaxValueY) {
            this.y = y;
        } else {
            throw new NotCorrectValueException("Число превысило допустимое значение. Вы вели:", y);
        }
    }

    public float getX() {
        return this.x;
    }

    public static float getMaxValueX() {
        return MaxValueX;
    }

    public static float getMaxValueY() {
        return MaxValueY;
    }

    public float getY() {
        return this.y;
    }

    public String toString() {
        return "Coordinates{x=" + this.x + ", y=" + this.y + '}';
    }
}
