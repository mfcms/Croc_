package karma.lab4.task7;

import java.time.LocalDateTime;

public interface WorkPanel {
    void toCollect(OrderStatus status);
    void toGive(OrderStatus status, LocalDateTime assembledAt);
    void toExpire(OrderStatus status, LocalDateTime assembledAt);
}
