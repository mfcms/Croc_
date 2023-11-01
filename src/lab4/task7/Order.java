package src.lab4.task7;

import java.time.LocalDateTime;

import src.lab3.task5.Product;

import java.math.BigDecimal;

public class Order implements Checkable, Notification, WorkPanel {
    private String clientPhone;// номер телефона заказчика
    private String clientName;// имя заказчика
    private Product[] products;// массив товаров в корзине

    public LocalDateTime createdAt; // дата создания заказа
    private LocalDateTime collectedAt; // дата поступления
    private LocalDateTime assembledAt; // дата сборки
    private LocalDateTime receivedAt; // дата получения

    private OrderStatus status;// статус заказа

    public Order(String clientName, String clientPhone, LocalDateTime collectedAt, LocalDateTime assembledAt, LocalDateTime receivedAt,
            Product[] products) {
        this.clientPhone = clientPhone;
        this.collectedAt = collectedAt;
        this.assembledAt = assembledAt;
        this.receivedAt = receivedAt;
        this.products = products;
    }

    public String getClientName() {
        return clientName;
    }

    public Product[] getProducts() {
        return products;
    }

    public void setProducts(Product[] product) {
        this.products = product;
    }

    public void setClientPhone(String number) {
        this.clientPhone = number;
    }

    public String getClientPhone() {
        return clientPhone;
    }

    public void setReceivedAt(LocalDateTime receiv) {
        this.receivedAt = receiv;
    }

    public LocalDateTime getReceivedAt() {
        return receivedAt;
    }

    public void setAssembledAt(LocalDateTime assemb) {
        this.assembledAt = assemb;
    }

    public LocalDateTime getAssembledAt() {
        return assembledAt;
    }

    public void setCollectedAt(LocalDateTime admiss) {
        this.collectedAt = admiss;
    }

    public LocalDateTime getCollectedAt() {
        return collectedAt;
    }

    public String getOrderNumber() {
        return Integer.toString(createdAt.getYear()).substring(2)
                + Integer.toString(createdAt.getMonthValue())
                + Integer.toString(createdAt.getDayOfMonth())
                + Integer.toString(createdAt.getHour())
                + Integer.toString(createdAt.getMinute())
                + Integer.toString(createdAt.getSecond())
                + clientPhone.substring(5);
    }

    @Override
    public boolean checkOrder(LocalDateTime assemb) throws Exception {
        if (LocalDateTime.now().isBefore(assemb)) {
            return false;
        } else if (LocalDateTime.now().isAfter(assemb) && LocalDateTime.now().isBefore(assemb.plusWeeks(2))) {
            return true;
        } else {
            throw new Exception();
        }
    }

    public BigDecimal summOfOrder(Product[] product) {
        BigDecimal summ = new BigDecimal(0);
        for (Product product2 : product) {
            summ.add(product2.getPrice());
        }
        return summ;
    }

    @Override
    public String sensNotification(String name, Product[] product, LocalDateTime assemb) {
        String list = product.toString();
        String date = assemb.plusWeeks(2).toString();
        String price = summOfOrder(product).toString();
        return String.format(
                "Уважаемый %s !\n Рады сообщить, что ваш заказ %s готов к выдаче /n Сумма к оплате: %s /n срок хранения заказа %s /n С наилучшими пожеланиями, магазин Кошки и картошки",
                name, this.getOrderNumber(), list, price, date);
    }

    @Override
    public void toCollect(OrderStatus status) {
        if (this.status == OrderStatus.CREATED) {
            status = OrderStatus.COLLECTED;
        }
    }

    @Override
    public void toGive(OrderStatus status, LocalDateTime assemb) {
        if ((this.status == OrderStatus.COLLECTED) && (LocalDateTime.now().isBefore(assemb.plusWeeks(2)))) {
            status = OrderStatus.CLOSED;
        }
    }

    @Override
    public void toExpire(OrderStatus status, LocalDateTime assemb) {
        if ((this.status == OrderStatus.COLLECTED) && (LocalDateTime.now().isAfter(assemb.plusWeeks(2)))) {
            status = OrderStatus.EXPIRED;
        }
    }
}
