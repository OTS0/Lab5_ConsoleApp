//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package ConsoleApplication;

import java.io.IOException;
import java.io.InputStreamReader;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Parcer implements CreatingCollections {
    static ArrayList<Integer> id = new ArrayList<>();
    private static int countColumn = 0;
    private static int count = 0;
    static String[][] args;

    Parcer(int count, String[][] args) {
        Parcer.count = count;
        Parcer.args = args;
    }

    public static int getCountColumn() {
        return countColumn;
    }

    public static int getCount() {
        return count;
    }

    public static void setCountColumn(int countColumn) {
        Parcer.countColumn = countColumn;
    }

    public static int countCountColumn(InputStreamReader inputStream) throws IOException {
        for(int data = inputStream.read(); data != -1; data = inputStream.read()) {
            char chr = (char)data;
            if (chr == '\n') {
                setCountColumn(++countColumn);
                break;
            }

            if (chr == ',') {
                setCountColumn(++countColumn);
            }
        }

        return countColumn;
    }
    public static boolean checkId(int num){
        boolean check = false;
        if (num < 0){
            check = true;
        }else {
            for (int i = 0; i < id.size(); i++) {
                if (num == id.get(i)) {
                    check = true;
                    break;
                }
            }
        }
        return check;
    }
    public static Parcer parseProductCsv(InputStreamReader inputStream, int countColumn) {
        try {
            String[] arguments = new String[countColumn];
            int j = 0;

            for(int i = 0; i < countColumn; ++i) {
                arguments[i] = "";
            }

            String list = "";
            int dat = inputStream.read();

            while(dat != -1) {
                char chr = (char)dat;
                if (chr != ',' & chr != '\n') {
                    if (chr != '\r') {
                        list = list + chr;
                    }
                } else {
                    if (j > countColumn - 1) {
                        j = 0;
                        ++count;
                    }

                    arguments[j] = arguments[j] + " " + list;
                    ++j;
                    list = "";
                }

                dat = inputStream.read();
                if (dat == -1) {
                    arguments[j] = arguments[j] + " " + list;
                }
            }

            ++count;
            args = new String[countColumn][count + 1];
            j = 0;

            for(int i = 0; i < countColumn; ++i) {
                String[] var7 = arguments[i].split(" ");
                int var8 = var7.length;

                for(int var9 = 0; var9 < var8; ++var9) {
                    String retval = var7[var9];
                    if (retval != "") {
                        args[i][j] = retval;
                        ++j;
                        if (j > count) {
                            j = 0;
                        }
                    }
                }
            }
        } catch (IOException var11) {
            var11.printStackTrace();
        } catch (NullPointerException var12) {
            System.out.println("Вы пытаетесь прочитать пустой файл или файл с некоррекными данными");
            System.exit(0);
        }

        Parcer parcer = new Parcer(count, args);
        return parcer;
    }

    public static StudyGroup rebirthArguments(String[][] arguments, int i) throws NotCorrectValueException, NumberFormatException, NullPointerException, DateTimeException {
        String name;
        if (getCountColumn() == 11) {
            name = arguments[0][i];
            Coordinates coordinates = new Coordinates(Float.parseFloat(arguments[1][i]), Float.parseFloat(arguments[2][i]));
            Long studentsCount = Long.valueOf(arguments[3][i]);
            FormOfEducation formOfEducation = FormOfEducation.valueOf(arguments[4][i]);
            Semester semester = Semester.valueOf(arguments[5][i]);
            Person groupAdmin = new Person(arguments[6][i], secondStringToTime(arguments[7][i]), Double.parseDouble(arguments[8][i]), Double.parseDouble(arguments[9][i]), arguments[10][i]);
            return new StudyGroup(name, coordinates, studentsCount, formOfEducation, semester, groupAdmin);
        } else {
            name = arguments[0][i];
            Integer Id = Integer.valueOf(arguments[1][i]);
            if (!checkId(Id)) {
                id.add(Id);
            }else{
                throw new NullPointerException();
            }
            LocalDate creationDate = secondStringToTime(arguments[2][i]);
            Coordinates coordinates = new Coordinates(Float.parseFloat(arguments[3][i]), Float.parseFloat(arguments[4][i]));
            Long studentsCount = Long.valueOf(arguments[5][i]);
            FormOfEducation formOfEducation = FormOfEducation.valueOf(arguments[6][i]);
            Semester semester = Semester.valueOf(arguments[7][i]);
            Person groupAdmin = new Person(arguments[8][i], secondStringToTime(arguments[9][i]), Double.parseDouble(arguments[10][i]), Double.parseDouble(arguments[11][i]), arguments[12][i]);
            return new StudyGroup(Id, creationDate, name, coordinates, studentsCount, formOfEducation, semester, groupAdmin);
        }
    }

    private static LocalDate secondStringToTime(String arguments) {
        LocalDate birthday = null;
        int mounth = 0;
        int year = 0;
        String arg = "";
        int point = 1;

        for(int i = 0; i < arguments.length(); ++i) {
            int day;
            if (arguments.charAt(i) != '-' && arguments.charAt(i) != ' ') {
                arg = arg + arguments.charAt(i);
            } else if (arguments.charAt(i) == '-' | (arguments.charAt(i) == ' ' && i != 1)) {
                if (point == 3) {
                    day = Integer.parseInt(arg);
                    arg = "";
                    point = 1;
                    birthday = LocalDate.of(year, mounth, day);
                } else if (point == 2) {
                    mounth = Integer.parseInt(arg);
                    arg = "";
                    ++point;
                } else if (point == 1) {
                    year = Integer.parseInt(arg);
                    arg = "";
                    ++point;
                }
            }

            if (i == arguments.length() - 1) {
                day = Integer.parseInt(arg);
                birthday = LocalDate.of(year, mounth, day);
            }
        }

        return birthday;
    }

    public static StudyGroup rebirthInputArguments(String[] arguments) throws NotCorrectValueException {
        String name = arguments[0];
        Coordinates coordinates = new Coordinates(Float.parseFloat(arguments[1]), Float.parseFloat(arguments[2]));
        Long studentsCount = Long.valueOf(arguments[3]);
        FormOfEducation formOfEducation = FormOfEducation.valueOf(arguments[4]);
        Semester semester = Semester.valueOf(arguments[5]);
        Person groupAdmin = new Person(arguments[6], secondStringToTime(arguments[7]), Double.parseDouble(arguments[8]), Double.parseDouble(arguments[9]), arguments[10]);
        return new StudyGroup(name, coordinates, studentsCount, formOfEducation, semester, groupAdmin);
    }



    static String repeatInput(Scanner scanner) {
        String arg = null;

        try {
            arg = scanner.nextLine();
        } catch (NoSuchElementException var3) {
            System.out.println("Строка пуста");
        }

        return arg;
    }

    static {
        args = new String[countColumn][];
    }
}
