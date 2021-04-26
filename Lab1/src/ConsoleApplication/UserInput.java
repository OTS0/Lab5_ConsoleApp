//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package ConsoleApplication;

import ConsoleApplication.command.CommandsManager;
import ConsoleApplication.Parcer;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.PriorityQueue;
import java.util.Scanner;

import static ConsoleApplication.command.CommandsManager.equalsPart;
import static ConsoleApplication.command.CommandsManager.looseEquals;

public class UserInput {
    public UserInput() {
    }

    public static StudyGroup argumentsReader(CommandsManager commandsManager) throws NotCorrectValueException {
        String[] arguments = new String[Parcer.getCountColumn()];
        arguments[0] = InputValidation("Введите название группы:", false, commandsManager, "String");
        arguments[1] = InputValidation("Введите координату x(вещественное число):", 1.4E-45F, Coordinates.getMaxValueX(), commandsManager);
        arguments[2] = InputValidation("Введите координату y(вещественное число):", 1.4E-45F, Coordinates.getMaxValueY(), commandsManager);
        arguments[3] = InputValidation("Введите количество студентов ", 0, 2147483647, commandsManager);
        arguments[4] = "";

        while(!arguments[4].equals("DISTANCE_EDUCATION") && !arguments[4].equals("FULL_TIME_EDUCATION") && !arguments[4].equals("EVENING_CLASSES")) {
            arguments[4] = InputValidation("Выберите форму обучения (DISTANCE_EDUCATION, FULL_TIME_EDUCATION, EVENING_CLASSES):", false, commandsManager, "String");
            if (equalsPart(arguments[4],"FULL_TIME_EDUCATION")){
                arguments[4]=trimString("FULL_TIME_EDUCATION",arguments[4]);
            }
            if (equalsPart(arguments[4],"DISTANCE_EDUCATION")){
                arguments[4]=trimString("DISTANCE_EDUCATION",arguments[4]);
            }
            if (equalsPart(arguments[4],"EVENING_CLASSES")){
                arguments[4]=trimString("EVENING_CLASSES",arguments[4]);
            }
            if (commandsManager.isScript()) {
                break;
            }
        }

        arguments[5] = "";

        while(!arguments[5].equals("FIRST") && !arguments[5].equals("SECOND") && !arguments[5].equals("THIRD") && !arguments[5].equals("FIFTH") && !arguments[5].equals("SEVENTH")) {
            arguments[5] = InputValidation("Выберите форму обучения (FIRST, SECOND, THIRD, FIFTH, SEVENTH):", false, commandsManager, "String");
            if (CommandsManager.equalsPart(arguments[5],"FIRST")){
                arguments[5]=trimString("FIRST",arguments[5]);
            }
            if (CommandsManager.equalsPart(arguments[5],"SECOND")){
                arguments[5]=trimString("SECOND",arguments[5]);
            }
            if (CommandsManager.equalsPart(arguments[5],"THIRD")){
                arguments[5]=trimString("THIRD",arguments[5]);
            }
            if (CommandsManager.equalsPart(arguments[5],"FIFTH")){
                arguments[5]=trimString("FIFTH",arguments[5]);
            }
            if (CommandsManager.equalsPart(arguments[5],"SEVENTH")){
                arguments[5]=trimString("SEVENTH",arguments[5]);
            }
            if (commandsManager.isScript()) {
                break;
            }
        }

        arguments[6] = InputValidation("Введите имя человека:", false, commandsManager, "String");
        arguments[7] = InputValidation("Введите дату рождения, разделив числа точками(число.месяц.год):", false, commandsManager, "data.");
        arguments[8] = InputValidation("Введите рост человека:", false, commandsManager, "double");
        arguments[9] = InputValidation("Введите вес человека:", false, commandsManager, "double");
        arguments[10] = InputValidation("Введите номер паспорта:", false, commandsManager, "String40");
        return Parcer.rebirthInputArguments(arguments);
    }


    static String InputValidation(String message, Boolean maybenull, CommandsManager commandsManager, String type) {
        String line = "";

        try {
            Scanner scanner = new Scanner(System.in);

            do {
                if (!commandsManager.isScript()) {
                    System.out.println(message);
                }
                line = commandsManager.isScript() ? commandsManager.getScriptBufferedReader().readLine() : scanner.nextLine().trim();
            } while(!maybenull && line.isEmpty());
            if ((line == null)||(line.equals(""))){
                throw new NullPointerException();
            }
            else if (type.equals("String40")){
                if (line.length() > 40){
                    throw new NumberFormatException();
                }
            }
            else if (type.equals("double")){
                double num = Double.parseDouble(line);
                if (num < 0 ){
                    throw new NumberFormatException();
                }
                line = "" + num;
            }
            else if (type.equals("data.")){
                line = "" + stringToTime(line);
            }
        } catch (FileNotFoundException var5) {
            System.out.println("Файл не найден");
        } catch (NullPointerException var6) {
        } catch (NumberFormatException | IOException | DateTimeException var7) {
            System.out.print("Введены неверные данные. ");
            line = InputValidation(message, maybenull, commandsManager, type);
            if (commandsManager.isScript()) {
                return line;
            }
        }

        return line;
    }


