//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package ConsoleApplication.command;

import ConsoleApplication.Parcer;
import ConsoleApplication.StudyGroup;
import java.io.BufferedReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.PriorityQueue;

public class CommandsManager {
    private static HashSet<Command> commands = new HashSet();
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

    public static void realizeCommand(String[] args, PriorityQueue<StudyGroup> priorityQueue, History history, Parcer parcer) {
        try {
            int start = 0;

            for(int i = 0; i < args.length; ++i) {
                if (args[i].equals(" ") || args[i].equals("")) {
                    ++start;
                }
            }

            args = (String[])Arrays.copyOfRange(args, start, args.length);
            String cmd = args[0].trim();
            args = (String[])Arrays.copyOfRange(args, 1, args.length);
            boolean exist = false;
            Iterator var7 = commands.iterator();

            while(var7.hasNext()) {
                Command command = (Command)var7.next();
                if (equalsPart(cmd, command.getName())) {
                    trimString(cmd, command.getName());
                    command.realize(args, priorityQueue, commandsManager, history);
                    exist = true;
                    history.historyRemember(cmd);
                }
            }

            if (!exist) {
                System.out.println("Команда не найдена. Для просмотра доступных команд введите help");
            }
        } catch (ArrayIndexOutOfBoundsException var9) {
            System.out.println("Вы ввели пустую строку");
        }

    }

    public static void realizeCommand(String[] args, PriorityQueue<StudyGroup> priorityQueue, History history) {
        try {
            int start = 0;

            for(int i = 0; i < args.length; ++i) {
                if (args[i].equals(" ") || args[i].equals("")) {
                    ++start;
                }
            }

            args = (String[])Arrays.copyOfRange(args, start, args.length);
            String cmd = args[0].trim();
            args = (String[])Arrays.copyOfRange(args, 1, args.length);
            boolean exist = false;
            Iterator var6 = commands.iterator();

            while(var6.hasNext()) {
                Command command = (Command)var6.next();
                if (equalsPart(cmd, command.getName())) {
                    trimString(cmd, command.getName());
                    command.realize(args, priorityQueue, commandsManager, history);
                    exist = true;
                    history.historyRemember(cmd);
                }
            }

            if (!exist) {
                System.out.println("Команда не найдена. Для просмотра доступных команд введите help");
            }
        } catch (ArrayIndexOutOfBoundsException var8) {
            System.out.println("Вы ввели пустую строку");
        }

    }

    public static HashSet<Command> getCommands() {
        return commands;
    }

    public void setScript(boolean script) {
        this.isScript = script;
    }

    public boolean isScript() {
        return this.isScript;
    }

    public boolean isNotPrintAdd() {
        return this.notPrintAdd;
    }

    public void setNotPrintAdd(boolean notPrintAdd) {
        this.notPrintAdd = notPrintAdd;
    }

    public boolean isExist() {
        return this.exist;
    }

    public void setExist(boolean exist) {
        this.exist = exist;
    }

    public String getScriptFileName() {
        return this.scriptFileName;
    }

    public void setScriptFileName(String scriptFileName) {
        this.scriptFileName = scriptFileName;
    }

    public BufferedReader getScriptBufferedReader() {
        return this.scriptBufferedReader;
    }

    public void setScriptBufferedReader(BufferedReader scriptBufferedReader) {
        this.scriptBufferedReader = scriptBufferedReader;
    }

    public void commandRewider() {
        try {
            for(int i = 1; i < 10; ++i) {
                this.scriptBufferedReader.readLine();
            }
        } catch (Exception var2) {
        }

    }

    public static boolean looseEquals(String str1, String str2) {
        str1 = str1.trim();
        str2 = str2.trim();
        if (str1.equals(str2)) {
            return true;
        } else {
            boolean check = true;
            if (str2 != null && str1 != null) {
                if (str1.length() != str2.length()) {
                    check = false;
                } else if (!str1.regionMatches(true, 0, str2, 0, str2.length())) {
                    check = false;
                }
            } else {
                check = false;
            }

            return check;
        }
    }

    public static boolean equalsPart(String str, String norm) {
        str = str.trim();
        boolean check = true;
        if (str.length() >= norm.length()) {
            for(int i = 0; i <= norm.length() - 1; ++i) {
                if (!looseEquals(str.substring(i, i + 1), norm.substring(i, i + 1))) {
                    check = false;
                    break;
                }
            }
        } else {
            check = false;
        }

        return check;
    }

    public static CommandsManager getCommandsManager() {
        return commandsManager;
    }

    public static String trimString(String trimmed, String norm) {
        int index = -1;
        if (!trimmed.equals("") && trimmed.length() >= norm.length()) {
            for(int i = 0; i < norm.length(); ++i) {
                if (looseEquals(norm.substring(i, i + 1), trimmed.substring(i, i + 1))) {
                    index = i;
                }
            }

            trimmed = trimmed.substring(index + 1);
            trimmed = trimmed.trim();
        }

        return trimmed;
    }
}
