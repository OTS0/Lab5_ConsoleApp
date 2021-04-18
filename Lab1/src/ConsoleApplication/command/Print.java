package ConsoleApplication.command;

import ConsoleApplication.StudyGroup;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Класс команды print_ascending
 */

public class Print extends Command{
public Print(){
    name="print_ascending";
    help="выводит элементы коллекции в порядке возрастания";
}

    /**
     * выводит элементы коллекции в порядке возрастания
     * @param args
     * @param priorityQueue
     * @param commandsManager
     * @param history
     */

    @Override
    public void realize(String[] args, PriorityQueue<StudyGroup> priorityQueue, CommandsManager commandsManager, History history) {
       priorityQueue.stream().sorted();
        System.out.println(priorityQueue.toString());
    }
}