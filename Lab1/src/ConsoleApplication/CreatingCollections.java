package ConsoleApplication;
import java.time.LocalDate;

/**
 * Интерфейс для работы парсера
 */

public interface CreatingCollections {
    public static LocalDate[] stringToTime(String arguments) {
        return new LocalDate[0];
    }

    public static StudyGroup rebirthArguments(String[] arguments) throws NotCorrectValueException {
        return null;
    }

}
