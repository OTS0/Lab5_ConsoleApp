//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package ConsoleApplication.command;

import ConsoleApplication.StudyGroup;
import java.util.PriorityQueue;

public class Clear extends Command {
    public Clear() {
        this.name = "clear";
        this.help = "очищает коллекцию";
    }

    public void realize(String[] args, PriorityQueue<StudyGroup> priorityQueue, CommandsManager commandsManager, History history) {
        if (args.length > 0) {
            System.out.println("Команда не принимает аргументы");
        } else {
            priorityQueue.clear();
            System.out.println("Коллекция очищена");
        }

    }
}
