package src.lab4.task7;

import java.time.LocalDateTime;

import src.lab3.task5.Product;

public interface Notification {
    String sensNotification(String name, Product[] product, LocalDateTime assemb);
}
