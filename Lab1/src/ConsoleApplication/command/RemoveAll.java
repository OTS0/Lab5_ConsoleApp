//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package ConsoleApplication.command;

import ConsoleApplication.StudyGroup;
import java.util.Iterator;
import java.util.PriorityQueue;

public class RemoveAll extends Command {
    static long studentCount;

    public RemoveAll() {
        this.name = "remove_all_by_students_count";
        this.help = "удаляет из коллекции все элементы, значение поля studentsCount которого эквивалентно заданному";
    }

    public void realize(String[] args, PriorityQueue<StudyGroup> priorityQueue, CommandsManager commandsManager, History history) {
        boolean found = false;
        if (args.length != 1) {
            System.out.println("Команда принимает лишь один аргумент");
        } else {
            try {
                if (args[0] != null && Long.parseLong(args[0]) > 0L) {
                    studentCount = Long.parseLong(args[0]);
                }

                Iterator var6 = priorityQueue.iterator();

                while(var6.hasNext()) {
                    StudyGroup each = (StudyGroup)var6.next();
                    if (each.getStudentsCount() == studentCount) {
                        priorityQueue.remove(each);
                        System.out.println("Элемент с id = " + each.getId() + " удалён");
                        commandsManager.setExist(true);
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    System.out.println("Элемент с id = " + studentCount + " не найден");
                }
            } catch (Exception var8) {
                System.out.println(args[0]);
                System.out.println("Неверный тип аргумента");
            }
        }

    }
}
