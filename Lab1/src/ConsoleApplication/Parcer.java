package ConsoleApplication;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;

/**
 * Читает данные из файла, формирует аргументы
 * arguments[0] - name group
 * arguments[1]-x
 * arguments[2]-y
 * arguments[3]-count students
 * arguments[4]-form of education
 * arguments[5]-semester
 * arguments[6]-name person
 * arguments[7]-birthday
 * arguments[8]-height
 * arguments[9]-weight
 * arguments[10]-passport Id
 */
public class Parcer implements CreatingCollections{
    /**
     * countColumn - количество столбцов(параметров)
     * count - количество строк (элементов)
     */
    private static int countColumn = 0;
    private static int count=0;
    static String[][] args = new String[countColumn][];
    Parcer(int count,String[][]args){
        this.count=count;
        this.args=args;
    }

    /**
     * возвращает countColumn
     * @return
     */

    public static int getCountColumn() {
        return countColumn;
    }

    /**
     * возвращает count
     * @return
     */

    public static int getCount() {
        return count;
    }

    /**
     * Изменяет countColumn
     * @param countColumn
     */

    public static void setCountColumn(int countColumn) {
        Parcer.countColumn = countColumn;
    }

    /**
     * Считает countColumn
     * @param inputStream
     * @return
     * @throws IOException
     */

public static int countCountColumn(InputStreamReader inputStream) throws IOException {
    int data = inputStream.read();
    while (data != -1) {
        char chr = (char) data;
        if (chr=='\n'){setCountColumn(++countColumn);break;}
        else{
            if (chr==','){
                setCountColumn(++countColumn);
            }
            data = inputStream.read();
        }
    }
return countColumn;}
    /**
     * parseProductCsv парсирует csv, записывая данные в двумерный массив
     * @param inputStream
     * @return необработанные аргументы
     */
    public static Parcer parseProductCsv(InputStreamReader inputStream,int countColumn) {

        try {
            String[] arguments = new String[countColumn];
            int j = 0;
            for (int i = 0; i < countColumn; i++) {
                arguments[i] = "";
            }
            String list = "";
            int dat = inputStream.read();
            while (dat != -1) {
                char chr = (char) dat;
                if (chr != ',' & chr != '\n') {
                    if (chr != '\r') {
                        list = list + chr;
                    }
                } else {
                    if (j > countColumn -1) {
                        j = 0;
                        count++;

                    }
                    arguments[j] = arguments[j] + " " + list;
                    j++;
                    list = "";
                }
                dat = inputStream.read();
                if (dat==-1){
                    arguments[j] = arguments[j] + " " + list;
                }
            }

            count = count + 1;
            args = new String[countColumn][count + 1];
            j = 0;
            for (int i = 0; i < countColumn; i++) {
                for (String retval : arguments[i].split(" ")) {
                    if (retval != ""){
                        args[i][j] = retval;
                        j++;
                        if (j > count) {
                            j = 0;
                        }
                    }
                }
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        /**
         * создаем объект parcer, для того чтобы метод вернул два параметра
         */
        Parcer parcer=new Parcer(count,args);
        return parcer ;
    }

    /**
     * Создает объект StudyGroup
     * @param arguments
     * @param i
     * @return  new StudyGroup
     * @throws NotCorrectValueException
     */
    public static StudyGroup rebirthArguments(String[][] arguments, int i) throws NotCorrectValueException {
        if (Parcer.getCountColumn()==11){
        String name = arguments[0][i];
        Coordinates coordinates = (Coordinates) new ConsoleApplication.Coordinates(Float.parseFloat(arguments[1][i]), Float.parseFloat(arguments[2][i]));
        Long studentsCount = Long.valueOf(arguments[3][i]);
        FormOfEducation formOfEducation = (FormOfEducation) ConsoleApplication.FormOfEducation.valueOf(arguments[4][i]);
        Semester semester = (Semester) ConsoleApplication.Semester.valueOf(arguments[5][i]);
        Person groupAdmin = (Person) new ConsoleApplication.Person(arguments[6][i], stringToTime(arguments[7][i]), Double.parseDouble(arguments[8][i]), Double.parseDouble(arguments[9][i]), arguments[10][i]);
        return new StudyGroup(name, coordinates, studentsCount, formOfEducation, semester, groupAdmin);}
        else {
            String name = arguments[0][i];
            Integer Id=(Integer) Integer.valueOf(arguments[1][i]);
            LocalDate creationDate=secondStringToTime(arguments[2][i]);
            Coordinates coordinates = (Coordinates) new ConsoleApplication.Coordinates(Float.parseFloat(arguments[3][i]), Float.parseFloat(arguments[4][i]));
            Long studentsCount = Long.valueOf(arguments[5][i]);
            FormOfEducation formOfEducation = (FormOfEducation) ConsoleApplication.FormOfEducation.valueOf(arguments[6][i]);
            Semester semester = (Semester) ConsoleApplication.Semester.valueOf(arguments[7][i]);
            Person groupAdmin = (Person) new ConsoleApplication.Person(arguments[8][i], secondStringToTime(arguments[9][i]),Double.parseDouble(arguments[10][i]), Double.parseDouble(arguments[11][i]), arguments[12][i]);
            return new StudyGroup(Id, creationDate,name, coordinates, studentsCount, formOfEducation, semester, groupAdmin);}

    }

    /**
     * Повторный перевод строки в java.time.LocalDate
     * @param arguments
     * @return
     */

    private static LocalDate secondStringToTime(String arguments) {
        java.time.LocalDate birthday = null;
        int day = 0, mounth = 0, year = 0;
        String arg = "";
        int point = 1;
        for (int i = 0; i < arguments.length(); i++) {
            if (arguments.charAt(i) != '-'&& arguments.charAt(i)!=' '){
                arg = arg + arguments.charAt(i);

            } else if (arguments.charAt(i) == '-'|(arguments.charAt(i) == ' '&&i!=1)) {
                if (point == 3) {
                    day = Integer.parseInt(arg);
                    arg = "";
                    point = 1;
                    birthday=LocalDate.of(year,mounth,day);
                } else if (point == 2) {
                    mounth = Integer.parseInt(arg);
                    arg = "";
                    point++;
                } else if (point == 1) {
                    year = Integer.parseInt(arg);
                    arg = "";
                    point++;
                }
            }
            if (i == arguments.length()-1) {
                day = Integer.parseInt(arg);
                birthday=LocalDate.of(year,mounth,day);
            }

        }
        return birthday;
    }

    /**
     * Создает элемент
     * @param arguments
     * @return
     * @throws NotCorrectValueException
     */

    public static StudyGroup rebirthInputArguments(String[] arguments) throws NotCorrectValueException {
        String name = arguments[0];
        Coordinates coordinates = (Coordinates) new ConsoleApplication.Coordinates(Float.parseFloat(arguments[1]), Float.parseFloat(arguments[2]));
        Long studentsCount = Long.valueOf(arguments[3]);
        FormOfEducation formOfEducation = (FormOfEducation) ConsoleApplication.FormOfEducation.valueOf(arguments[4]);
        Semester semester = (Semester) ConsoleApplication.Semester.valueOf(arguments[5]);
        Person groupAdmin = (Person) new ConsoleApplication.Person(arguments[6], stringToTime(arguments[7]), Double.parseDouble(arguments[8]), Double.parseDouble(arguments[9]), arguments[10]);
        return new StudyGroup(name, coordinates, studentsCount, formOfEducation, semester, groupAdmin);
    }
    /**
     * Формрует аргумент типа LocalDate (из строки)
     * @param arguments
     * @return дата рождения
     */
    public static LocalDate stringToTime(String arguments){
        java.time.LocalDate birthday = null;
        int day = 0, mounth = 0, year = 0;
        String arg = "";
        int point = 1;
        for (int i = 0; i < arguments.length(); i++) {
            if (arguments.charAt(i) != '.'&& arguments.charAt(i)!=' '){
                arg = arg + arguments.charAt(i);

            } else if (arguments.charAt(i) == '.'|(arguments.charAt(i) == ' '&&i!=1)) {
                if (point == 1) {
                    day = Integer.parseInt(arg);
                    arg = "";
                    point++;
                } else if (point == 2) {
                    mounth = Integer.parseInt(arg);
                    arg = "";
                    point++;
                } else if (point == 3) {
                    year = Integer.parseInt(arg);
                    arg = "";
                    birthday=LocalDate.of(year,mounth,day);
                    point = 1;
                }
            }
            if (i == arguments.length()-1) {
                year = Integer.parseInt(arg);
                birthday=LocalDate.of(year,mounth,day);
            }

        }
        System.out.println(birthday);
        return birthday;
    }



}






