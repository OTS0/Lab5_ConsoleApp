//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package ConsoleApplication;

import java.time.DateTimeException;
import java.time.LocalDate;

public class Person {
    private String name;
    private LocalDate birthday;
    private double height;
    private double weight;
    private String passportID;

    public Person(String name, LocalDate birthday, double height, double weight, String passportID) throws NullPointerException{
        this.name = name;
        this.birthday = birthday;
        this.height = height;
        this.weight = weight;
        this.passportID = passportID;
    }
    public void setName(String name){
        if ((name == null)||(name.equals(""))){
            throw new NullPointerException();
        }
        this.name = name;
    }


    public String getName() {
        return this.name;
    }

    public LocalDate getBirthday() {
        return this.birthday;
    }

    public double getHeight() {
        return this.height;
    }

    public double getWeight() {
        return this.weight;
    }

    public String getPassportID() {
        return this.passportID;
    }

    public String toString() {
        return "Person{name='" + this.name + '\'' + ", birthday=" + this.birthday + ", height=" + this.height + ", weight=" + this.weight + ", passportID='" + this.passportID + '\'' + '}';
    }

}
