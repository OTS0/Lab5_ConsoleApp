package ConsoleApplication.command;

import ConsoleApplication.StudyGroup;

import java.util.PriorityQueue;

/**
 * Класс команды remove_all_by_students_count
 */

public class RemoveAll extends Command{
    public RemoveAll(){
        name="remove_all_by_students_count";
        help="удаляет из коллекции все элементы, значение поля studentsCount которого эквивалентно заданному";
    }
    static long studentCount;

    /**
     * удаляет из коллекции все элементы, значение поля studentsCount которого эквивалентно заданному
     * @param args
     * @param priorityQueue
     * @param commandsManager
     * @param history
     */

    @Override
    public void realize(String[] args, PriorityQueue<StudyGroup> priorityQueue, CommandsManager commandsManager, History history) {
        boolean found=false;
        if (args.length != 1)
            System.out.println("Команда принимает лишь один аргумент");
        else {
            try{
                if (args[0]!=null && Long.parseLong(args[0])>0){
                    studentCount=Long.parseLong(args[0]);
                }
                for (StudyGroup each : priorityQueue) {

                    if (each.getStudentsCount() == studentCount) {
                        priorityQueue.remove(each);
                        System.out.println("Элемент с id = " + each.getId() + " удалён");
                        commandsManager.setExist(true);
                        found=true;
                        break;
                    }
                }
                if (!found){
                System.out.println("Элемент с id = " + studentCount +" не найден");}
            } catch (Exception e) {
                System.out.println(args[0]);
                System.out.println("Неверный тип аргумента");
            }
        }
    }
}
