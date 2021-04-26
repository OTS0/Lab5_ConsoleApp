//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package ConsoleApplication.command;

import ConsoleApplication.StudyGroup;
import java.util.PriorityQueue;

public class History extends Command {
    int count = 12;
    int numberCommand = 0;
    String[] history;

    public History() {
        this.history = new String[this.count];
        this.name = "history";
        this.help = "выводит последние 12 команд (без их аргументов)";
    }

    public void setHistory(String[] history) {
        this.history = history;
    }

    public void setNumberCommand(int numberCommand) {
        this.numberCommand = numberCommand;
    }

    public void historyRemember(String command) {
        int i;
        if (this.numberCommand == 0) {
            for(i = 0; i < this.count; ++i) {
                this.history[i] = " ";
            }
        }

        if (this.numberCommand < this.count) {
            this.history[this.numberCommand] = command;
            this.setNumberCommand(++this.numberCommand);
        } else {
            for(i = 0; i < this.count - 1; ++i) {
                this.history[i] = this.history[i + 1];
            }

            this.history[this.count - 1] = command;
        }

        this.setHistory(this.history);
    }

    public void realize(String[] args, PriorityQueue<StudyGroup> priorityQueue, CommandsManager commandsManager, History history) {
        if (args.length > 0) {
            System.out.println("Команда не принимает аргументы");
        } else if (history.getHistory()[0] == null) {
            System.out.println("Не было исполнено ни одной команды, история пуста.");
        } else {
            System.out.println("история команд:");
            history.OutHistory();
        }

    }

    public String[] getHistory() {
        return this.history;
    }

    public void OutHistory() {
        for(int i = 0; i < this.history.length; ++i) {
            if (this.history[i] != " ") {
                if (i != this.history.length - 1) {
                    System.out.print(this.history[i] + ", ");
                } else {
                    System.out.print(this.history[i] + ".");
                    System.out.println();
                }
            }
        }

    }
}
