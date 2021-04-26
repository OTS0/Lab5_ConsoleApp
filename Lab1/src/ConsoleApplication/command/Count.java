//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package ConsoleApplication.command;

import ConsoleApplication.StudyGroup;
import java.util.Iterator;
import java.util.PriorityQueue;

public class Count extends Command {
    static long studentCount;
    int count = 0;

    public Count() {
        this.name = "count_by_students_count";
        this.help = "выводит количество элементов, значение поля studentsCount которых равно заданному";
    }

    public void realize(String[] args, PriorityQueue<StudyGroup> priorityQueue, CommandsManager commandsManager, History history) {
        if (args.length != 1) {
            System.out.println("Команда принимает лишь один аргумент");
        } else {
            System.out.println(args[0]);

            try {
                if (args[0] != null && Long.parseLong(args[0]) > 0L) {
                    studentCount = Long.parseLong(args[0]);
                }

                Iterator var5 = priorityQueue.iterator();

                while(var5.hasNext()) {
                    StudyGroup each = (StudyGroup)var5.next();
                    if (each.getStudentsCount() == studentCount) {
                        ++this.count;
                        commandsManager.setExist(true);
                        break;
                    }
                }

                if (this.count != 0) {
                    System.out.println("Количество элементов, значение поля studentsCount которых равно " + studentCount + ", - " + this.count);
                    this.count = 0;
                } else {
                    System.out.println("Элемент, значение поля studentsCount которых равно " + studentCount + ", не найден");
                }
            } catch (Exception var7) {
                System.out.println("Неверный тип аргумента");
            }
        }

    }
}
