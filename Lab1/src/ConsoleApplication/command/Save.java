//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package ConsoleApplication.command;

import ConsoleApplication.StudyGroup;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.PriorityQueue;

public class Save extends Command {
    static String File = null;
    static File f = null;

    public Save() {
        this.name = "save";
        this.help = "сохраняет коллекцию в файл";
    }

    public void realize(String[] args, PriorityQueue<StudyGroup> priorityQueue, CommandsManager commandsManager, History history) {
        String text = "";
        int i = 0;

        for(Iterator var7 = priorityQueue.iterator(); var7.hasNext(); ++i) {
            StudyGroup studyGroup = (StudyGroup)var7.next();
            String element = studyGroup.getName() + "," + studyGroup.getId() + "," + studyGroup.getCreationDate() + "," + studyGroup.getCoordinates().getX() + "," + studyGroup.getCoordinates().getY() + "," + studyGroup.getStudentsCount() + "," + studyGroup.getFormOfEducation() + "," + studyGroup.getSemesterEnum() + "," + studyGroup.getGroupAdmin().getName() + "," + studyGroup.getGroupAdmin().getBirthday() + "," + studyGroup.getGroupAdmin().getHeight() + "," + studyGroup.getGroupAdmin().getWeight() + "," + studyGroup.getGroupAdmin().getPassportID();
            if (i == 0) {
                text = element;
            } else {
                text = text + "\n" + element;
            }
        }

        if (f.canWrite()) {
            try {
                FileOutputStream out = new FileOutputStream(File);
                Throwable var44 = null;

                try {
                    BufferedOutputStream outputStream = new BufferedOutputStream(out);
                    Throwable var10 = null;

                    try {
                        byte[] buffer = text.getBytes();
                        outputStream.write(buffer, 0, buffer.length);
                    } catch (Throwable var37) {
                        var10 = var37;
                        throw var37;
                    } finally {
                        if (outputStream != null) {
                            if (var10 != null) {
                                try {
                                    outputStream.close();
                                } catch (Throwable var36) {
                                    var10.addSuppressed(var36);
                                }
                            } else {
                                outputStream.close();
                            }
                        }

                    }
                } catch (Throwable var39) {
                    var44 = var39;
                    throw var39;
                } finally {
                    if (out != null) {
                        if (var44 != null) {
                            try {
                                out.close();
                            } catch (Throwable var35) {
                                var44.addSuppressed(var35);
                            }
                        } else {
                            out.close();
                        }
                    }

                }
            } catch (FileNotFoundException var41) {
                System.out.println("Невозможно найти файл для сохрания");
            } catch (IOException var42) {
                var42.printStackTrace();
            }

            System.out.println("Коллекция сохранена!");
        } else {
            System.out.println("Нет прав для сохранения файла");
        }

    }

    public static void setFile(String file) {
        File = file;
        f = new File(file);
    }
}
