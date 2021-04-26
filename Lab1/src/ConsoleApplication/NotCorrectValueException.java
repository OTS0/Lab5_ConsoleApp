//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package ConsoleApplication;

public class NotCorrectValueException extends Exception {
    private float num;

    public float getNum() {
        return this.num;
    }

    public NotCorrectValueException(String message, float num) {
        super(message);
        this.num = num;
    }
}
