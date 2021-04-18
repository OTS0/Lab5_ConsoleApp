package ConsoleApplication;

import ConsoleApplication.command.CommandsManager;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Класс для пользовательского ввода
 */

public class UserInput {

    /**
     * Создает аргументы
     * @param commandsManager
     * @return
     * @throws NotCorrectValueException
     */

    public static StudyGroup argumentsReader(CommandsManager commandsManager) throws NotCorrectValueException {
        String[]arguments = new String[Parcer.getCountColumn()];
        arguments[0] = InputValidation("Введите название группы:", false, commandsManager);
        arguments[1] = InputValidation("Введите координату x(вещественное число):", Float.MIN_VALUE, Coordinates.getMaxValueX(), commandsManager);
        arguments[2] = InputValidation("Введите координату y(вещественное число):", Float.MIN_VALUE, Coordinates.getMaxValueY(), commandsManager);
        arguments[3] = InputValidation("Введите количество студентов ", Integer.MIN_VALUE,Integer.MAX_VALUE, commandsManager);
        arguments[4] = "";
        while (!arguments[4].equals("DISTANCE_EDUCATION") && !arguments[4].equals("FULL_TIME_EDUCATION") && !arguments[4].equals("EVENING_CLASSES") ){
            arguments[4] = InputValidation("Выберите форму обучения (DISTANCE_EDUCATION, FULL_TIME_EDUCATION, EVENING_CLASSES):", false, commandsManager);
            if (commandsManager.isScript()) break;
        }
        arguments[5]="";
        while (!arguments[5].equals("FIRST") && !arguments[5].equals("SECOND") && !arguments[5].equals("THIRD")&& !arguments[5].equals("FIFTH")&& !arguments[5].equals("SEVENTH") ){
            arguments[5] = InputValidation("Выберите форму обучения (FIRST, SECOND, THIRD, FIFTH, SEVENTH):", false, commandsManager);
            if (commandsManager.isScript()) break;
        }
        arguments[6] = InputValidation("Введите имя человека:", false, commandsManager);
        arguments[7] = InputValidation("Введите дату рождения, разделив числа точками(число.месяц.год):", false, commandsManager);
        arguments[8] = InputValidation("Введите рост человека:", false, commandsManager);
        arguments[9] = InputValidation("Введите вес человека:", false, commandsManager);
        arguments[10] = InputValidation("Введите номер паспорта:", false, commandsManager);

        return Parcer.rebirthInputArguments(arguments);
    }

    /**
     * Проверяет корректность введенных данных
     * @param message
     * @param maybenull
     * @param commandsManager
     * @return
     */

    static String InputValidation(String message, Boolean maybenull, CommandsManager commandsManager) {
        String line = "";
        try {
            Scanner scanner = new Scanner(System.in);
            do {
                if (!commandsManager.isScript()) System.out.println(message);
                line = commandsManager.isScript() ? commandsManager.getScriptBufferedReader().readLine() : scanner.nextLine();
            } while (!maybenull && line.isEmpty());
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        } catch (NullPointerException ignored) {
        } catch (Exception e) {
            System.out.print("Введены неверные данные. ");
            if (commandsManager.isScript()) return line;
        }
        return line;
    }

    /**
     * Проверяет корректность введенных данных
     * @param message
     * @param min
     * @param max
     * @param commandsManager
     * @return
     */

    static String InputValidation(String message, float min, float max, CommandsManager commandsManager) {
        String line = "";
        try {
            Scanner scanner = new Scanner(System.in);
            do {
                if (!commandsManager.isScript()) System.out.println(message);
                line = commandsManager.isScript() ? commandsManager.getScriptBufferedReader().readLine() : scanner.nextLine();
                if (!commandsManager.isScript()) {
                    if ((Float.parseFloat(line) > max || Float.parseFloat(line) < min)) {
                        System.out.print("Значение вне диапазона. ");
                        line = InputValidation(message, min, max, commandsManager);
                    }
                    Float.parseFloat(line);
                }
            } while (line.isEmpty());
            return line;
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
            return null;
        } catch (Exception e) {
            System.out.print("Введены неверные данные.");
            if (commandsManager.isScript()) return line;
            else return InputValidation(message, min, max, commandsManager);
        }
    }

    /**
     * Проверяет корректность введенных данных
     * @param message
     * @param min
     * @param max
     * @param commandsManager
     * @return
     */

    static String InputValidation(String message, int min, int max, CommandsManager commandsManager) {
        String line = "";
        try {
            Scanner scanner = new Scanner(System.in);
            do {
                if (!commandsManager.isScript()) System.out.println(message);
                line = commandsManager.isScript() ? commandsManager.getScriptBufferedReader().readLine() : scanner.nextLine();
                if (!commandsManager.isScript()) {
                    if ((Integer.parseInt(line) > max || Integer.parseInt(line) < min)) {
                        System.out.print("Значение вне диапазона. ");
                        line = InputValidation(message, min, max, commandsManager);
                    }
                    Integer.parseInt(line);
                }
            } while (line.isEmpty());
            return line;
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
            return null;
        } catch (Exception e) {
            System.out.print("Введены неверные данные.");
            if (commandsManager.isScript()) return line;
            else return InputValidation(message, min, max, commandsManager);
        }
    }
}
