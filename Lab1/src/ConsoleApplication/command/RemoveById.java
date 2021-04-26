//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package ConsoleApplication.command;

import ConsoleApplication.StudyGroup;
import java.util.Iterator;
import java.util.PriorityQueue;

public class RemoveById extends Command {
    public RemoveById() {
        this.name = "remove_by_id";
        this.help = "удаляет элемент из коллекции по его id";
    }

    public void realize(String[] args, PriorityQueue<StudyGroup> priorityQueue, CommandsManager commandsManager, History history) {
        if (args.length != 1) {
            System.out.println("Команда принимает лишь один аргумент");
        } else {
            try {
                long id = Long.parseLong(args[0]);
                commandsManager.setExist(false);
                Iterator var7 = priorityQueue.iterator();

                while(var7.hasNext()) {
                    StudyGroup studyGroup = (StudyGroup)var7.next();
                    if ((long)studyGroup.getId() == id) {
                        commandsManager.setExist(true);
                        break;
                    }
                }

                priorityQueue.removeIf((studyGroupx) -> {
                    return (long)studyGroupx.getId() == id;
                });
                if (!commandsManager.isExist()) {
                    System.out.println("Элемент коллекции с id = " + args[0] + " не найден");
                } else if (!commandsManager.isNotPrintAdd()) {
                    System.out.println("Элемент коллекции с id = " + args[0] + " удалён");
                }
            } catch (Exception var9) {
                System.out.println("Неверный тип аргумента");
            }
        }

    }
}
