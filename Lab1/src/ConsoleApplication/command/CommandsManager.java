package ConsoleApplication.command;
import ConsoleApplication.Parcer;
import ConsoleApplication.StudyGroup;

import java.io.BufferedReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * Класс для работы с командами
 */
public class CommandsManager {
    private static HashSet<Command> commands = new HashSet<>();
    private static CommandsManager commandsManager = new CommandsManager();
    private boolean exist = false;
    private boolean notPrintAdd = false;
    private String scriptFileName;
    private boolean isScript = false;
    private BufferedReader scriptBufferedReader;
    private CommandsManager() {
        commands.add(new Help());
        commands.add(new Info());
        commands.add(new Show());
        commands.add(new Add());
        commands.add(new UpdateId());
        commands.add(new RemoveById());
        commands.add(new Clear());
        commands.add(new Save());
        commands.add(new ExecuteScript());
        commands.add(new Exit());
        commands.add(new RemoveFirst());
        commands.add(new RemoveHead());
        commands.add(new History());
        commands.add(new RemoveAll());
        commands.add(new Count());
        commands.add(new Print());

    }

    /**
     * запускает команду
     * @param args
     * @param priorityQueue
     * @param history
     * @param parcer
     */
    public static void realizeCommand(String[]args, PriorityQueue <StudyGroup> priorityQueue, History history, Parcer parcer){
        int start=0;
        for (int i=0; i< args.length; i++){
            if (args[i].equals(" ") || args[i].equals("")){
                start++;
            }
        }
        args = Arrays.copyOfRange(args, start, args.length);
        String cmd=args[0].trim();
        args = Arrays.copyOfRange(args, 1, args.length);
        boolean exist = false;
        for (Command command : commands)
            if (command.getName().equals(cmd)) {
                command.realize(args, priorityQueue, commandsManager, history);
                exist = true;
                history.historyRemember(cmd);
            }
        if (!exist) System.out.println("Команда не найдена. Для просмотра доступных команд введите help");
    }

    /**
     * реализует команду
     * @param args
     * @param priorityQueue
     * @param history
     */
    public static void realizeCommand(String[]args, PriorityQueue <StudyGroup> priorityQueue, History history){
        int start=0;
        for (int i=0; i< args.length; i++){
            if (args[i].equals(" ") || args[i].equals("")){
                start++;
            }
        }
        args = Arrays.copyOfRange(args, start, args.length);
        String cmd=args[0].trim();
        args = Arrays.copyOfRange(args, 1, args.length);
        boolean exist = false;
        for (Command command : commands)
            if (command.getName().equals(cmd)) {
                command.realize(args, priorityQueue, commandsManager, history);
                exist = true;
                history.historyRemember(cmd);
            }
        if (!exist) System.out.println("Команда не найдена. Для просмотра доступных команд введите help");
    }
    /**
     * @return HashSet с командами
     */
    public static HashSet<Command> getCommands() {
        return commands;
    }

    /**
     * @param script работает в данный момент пользователь со скриптом или нет
     */
    public void setScript(boolean script) {
        isScript = script;
    }

    /**
     * @return работает в данный момент пользователь со скриптом или нет
     */
    public boolean isScript() {
        return isScript;
    }

    /**
     * @return стоит ли оповещать пользователя о добавлении объекта
     */
    public boolean isNotPrintAdd() {
        return notPrintAdd;
    }

    /**
     * @param notPrintAdd стоит ли оповещать пользователя о добавлении объекта
     */
    public void setNotPrintAdd(boolean notPrintAdd) {
        this.notPrintAdd = notPrintAdd;
    }

    /**
     * @return существование элемента коллекции
     */
    public boolean isExist() {
        return exist;
    }

    /**
     * @param exist существование элемента коллекции
     */
    public void setExist(boolean exist) {
        this.exist = exist;
    }

    /**
     * @return имя скрипта
     */
    public String getScriptFileName() {
        return scriptFileName;
    }

    /**
     * @param scriptFileName имя скрипта
     */
    public void setScriptFileName(String scriptFileName) {
        this.scriptFileName = scriptFileName;
    }

    /**
     * @return считыватель скрипта
     */
    public BufferedReader getScriptBufferedReader() {
        return scriptBufferedReader;
    }

    /**
     * @param scriptBufferedReader считыватель скрипта
     */
    public void setScriptBufferedReader(BufferedReader scriptBufferedReader) {
        this.scriptBufferedReader = scriptBufferedReader;
    }

    /**
     *Прочитывает строки, в случае ошибки при считывание из скрипта
     */

    public void commandRewider() {
        try {
            for (int i = 1; i < 10; i++) scriptBufferedReader.readLine();
        } catch (Exception ignored) {
        }
    }

}
