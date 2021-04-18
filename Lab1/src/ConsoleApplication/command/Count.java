package ConsoleApplication.command;
import ConsoleApplication.StudyGroup;
import java.util.PriorityQueue;

/**
 * Класс команды count_by_students_count
 */
public class Count extends Command{
    public Count(){
        name="count_by_students_count";
        help="выводит количество элементов, значение поля studentsCount которых равно заданному";
    }
    static long studentCount;
    int count=0;
    @Override

    /**
     * выводит количество элементов, значение поля studentsCount которых равно введеному
     */
    public void realize(String[] args, PriorityQueue<StudyGroup> priorityQueue, CommandsManager commandsManager, History history) {
        if (args.length != 1)
            System.out.println("Команда принимает лишь один аргумент");
        else {
            System.out.println(args[0]);
            try{
                if (args[0]!=null && Long.parseLong(args[0])>0){
                    studentCount=Long.parseLong(args[0]);
                }
                    for (StudyGroup each : priorityQueue) {

                        if (each.getStudentsCount() == studentCount) {
                            count++;
                            commandsManager.setExist(true);
                            break;
                        }
                    }
                    if (count!=0) {
                        System.out.println("Количество элементов, значение поля studentsCount которых равно "+studentCount +", - "+count);
                        count=0;
                    }
                    else{
                        System.out.println("Элемент, значение поля studentsCount которых равно "+studentCount+ ", не найден");
                    }
            } catch (Exception e) {
                System.out.println("Неверный тип аргумента");
            }
        }
    }
}