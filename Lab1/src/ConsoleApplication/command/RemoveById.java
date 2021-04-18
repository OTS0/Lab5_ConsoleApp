package ConsoleApplication.command;
import ConsoleApplication.StudyGroup;
import java.util.PriorityQueue;

/**
 * Класс команды remove_by_id
 */

public class RemoveById extends Command {
    public RemoveById() {
        name = "remove_by_id";
        help = "удаляет элемент из коллекции по его id";
    }

    /**
     * удаляет элемент из коллекции по его id
     * @param args
     * @param priorityQueue
     * @param commandsManager
     * @param history
     */

    @Override
    public void realize(String[] args, PriorityQueue<StudyGroup> priorityQueue, CommandsManager commandsManager,History history) {
        if (args.length != 1) {
            System.out.println("Команда принимает лишь один аргумент");
        } else {
            try {
                long id = Long.parseLong(args[0]);
                commandsManager.setExist(false);
                for (StudyGroup studyGroup : priorityQueue)
                    if (studyGroup.getId() == id) {
                        commandsManager.setExist(true);
                        break;
                    }
                priorityQueue.removeIf(studyGroup -> studyGroup.getId() == id);
                if (!commandsManager.isExist()) {
                    System.out.println("Элемент коллекции с id = " + args[0] + " не найден");
                } else if (!commandsManager.isNotPrintAdd())
                    System.out.println("Элемент коллекции с id = " + args[0] + " удалён");

            } catch (Exception e) {
                System.out.println("Неверный тип аргумента");
            }
        }
    }
}
