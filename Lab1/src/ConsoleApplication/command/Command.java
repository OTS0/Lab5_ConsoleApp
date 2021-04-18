package ConsoleApplication.command;
import java.util.PriorityQueue;

import ConsoleApplication.Parcer;
import ConsoleApplication.StudyGroup;


public abstract class Command {
    protected String name;
    protected String help;

    /**
     * @return название команды
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return описание команды
     */
    public String getHelp() {
        return help;
    }

    /**
     * Исполнение команды
     * @param args
     * @param priorityQueue
     * @param commandsManager
     */
    public abstract void realize(String[] args,PriorityQueue<StudyGroup> priorityQueue,CommandsManager commandsManager, History history);

}
