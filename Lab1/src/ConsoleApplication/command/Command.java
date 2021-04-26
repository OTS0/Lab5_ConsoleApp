//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package ConsoleApplication.command;

import ConsoleApplication.StudyGroup;
import java.util.PriorityQueue;

public abstract class Command {
    protected String name;
    protected String help;

    public Command() {
    }

    public String getName() {
        return this.name;
    }

    public String getHelp() {
        return this.help;
    }

    public abstract void realize(String[] var1, PriorityQueue<StudyGroup> var2, CommandsManager var3, History var4);
}
