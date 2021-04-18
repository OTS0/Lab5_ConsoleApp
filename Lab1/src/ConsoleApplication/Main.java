package ConsoleApplication;
import ConsoleApplication.command.CommandsManager;
import ConsoleApplication.command.History;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;
/**
 * Main class
 *
 * @author Осинина Татьяна, R3137
 */
public class Main {
    public static Date creationDate;
    private static String[][] arguments;
    private static int countStr;
    public static void main(String[] args) throws Exception {
        PriorityQueue<StudyGroup> priorityQueue = new PriorityQueue<>(idComparator);
        InputStreamReader inputStream= new InputStreamReader(new FileInputStream("C:/Users/OTS/Desktop/laba/labapro/progr/popyitka0.csv"));
        creationDate=new Date();
/**
 * Чтение из файла
 */
        try{
            History history=new History();
            Scanner scanner = new Scanner(System.in);
            int countColumn=Parcer.countCountColumn(inputStream);
            InputStreamReader inputStream1= new InputStreamReader(new FileInputStream("C:/Users/OTS/Desktop/laba/labapro/progr/popyitka0.csv"));
            Parcer parcer=Parcer.parseProductCsv(inputStream1,countColumn);
            arguments=parcer.args;
            countStr=parcer.getCount();
            inputStream.close();

/**
 * Загрузка коллекции
 */
            for (int i=1;i<countStr+1;i++){
                StudyGroup studyGroup=Parcer.rebirthArguments(arguments,i);
            if (studyGroup != null)
            {priorityQueue.add(studyGroup);}
            }
            System.out.println("Коллекция загружена! Можно приступать к работе!");

            /**
             * Реализация команд
             */

            while (true) {
                System.out.println("Введите команду:");
                if (args.length < 0 || args.length > 2) {
                    System.out.println("Неверное количество аргументов");
                }
                if (args.length == 1) {
                    args = new String[]{args[0], ";"};
                }
                CommandsManager.realizeCommand(scanner.nextLine().split(" "), priorityQueue,history,parcer);
            }
        }
        catch (NoSuchElementException ignored) {
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * Переопределение интерфейса Comparator для сравнения элементов коллекции по полю id
     */
    public static Comparator<StudyGroup> idComparator = (o1, o2) -> (int) (o1.getId() - o2.getId());
}