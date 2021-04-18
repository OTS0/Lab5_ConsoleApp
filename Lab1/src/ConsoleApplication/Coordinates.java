package ConsoleApplication;

/**
 * Класс координат x и y
 */

public class Coordinates {
    private float x; //Максимальное значение поля: 429, Поле не может быть null
    private float y; //Максимальное значение поля: 398
    private static float MaxValueX=429;
    private static float MaxValueY=398;
    public Coordinates(float x, float y) throws NotCorrectValueException {
        setX(x);
        setY(y);
    }

    /**
     * Изменяет параметры x
     * @param x
     * @throws NotCorrectValueException
     */

    public void setX(float x) throws NotCorrectValueException {
        if (x <= MaxValueX) {
            this.x = x;
        } else {
            throw new NotCorrectValueException("Число превысило допустимое значение. Вы вели:", x);
        }
    }

    /**
     * Изменяет параметры y
     * @param y
     * @throws NotCorrectValueException
     */
        public void setY (float y) throws NotCorrectValueException{
            if (y<=MaxValueY){
                this.y=y;
            }
            else {
                throw new NotCorrectValueException("Число превысило допустимое значение. Вы вели:",y);
            }
        }

    /**
     * Возвращает значение x
     * @return
     */

    public  float getX() {
        return x;
    }

    /**
     * Возвращает максимальнодопустимое значение x
     * @return
     */

    public static float getMaxValueX() {
        return MaxValueX;
    }

    /**
     * Возвращает максимальнодопустимое значение y
     * @return
     */

    public static float getMaxValueY() {
        return MaxValueY;
    }

    /**
     * возвращает значение y
     * @return
     */

    public float getY() {
        return y;
    }
}
