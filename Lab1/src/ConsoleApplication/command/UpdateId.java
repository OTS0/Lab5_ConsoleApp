//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package ConsoleApplication.command;

import ConsoleApplication.StudyGroup;
import java.util.PriorityQueue;

public class UpdateId extends Command {
    public UpdateId() {
        this.name = "update_id";
        this.help = "обновляет значение элемента коллекции, id которого равен заданному";
    }

    public void realize(String[] args, PriorityQueue<StudyGroup> priorityQueue, CommandsManager commandsManager, History history) {
        try {
            if (args.length != 1) {
                System.out.println("Команда принимает лишь один аргумент");
                if (commandsManager.isScript()) {
                    commandsManager.commandRewider();
                }
            } else {
                long oldIdSetter = (long)StudyGroup.idSetter;
                commandsManager.setNotPrintAdd(true);
                StudyGroup.idSetter = Integer.parseInt(args[0]);
                String[] nargs = new String[]{"remove_by_id", args[0]};
                CommandsManager.realizeCommand(nargs, priorityQueue, history);
                if (commandsManager.isExist()) {
                    nargs = new String[]{"add_element"};
                    CommandsManager.realizeCommand(nargs, priorityQueue, history);
                    System.out.println("Элемент с id = " + StudyGroup.idSetter + " обновлён");
                }

                StudyGroup.idSetter = (int)oldIdSetter;
            }
        } catch (NullPointerException var8) {
        } catch (Exception var9) {
            System.out.println("Неверный тип аргумента");
            if (commandsManager.isScript()) {
                commandsManager.commandRewider();
            }
        }

        commandsManager.setNotPrintAdd(false);
    }
}