    static String InputValidation(String message, float min, float max, CommandsManager commandsManager) {
        String line = "";

        try {
            Scanner scanner = new Scanner(System.in);

            do {
                if (!commandsManager.isScript()) {
                    System.out.println(message);
                }

                line = commandsManager.isScript() ? commandsManager.getScriptBufferedReader().readLine() : scanner.nextLine().trim();
                if (!commandsManager.isScript()) {
                    if (Float.parseFloat(line) > max || Float.parseFloat(line) < min) {
                        System.out.print("Значение вне диапазона. ");
                        line = InputValidation(message, min, max, commandsManager);
                    }
                    Float.parseFloat(line);
                }
            } while(line.isEmpty());
            return line;
        } catch (FileNotFoundException var6) {
            System.out.println("Файл не найден");
            return null;
        } catch (Exception var7) {
            System.out.print("Введены неверные данные.");
            return commandsManager.isScript() ? line : InputValidation(message, min, max, commandsManager);
        }
    }

    static String InputValidation(String message, int min, int max, CommandsManager commandsManager) {
        String line = "";

        try {
            Scanner scanner = new Scanner(System.in);

            do {
                if (!commandsManager.isScript()) {
                    System.out.println(message);
                }

                line = commandsManager.isScript() ? commandsManager.getScriptBufferedReader().readLine() : scanner.nextLine().trim();
                if (!commandsManager.isScript()) {
                    if (Integer.parseInt(line) > max || Integer.parseInt(line) < min) {
                        System.out.print("Значение вне диапазона. ");
                        line = InputValidation(message, min, max, commandsManager);
                    }

                    Integer.parseInt(line);
                }
            } while(line.isEmpty());

            return line;
        } catch (FileNotFoundException var6) {
            System.out.println("Файл не найден");
            return null;
        } catch (Exception var7) {
            System.out.print("Введены неверные данные.");
            return commandsManager.isScript() ? line : InputValidation(message, min, max, commandsManager);
        }
    }
    public static LocalDate stringToTime(String arguments) {
        LocalDate birthday = null;
        int day = 0;
        int mounth = 0;
        String arg = "";
        int point = 1;
        for (int i = 0; i < arguments.length(); ++i) {
            int year;
            if (arguments.charAt(i) != '.' && arguments.charAt(i) != ' ') {
                arg = arg + arguments.charAt(i);
            } else if (arguments.charAt(i) == '.' | (arguments.charAt(i) == ' ' && i != 1)) {
                if (point == 1) {
                    day = Integer.parseInt(arg);
                    arg = "";
                    ++point;
                } else if (point == 2) {
                    mounth = Integer.parseInt(arg);
                    arg = "";
                    ++point;
                } else if (point == 3) {
                    year = Integer.parseInt(arg);
                    arg = "";
                    birthday = LocalDate.of(year, mounth, day);
                    point = 1;
                }
            }
            if (i == arguments.length() - 1) {
                year = Integer.parseInt(arg);
                birthday = LocalDate.of(year, mounth, day);
            }
        }
        return birthday;
    }
    public static void fillEmptyFile(PriorityQueue<StudyGroup> priorityQueue, Scanner scanner){
        try {
            Parcer.setCountColumn(11);
            if (priorityQueue.add(UserInput.argumentsReader(CommandsManager.getCommandsManager())) && !CommandsManager.getCommandsManager().isNotPrintAdd()) {
                System.out.println("Элемент добавлен в коллекцию");
            }
        } catch (NotCorrectValueException e) {
            e.printStackTrace();
        }
    }
    public static String trimString(String trimmed, String norm) {
        int index = -1;
        if (!trimmed.equals("") && trimmed.length() >= norm.length()) {
            for(int i = 0; i < norm.length(); ++i) {
                if (looseEquals(norm.substring(i, i + 1), trimmed.substring(i, i + 1))) {
                    index = i;
                }
            }

            trimmed = trimmed.substring(index + 1);
            trimmed = trimmed.trim();
        }

        return trimmed;
    }
}
