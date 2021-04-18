package ConsoleApplication.command;
import ConsoleApplication.StudyGroup;
import java.util.PriorityQueue;

/**
 * Класс команды clear
 */
public class Clear extends Command{
    public Clear() {
        name = "clear";
        help = "очищает коллекцию";
    }

    /**
     * очищает коллекцию
     * @param args
     * @param priorityQueue
     * @param commandsManager
     * @param history
     */
    @Override
    public void realize(String[] args, PriorityQueue<StudyGroup> priorityQueue, CommandsManager commandsManager, History history) {
            if (args.length > 0) System.out.println("Команда не принимает аргументы");
            else {
                priorityQueue.clear();
                System.out.println("Коллекция очищена");
            }
        }

}
