package ConsoleApplication.command;
import ConsoleApplication.StudyGroup;
import java.util.PriorityQueue;

/**
 * Класс команды remove_head
 */

public class RemoveHead extends Command{
    public RemoveHead(){
        name="remove_head";
        help="выводит первый элемент коллекции и удаляет его";
    }

    /**
     * выводит первый элемент коллекции и удаляет его
     * @param args
     * @param priorityQueue
     * @param commandsManager
     * @param history
     */

    @Override
    public void realize(String[] args, PriorityQueue<StudyGroup> priorityQueue, CommandsManager commandsManager,History history) {
        if (args.length > 0) System.out.println("Команда не принимает аргументы");
        else {
            try {
                System.out.println("Первый элемент " + priorityQueue.poll() + " удалён");
            } catch (Exception e) {
                System.out.println("Список пуст");
            }
        }
    }
}
