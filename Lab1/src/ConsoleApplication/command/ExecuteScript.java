//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package ConsoleApplication.command;

import ConsoleApplication.StudyGroup;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.PriorityQueue;

public class ExecuteScript extends Command {
    HashSet<String> scriptsNames = new HashSet();

    public ExecuteScript() {
        this.name = "execute_script";
        this.help = "Запускает исполняемый скрипт";
    }

    public void realize(String[] args, PriorityQueue<StudyGroup> priorityQueue, CommandsManager commandsManager, History history) {
        if (args.length > 1) {
            System.out.println("Команда принимает лишь один аргумент");
        } else if (args.length == 0) {
            System.out.println("Данная команда требует введения аргумента");
        }
        else {
            commandsManager.setScript(true);

            try {
                String sfn = args[0];
                commandsManager.setScriptFileName(sfn);
                commandsManager.setScriptBufferedReader(new BufferedReader(new FileReader(commandsManager.getScriptFileName())));
                String line = "";

                while(true) {
                    line = commandsManager.getScriptBufferedReader().readLine();
                    String[] nargs = line.split(" ");
                    if (nargs[0].equals("execute_script")) {
                        if (!this.scriptsNames.contains(nargs[1])) {
                            this.scriptsNames.add(sfn);
                            CommandsManager.realizeCommand(nargs, priorityQueue, history);
                        } else {
                            System.out.println("Мы против рекурсии (или вы не можете выполнить команду в исполняемом скрипте, которая вызывает исполняемый скрипт, содержащий команду вызова другого исполняемого скрипта, который уже исполнялся ранее)");
                            System.out.println("Не удалось выполнить: execute_script " + sfn + ". Запущенные скрипты: " + this.scriptsNames);
                        }
                    } else {
                        CommandsManager.realizeCommand(nargs, priorityQueue, history);
                    }

                    this.scriptsNames.add(sfn);
                }
            } catch (NullPointerException var8) {
            } catch (FileNotFoundException var9) {
                System.out.println("Файл не найден");
            } catch (IOException var10) {
                var10.printStackTrace();
            }
        }

        commandsManager.setScript(false);
        this.scriptsNames.clear();
    }
}
