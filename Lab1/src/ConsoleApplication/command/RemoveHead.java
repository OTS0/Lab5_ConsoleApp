//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package ConsoleApplication.command;

import ConsoleApplication.StudyGroup;
import java.util.PriorityQueue;

public class RemoveHead extends Command {
    public RemoveHead() {
        this.name = "remove_head";
        this.help = "выводит первый элемент коллекции и удаляет его";
    }

    public void realize(String[] args, PriorityQueue<StudyGroup> priorityQueue, CommandsManager commandsManager, History history) {
        if (args.length > 0) {
            System.out.println("Команда не принимает аргументы");
        } else {
            try {
                System.out.println("Первый элемент " + priorityQueue.poll() + " удалён");
            } catch (Exception var6) {
                System.out.println("Список пуст");
            }
        }

    }
}
