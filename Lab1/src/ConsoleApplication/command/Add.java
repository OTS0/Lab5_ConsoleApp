//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package ConsoleApplication.command;

import ConsoleApplication.NotCorrectValueException;
import ConsoleApplication.StudyGroup;
import ConsoleApplication.UserInput;
import java.util.PriorityQueue;

public class Add extends Command {
    public Add() {
        this.name = "add_element";
        this.help = "добавляет новый элемент в коллекцию";
    }

    public void realize(String[] args, PriorityQueue<StudyGroup> priorityQueue, CommandsManager commandsManager, History history) {
        try {
            if (commandsManager.isScript()) {
                if (args.length > 0) {
                    System.out.println("На данном этапе команда не принимает аргументы");
                    commandsManager.commandRewider();
                }
            } else if (priorityQueue.add(UserInput.argumentsReader(commandsManager)) && !commandsManager.isNotPrintAdd()) {
                System.out.println("Элемент добавлен в коллекцию");
            }
        } catch (NotCorrectValueException | NullPointerException var6) {
        }

    }
}
