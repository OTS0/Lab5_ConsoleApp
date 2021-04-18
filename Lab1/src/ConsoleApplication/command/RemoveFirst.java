package ConsoleApplication.command;

import ConsoleApplication.StudyGroup;

import java.util.PriorityQueue;

/**
 * Класс команды remove_first
 */

public class RemoveFirst extends Command {
    public RemoveFirst() {
        name = "remove_first";
        help = "удаляет первый элемент из коллекции";
    }

    /**
     * удаляет первый элемент из коллекции
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
                System.out.println("Элемент с id = " + priorityQueue.poll().getId() + " удалён");
            } catch (Exception e) {
                System.out.println("Список пуст");
            }
        }

    }
}
