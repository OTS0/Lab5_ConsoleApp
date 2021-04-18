package ConsoleApplication.command;
import ConsoleApplication.StudyGroup;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * Класс команды execute_script
 */
public class ExecuteScript extends Command{
    HashSet<String> scriptsNames = new HashSet<>();

    public ExecuteScript() {
        name = "execute_script";
        help = "Запускает исполняемый скрипт";
    }

    /**
     * считывает и исполняет скрипт из указанного файла
     * @param args
     * @param priorityQueue
     * @param commandsManager
     * @param history
     */

    @Override
    public void realize(String[] args, PriorityQueue<StudyGroup> priorityQueue, CommandsManager commandsManager,History history) {
        if (args.length != 1) System.out.println("Команда принимает лишь один аргумент");
        else {
            commandsManager.setScript(true);
            try {
                String sfn = args[0];
                commandsManager.setScriptFileName(sfn);
                commandsManager.setScriptBufferedReader(new BufferedReader(new FileReader(commandsManager.getScriptFileName())));
                String line = "";
                while (true) {
                    line = commandsManager.getScriptBufferedReader().readLine();
                    String[] nargs = line.split(" ");
                    if (nargs[0].equals("execute_script")) {
                        if (!scriptsNames.contains(nargs[1])) {
                            scriptsNames.add(sfn);
                            CommandsManager.realizeCommand(nargs, priorityQueue, history);
                        } else {
                            System.out.println("Мы против рекурсии (или вы не можете выполнить команду в исполняемом скрипте, которая вызывает исполняемый скрипт, содержащий команду вызова другого исполняемого скрипта, который уже исполнялся ранее)");
                            //надо присечь рекурсию, но скрипт из файла скрипта должно рабоатть нормально
                            System.out.println("Не удалось выполнить: execute_script " + sfn + ". Запущенные скрипты: " + scriptsNames);

                        }
                    }
                    else {
                        CommandsManager.realizeCommand(nargs, priorityQueue, history);
                    }
                    scriptsNames.add(sfn);
                }
            } catch (NullPointerException ignored) {
            } catch (FileNotFoundException e) {
                System.out.println("Файл не найден");

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        commandsManager.setScript(false);
        scriptsNames.clear();
    }

}