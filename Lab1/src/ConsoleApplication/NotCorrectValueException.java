package ConsoleApplication;

/**
 * Исклчение для некорректных значений
 */
public class NotCorrectValueException extends Exception {
    private float num;
    public float getNum(){return num;}
    public NotCorrectValueException(String message, float num){
        super(message);
        this.num=num;
    }
}
