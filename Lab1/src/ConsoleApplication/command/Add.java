package ConsoleApplication.command;
import ConsoleApplication.NotCorrectValueException;
import ConsoleApplication.StudyGroup;
import ConsoleApplication.UserInput;
import java.util.PriorityQueue;

/**
 * Класс команды add
 */
public class Add extends Command {
    public Add(){
    name="add_element";
    help="добавляет новый элемент в коллекцию";
    }

    /**
     * Добавляет новый элемент в колекцию
     * @param priorityQueue
     * @param commandsManager
     */

    @Override
    public void realize(String[]args,PriorityQueue<StudyGroup> priorityQueue, CommandsManager commandsManager, History history) {
        try {
                if (commandsManager.isScript()) {
                    if (args.length > 0) {
                        System.out.println("На данном этапе команда не принимает аргументы");
                    commandsManager.commandRewider();
                }
            } else {
                if (priorityQueue.add(UserInput.argumentsReader(commandsManager)) && !commandsManager.isNotPrintAdd()) {
                    System.out.println("Элемент добавлен в коллекцию");
                }
            }
        } catch (NullPointerException | NotCorrectValueException ignored) {
        }
    }

}
