//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package ConsoleApplication;

import ConsoleApplication.command.CommandsManager;
import ConsoleApplication.command.History;
import ConsoleApplication.command.Save;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.DateTimeException;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static Date creationDate;
    private static String[][] arguments;
    private static int countStr;

    public Main() {
    }

    public static void main(String[] args) throws NotCorrectValueException {
        FileInputStream fileInputStream = null;
        FileInputStream fileInputStream1 = null;
        InputStreamReader inputStream = null;
        InputStreamReader inputStream1 = null;
        Scanner scanner = new Scanner(System.in);
        Comparator<StudyGroup> idComparator = (o1, o2) -> {
            return o1.getId() - o2.getId();
        };
        PriorityQueue<StudyGroup> priorityQueue = new PriorityQueue(idComparator);
        String file = System.getenv("NAME");
        if (file == null) {
            System.out.println("Файл не найден. Возможно вы забыли экспортировать переменную NAME.");
            System.out.println("Попробуйте прописать имя файла (прописывая весь путь)");
            String arg = Parcer.repeatInput(scanner);
            Save.setFile(arg);
            if (arg == null) {
                System.out.println("Имя файла не прописано");
                System.exit(0);
            } else {
                arg = arg.trim();
            }

            try {
                fileInputStream = new FileInputStream(arg);
                fileInputStream1 = new FileInputStream(arg);
            } catch (FileNotFoundException var32) {
                System.out.println("Файл не найден.Попробуйте экспортировать переменную NAME, прописав разрешение файла.");
                System.exit(0);
            } catch (NullPointerException var33) {
                System.out.println("Некорректный файл");
            } catch (ArrayIndexOutOfBoundsException var34) {
                System.out.println("Некорректно прописан путь.");
                System.exit(0);
            } finally {
                inputStream = new InputStreamReader(fileInputStream);
                inputStream1 = new InputStreamReader(fileInputStream1);
            }
        } else {
            File f = new File(System.getenv("NAME"));
            if (!f.exists()) {
                System.out.println("Файл не найден");
                System.exit(0);
            }
             else if (f.canRead()) {
                try {
                    fileInputStream = new FileInputStream(file);
                    inputStream = new InputStreamReader(fileInputStream);
                    fileInputStream1 = new FileInputStream(file);
                    inputStream1 = new InputStreamReader(fileInputStream1);
                } catch (FileNotFoundException var30) {
                    System.out.println("Переменная NAME не экспортирована.");
                    System.exit(0);
                } catch (NullPointerException var31) {
                    System.out.println("null");
                }
            } else {
                System.out.println("Нет прав для прочтения этого файла");
                System.exit(0);
            }
        }

        if (file != null) {
            Save.setFile(file);
        }

        History history = new History();
        Scanner scanner1 = new Scanner(System.in);
        creationDate = new Date();
        int countColumn = 0;

        try {
            countColumn = Parcer.countCountColumn(inputStream);
        } catch (IOException | NullPointerException var29) {
            System.out.println("Некорректное имя файла (или путь к нему)");
            System.exit(0);
        }

        Parcer parcer = Parcer.parseProductCsv(inputStream1, countColumn);
        arguments = Parcer.args;
        countStr = Parcer.getCount();

        try {
            inputStream.close();
        } catch (IOException var28) {
            var28.printStackTrace();
        }

        for(int i = 1; i < countStr + 1; ++i) {
            StudyGroup studyGroup = null;

            try {
                studyGroup = Parcer.rebirthArguments(arguments, i);
            } catch (ArrayIndexOutOfBoundsException var27) {
                System.out.println("Файл пуст.Давайте заполним его)");
                UserInput.fillEmptyFile(priorityQueue,scanner);
            } catch (NotCorrectValueException | NullPointerException | DateTimeException | IllegalArgumentException r){
                System.out.println("В файле ошибки! ");
                System.exit(0);
            }

            if (studyGroup != null) {
                priorityQueue.add(studyGroup);
            }
        }

        System.out.println("Коллекция загружена! Можно приступать к работе!");

        while(true) {
            System.out.println("Введите команду:");
            if (args.length < 0 || args.length > 2) {
                System.out.println("Неверное количество аргументов");
            }

            if (args.length == 1) {
                args = new String[]{args[0], ";"};
            }

            try {
                CommandsManager.realizeCommand(scanner1.nextLine().split(" "), priorityQueue, history, parcer);
            } catch (NoSuchElementException var26) {
                System.out.println("Не вводите ctrl_D больше НИКОГДА, пожалуйта");
                System.exit(0);
            }
        }
    }
}
