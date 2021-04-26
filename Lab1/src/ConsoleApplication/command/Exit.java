//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package ConsoleApplication.command;

import ConsoleApplication.StudyGroup;
import java.util.PriorityQueue;

public class Exit extends Command {
    public Exit() {
        this.name = "exit";
        this.help = "Завершает программу (без сохранения в файл)";
    }

    public void realize(String[] args, PriorityQueue<StudyGroup> priorityQueue, CommandsManager commandsManager, History history) {
        if (args.length > 0) {
            System.out.println("Команда не принимает аргументы");
        } else {
            System.exit(0);
        }

    }
}
