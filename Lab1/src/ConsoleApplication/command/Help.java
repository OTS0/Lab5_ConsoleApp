package ConsoleApplication.command;

import ConsoleApplication.StudyGroup;

import java.util.PriorityQueue;

/**
 * Класс команды help
 */

public class Help extends Command{
    public Help(){
        name="help";
        help="выводит справку по доступным командам";
    }

    /**
     * выводит список доступных команд
     * @param args
     * @param priorityQueue
     * @param commandsManager
     * @param history
     */

    @Override
    public void realize(String[] args, PriorityQueue<StudyGroup> priorityQueue, CommandsManager commandsManager, History history) {
        if (args.length > 0) {
            System.out.println("На данном этапе команда не принимает аргументы");
        } else
            for (Command command : commandsManager.getCommands())
                System.out.println("Команда " + command.getName() + ": " + command.getHelp());
    }

}