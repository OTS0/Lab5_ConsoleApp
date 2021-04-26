//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package ConsoleApplication.command;

import ConsoleApplication.Main;
import ConsoleApplication.StudyGroup;
import java.util.PriorityQueue;

public class Info extends Command {
    public Info() {
        this.name = "info";
        this.help = "выводит в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)";
    }

    public void realize(String[] args, PriorityQueue<StudyGroup> priorityQueue, CommandsManager commandsManager, History history) {
        if (args.length > 0) {
            System.out.println("Команда не принимает аргументы");
        } else {
            System.out.println("Тип коллекции: " + priorityQueue.getClass().getName());
            System.out.println("Время создания коллекции: " + Main.creationDate);
            System.out.println("Количество элементов в коллеции: " + priorityQueue.size());
        }

    }
}
