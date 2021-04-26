//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package ConsoleApplication.command;

import ConsoleApplication.StudyGroup;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Show extends Command {
    public Show() {
        this.name = "show";
        this.help = "выводит в стандартный поток вывода все элементы коллекции в строковом представлении";
    }

    public void realize(String[] args, PriorityQueue<StudyGroup> priorityQueue, CommandsManager commandsManager, History history) {
        if (args.length > 0) {
            System.out.println("Команда не принимает аргументы");
        } else {
            System.out.println(Arrays.toString(priorityQueue.toArray()));
        }

    }
}
