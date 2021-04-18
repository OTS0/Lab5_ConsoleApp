package ConsoleApplication.command;
import ConsoleApplication.Coordinates;
import ConsoleApplication.Main;
import ConsoleApplication.Parcer;
import ConsoleApplication.StudyGroup;

import java.io.*;
import java.util.PriorityQueue;

/**
 * Класс команды save
 */

public class Save extends Command{
public Save(){
    name="save";
    help="сохраняет коллекцию в файл";
}

    /**
     * сохраняет коллекцию в файл
     * @param args
     * @param priorityQueue
     * @param commandsManager
     * @param history
     */

    @Override
    public void realize(String[] args, PriorityQueue<StudyGroup> priorityQueue, CommandsManager commandsManager, History history) {
        String text="";
        int i=0;
            for (StudyGroup studyGroup : priorityQueue) {
                String element = studyGroup.getName() + "," + String.valueOf(studyGroup.getId()) +","+ studyGroup.getCreationDate() + "," +
                        String.valueOf(studyGroup.getCoordinates().getX()) + "," + String.valueOf(studyGroup.getCoordinates().getY()) + "," +
                        String.valueOf(studyGroup.getStudentsCount()) + "," + String.valueOf(studyGroup.getFormOfEducation()) + "," +
                        String.valueOf(studyGroup.getSemesterEnum()) + ","  + studyGroup.getGroupAdmin().getName() + "," + String.valueOf(studyGroup.getGroupAdmin().getBirthday()) + "," +
                        String.valueOf(studyGroup.getGroupAdmin().getHeight()) + ","
                        + String.valueOf(studyGroup.getGroupAdmin().getWeight()) + ","
                        + String.valueOf(studyGroup.getGroupAdmin().getPassportID());
                if (i == 0) {
                    text = element;
                } else {
                    text = text + "\n" + element;
                }
                i++;
            }

    try(FileOutputStream out=new FileOutputStream("C:/Users/OTS/Desktop/laba/labapro/progr/popyitka0.csv");
            BufferedOutputStream outputStream = new BufferedOutputStream(out))
        {byte[] buffer = text.getBytes();
            outputStream.write(buffer, 0, buffer.length);

    } catch (FileNotFoundException fileNotFoundException) {
        fileNotFoundException.printStackTrace();
    } catch (IOException ioException) {
        ioException.printStackTrace();
    }

    System.out.println("Коллекция сохранена!");
}
}