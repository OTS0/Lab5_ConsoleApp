package ConsoleApplication.command;

import ConsoleApplication.StudyGroup;

import java.util.PriorityQueue;

/**
 * Класс команды exit
 */

public class Exit extends Command{
    public Exit(){
        name="exit";
        help="Завершает программу (без сохранения в файл)";
    }

    /**
     * завершает команду
     * @param args
     * @param priorityQueue
     * @param commandsManager
     * @param history
     */

    @Override
    public void realize(String[] args, PriorityQueue<StudyGroup> priorityQueue, CommandsManager commandsManager, History history) {
        if (args.length > 0) System.out.println("Команда не принимает аргументы");
        else {
            System.exit(0);
        }
    }

}