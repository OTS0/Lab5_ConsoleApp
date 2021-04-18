package ConsoleApplication;
import java.time.LocalDate;

/**
 * Класс StudyGroup
 * id - уникальный номер каждого студента
 * name - название группы
 * coordinates - координты x и y
 * formOfEducation - форма обучения
 * semesterEnum - номер семестра
 * groupAdmin - объект person (информация о студенте)
 * creationDate - время создание элемента (время записи человека)
 */

public class StudyGroup  {
    private int id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.LocalDate creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Long studentsCount; //Значение поля должно быть больше 0, Поле не может быть null
    private FormOfEducation formOfEducation; //Поле может быть null
    private Semester semesterEnum; //Поле не может быть null
    private Person groupAdmin; //Поле не может быть null
    public static int idSetter = 1;
    public StudyGroup( String name, Coordinates coordinates, Long studentsCount, FormOfEducation formOfEducation, Semester semesterEnum, Person groupAdmin) {
        setName(name);
        setId(idSetter++);
        this.creationDate = LocalDate.now();
        setCoordinates(coordinates);
        setStudentsCount(studentsCount);
        setFormOfEducation(formOfEducation);
        setSemesterEnum(semesterEnum);
        setGroupAdmin(groupAdmin);
    }

    public StudyGroup( int id,java.time.LocalDate creationDate,String name, Coordinates coordinates, Long studentsCount, FormOfEducation formOfEducation, Semester semesterEnum, Person groupAdmin) {
        setName(name);
        setId(id);
        setCreationDate(creationDate);
        setCoordinates(coordinates);
        setStudentsCount(studentsCount);
        setFormOfEducation(formOfEducation);
        setSemesterEnum(semesterEnum);
        setGroupAdmin(groupAdmin);
    }

    /**
     * возвращает строковое представление объекта класса StudyGroup
     * @return
     */

    @Override
    public String toString() {
        return "StudyGroup{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coordinates=" + coordinates +
                ", creationDate=" + creationDate +
                ", studentsCount=" + studentsCount +
                ", formOfEducation=" + formOfEducation +
                ", semesterEnum=" + semesterEnum +
                ", groupAdmin=" + groupAdmin +
                '}';
    }

    /**
     * возвращает name (название группы)
     * @return
     */

    public  String getName() {
        return name;
    }

    /**
     * изменяет name
     * @param name
     * @throws NullPointerException
     */
    public void setName(String name) throws NullPointerException {
        if (name!=null && name!=" "){
        this.name = name;}
        else{
            throw new NullPointerException();
        }
    }

    /**
     *возващает creationDate
     * @return
     */

    public LocalDate getCreationDate() {
        return creationDate;
    }

    /**
     * изменяет creationDate
     * @param creationDate
     */

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * Изменяет id
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * возвращает id
     * @return
     */

    public int getId() {
        return id;
    }

    /**
     * Изменяет координаты
     * @param coordinates
     * @throws NullPointerException
     */

    public void setCoordinates(Coordinates coordinates) throws NullPointerException{
        if (coordinates!=null) {
            this.coordinates = coordinates;}
        else{
            throw new NullPointerException();
        }
    }

    /**
     * возвращает координаты
     * @return
     */

    public Coordinates getCoordinates() {
        return coordinates;
    }

    /**
     * возвращает formOfEducation
     * @return
     */

    public FormOfEducation getFormOfEducation() {
        return formOfEducation;
    }

    /**
     * изменяет formOfEducation
     * @param formOfEducation
     * @throws NullPointerException
     */

    public void setFormOfEducation(FormOfEducation formOfEducation) throws NullPointerException{
        if (formOfEducation!= null){
        this.formOfEducation = formOfEducation;}
        else{
            throw new NullPointerException();
        }
    }

    /**
     * Измеяет groupAdmin
     * @param groupAdmin
     * @throws NullPointerException
     */
    public void setGroupAdmin(Person groupAdmin) throws NullPointerException {
        if (groupAdmin!=null){
        this.groupAdmin = groupAdmin;}
        else{
            throw new NullPointerException();
        }
    }

    /**
     * возвращает studentsCount
     * @return
     */

    public Long getStudentsCount() {
        return studentsCount;
    }

    /**
     * возвращает groupAdmin
     * @return
     */
    public Person getGroupAdmin() {
        return groupAdmin;
    }

    /**
     * возвращает semesterEnum
     * @return
     */

    public Semester getSemesterEnum() {
        return semesterEnum;
    }

    /**
     * изменяет semesterEnum
     * @param semesterEnum
     * @throws NullPointerException
     */

    public void setSemesterEnum(Semester semesterEnum) throws NullPointerException {
        if (semesterEnum!=null){
        this.semesterEnum = semesterEnum;}
        else {
            throw new NullPointerException();
        }
    }

    /**
     * Изменяет studentsCount
     * @param studentsCount
     * @throws NullPointerException
     */

    public void setStudentsCount(Long studentsCount) throws NullPointerException {
        if (studentsCount!=null && studentsCount>0){
        this.studentsCount = studentsCount;}
        else {
            throw new NullPointerException();
        }
    }


}
