//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package ConsoleApplication;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;

public class StudyGroup {
    private int id;
    private String name;
    private Coordinates coordinates;
    private LocalDate creationDate;
    private Long studentsCount;
    private FormOfEducation formOfEducation;
    private Semester semesterEnum;
    private Person groupAdmin;
    public static int idSetter = 0;

    public StudyGroup(String name, Coordinates coordinates, Long studentsCount, FormOfEducation formOfEducation, Semester semesterEnum, Person groupAdmin) {
        this.setName(name);
        setIdSetterId(false);
        this.creationDate = LocalDate.now();
        this.setCoordinates(coordinates);
        this.setStudentsCount(studentsCount);
        this.setFormOfEducation(formOfEducation);
        this.setSemesterEnum(semesterEnum);
        this.setGroupAdmin(groupAdmin);
    }
    public void setIdSetterId(boolean check){
        if (!check) {
            idSetter = idSetter + 1;
        }
        Collections.sort(Parcer.id);
        for (int i = 0; i < Parcer.id.size(); i++) {
            if (idSetter == Parcer.id.get(i)) {
                check = true;
                idSetter = idSetter + 1;
                setIdSetterId(true);
                break;
            }
        }
        this.id = idSetter;
    }

    public StudyGroup(int id, LocalDate creationDate, String name, Coordinates coordinates, Long studentsCount, FormOfEducation formOfEducation, Semester semesterEnum, Person groupAdmin) {
        this.setName(name);
        this.setId(id);
        this.setCreationDate(creationDate);
        this.setCoordinates(coordinates);
        this.setStudentsCount(studentsCount);
        this.setFormOfEducation(formOfEducation);
        this.setSemesterEnum(semesterEnum);
        this.setGroupAdmin(groupAdmin);
    }

    public String toString() {
        return "StudyGroup{id=" + this.id + ", name='" + this.name + '\'' + ", coordinates=" + this.coordinates + ", creationDate=" + this.creationDate + ", studentsCount=" + this.studentsCount + ", formOfEducation=" + this.formOfEducation + ", semesterEnum=" + this.semesterEnum + ", groupAdmin=" + this.groupAdmin + '}';
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) throws NullPointerException {
        if (name != null && name != " ") {
            this.name = name;
        } else {
            throw new NullPointerException();
        }
    }

    public LocalDate getCreationDate() {
        return this.creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void setCoordinates(Coordinates coordinates) throws NullPointerException {
        if (coordinates != null) {
            this.coordinates = coordinates;
        } else {
            throw new NullPointerException();
        }
    }

    public Coordinates getCoordinates() {
        return this.coordinates;
    }

    public FormOfEducation getFormOfEducation() {
        return this.formOfEducation;
    }

    public void setFormOfEducation(FormOfEducation formOfEducation) throws NullPointerException {
        if (formOfEducation != null) {
            this.formOfEducation = formOfEducation;
        } else {
            throw new NullPointerException();
        }
    }

    public void setGroupAdmin(Person groupAdmin) throws NullPointerException {
        if (groupAdmin != null) {
            this.groupAdmin = groupAdmin;
        } else {
            throw new NullPointerException();
        }
    }

    public Long getStudentsCount() {
        return this.studentsCount;
    }

    public Person getGroupAdmin() {
        return this.groupAdmin;
    }

    public Semester getSemesterEnum() {
        return this.semesterEnum;
    }

    public void setSemesterEnum(Semester semesterEnum) throws NullPointerException {
        if (semesterEnum != null) {
            this.semesterEnum = semesterEnum;
        } else {
            throw new NullPointerException();
        }
    }

    public void setStudentsCount(Long studentsCount) throws NullPointerException {
        if (studentsCount != null && studentsCount > -1) {
            this.studentsCount = studentsCount;
        } else {
            throw new NullPointerException();
        }
    }
}
