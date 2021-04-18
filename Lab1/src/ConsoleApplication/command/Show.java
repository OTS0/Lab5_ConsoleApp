package ConsoleApplication.command;

import ConsoleApplication.StudyGroup;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Класс команды show
 */

public class Show extends Command{
    public Show() {
        name = "show";
        help = "выводит в стандартный поток вывода все элементы коллекции в строковом представлении";
    }

    /**
     * выводит в стандартный поток вывода все элементы коллекции в строковом представлении
     * @param args
     * @param priorityQueue
     * @param commandsManager
     * @param history
     */

    @Override
    public void realize(String[] args, PriorityQueue<StudyGroup> priorityQueue, CommandsManager commandsManager,History history) {
        if (args.length > 0) {
            System.out.println("Команда не принимает аргументы");
        } else System.out.println(Arrays.toString(priorityQueue.toArray()));
    }
}