package src.lab4.task7;

import java.time.LocalDateTime;

public interface Checkable {
    boolean checkOrder(LocalDateTime assemb) throws Exception;
}
