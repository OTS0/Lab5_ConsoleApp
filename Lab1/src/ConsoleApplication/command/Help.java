//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package ConsoleApplication.command;

import ConsoleApplication.StudyGroup;
import java.util.Iterator;
import java.util.PriorityQueue;

public class Help extends Command {
    public Help() {
        this.name = "help";
        this.help = "выводит справку по доступным командам";
    }

    public void realize(String[] args, PriorityQueue<StudyGroup> priorityQueue, CommandsManager commandsManager, History history) {
        if (args.length > 0) {
            System.out.println("На данном этапе команда не принимает аргументы");
        } else {
            Iterator var5 = CommandsManager.getCommands().iterator();

            while(var5.hasNext()) {
                Command command = (Command)var5.next();
                System.out.println("Команда " + command.getName() + ": " + command.getHelp());
            }
        }

    }
}
