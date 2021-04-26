//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package ConsoleApplication.command;

import ConsoleApplication.StudyGroup;
import java.util.PriorityQueue;

public class RemoveFirst extends Command {
    public RemoveFirst() {
        this.name = "remove_first";
        this.help = "удаляет первый элемент из коллекции";
    }

    public void realize(String[] args, PriorityQueue<StudyGroup> priorityQueue, CommandsManager commandsManager, History history) {
        if (args.length > 0) {
            System.out.println("Команда не принимает аргументы");
        } else {
            try {
                System.out.println("Элемент с id = " + ((StudyGroup)priorityQueue.poll()).getId() + " удалён");
            } catch (Exception var6) {
                System.out.println("Список пуст");
            }
        }

    }
}
