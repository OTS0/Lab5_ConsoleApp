package ConsoleApplication.command;

import ConsoleApplication.StudyGroup;

import java.util.PriorityQueue;

/**
 * Класс команды history
 */

public class History extends Command {
    public History() {
        name = "history";
        help = "выводит последние 12 команд (без их аргументов)";

    }
    int count = 12, numberCommand = 0;
    String[] history = new String[count];

    /**
     * Изменяет массив из строк, введенных команд
     * @param history
     */

    public void setHistory(String[] history) {
        this.history = history;
    }

    /**
     * Изменяет количество введеных команд
     * @param numberCommand
     */

    public void setNumberCommand(int numberCommand) {
        this.numberCommand = numberCommand;
    }

    /**
     * запоминает выполненные команды
     * @param command
     */

    public void historyRemember(String command) {
        if (numberCommand == 0) {
            for (int i = 0; i < count; i++) {
                history[i] = " ";
            }
        }
        if (numberCommand < count) {
            history[numberCommand] = command;
            setNumberCommand(++numberCommand);
        } else {
            for (int i = 0; i < count - 1; i++) {
                history[i] = history[i + 1];
            }
            history[count-1] = command;
        }
        setHistory(history);

    }

    /**
     * выводит список выполненных команд (не более 12 команд)
     * @param args
     * @param priorityQueue
     * @param commandsManager
     * @param history
     */

    @Override
    public void realize(String[] args, PriorityQueue<StudyGroup> priorityQueue, CommandsManager commandsManager, History history) {
        if (args.length > 0) System.out.println("Команда не принимает аргументы");
        else {
            if (history.getHistory()[0] == null) {
                System.out.println("История пуста, не было исполнено ни одной команды");
            } else {
                System.out.println("История команд:");
                
                history.OutHistory();
            }
        }
    }

    /**
     * возвращает history
     * @return
     */

    public String[] getHistory() {
        return history;
    }

    /**
     * достает выполненные команды из history и выводит их
     */
    public void OutHistory() {
        for (int i=0;i< history.length;i++){
            if (history[i]!=" "){
                if (i!=history.length-1){
            System.out.print(history[i]+", ");}
                else{
                    System.out.print(history[i]+".");
                    System.out.println();
                }
            }
        }
    }

}