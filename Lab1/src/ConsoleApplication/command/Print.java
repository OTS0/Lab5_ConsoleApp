//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package ConsoleApplication.command;

import ConsoleApplication.StudyGroup;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Print extends Command {
    public static Comparator<StudyGroup> idComparator = (o1, o2) -> {
        return o1.getId() - o2.getId();
    };

    public Print() {
        this.name = "print_ascending";
        this.help = "выводит элементы коллекции в порядке возрастания";
    }

    public void realize(String[] args, PriorityQueue<StudyGroup> priorityQueue, CommandsManager commandsManager, History history) {
        priorityQueue.stream().sorted(idComparator);
        System.out.println(priorityQueue.toString());
    }
}
