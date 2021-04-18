package ConsoleApplication;
import java.time.LocalDate;

/**
 * Класс Person
 */

public class Person {
    private String name; //Поле не может быть null, Строка не может быть пустой
    private LocalDate birthday; //Поле может быть null
    private double height; //Значение поля должно быть больше 0
    private double weight; //Значение поля должно быть больше 0
    private String passportID; //Длина строки не должна быть больше 40, Поле не может быть null

    public Person(String name, LocalDate birthday, double height, double weight, String passportID) {
        this.name = name;
        this.birthday = birthday;
        this.height = height;
        this.weight = weight;
        this.passportID = passportID;
    }

    /**
     * возвращает имя
     * @return
     */

    public String getName() {
        return name;
    }

    /**
     * возвращает дату рождения
     * @return
     */

    public LocalDate getBirthday() {
        return birthday;
    }

    /**
     * возвращает рост
     * @return
     */

    public double getHeight() {
        return height;
    }

    /**
     * возвращает вес
     * @return
     */

    public double getWeight() {
        return weight;
    }

    /**
     * возвращает ID паспорта
     * @return
     */

    public String getPassportID() {
        return passportID;
    }

    /**
     * Возвращает представление объекта в виде строки
     * @return
     */

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", birthday=" + birthday +
                ", height=" + height +
                ", weight=" + weight +
                ", passportID='" + passportID + '\'' +
                '}';
    }
}
