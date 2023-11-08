package karma.lab4.task7;

import java.time.LocalDateTime;

import karma.lab3.task5.Product;

import java.math.BigDecimal;

public class Order implements Checkable, Notification, WorkPanel {
    private String clientPhone;// номер телефона заказчика
    private String clientName;// имя заказчика
    private Product[] products;// массив товаров в корзине

    public LocalDateTime createdAt; // дата поступления заказа
    private LocalDateTime collectedAt; // дата сборки заказа
    private LocalDateTime receivedAt; // дата получения

    private OrderStatus status;// статус заказа

    public Order(String clientName, String clientPhone, Product[] products) {
        this.clientName = clientName;
        this.clientPhone = clientPhone;
        this.createdAt = LocalDateTime.now();
        this.products = products;
        this.status = OrderStatus.CREATED;
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setReceivedAt(LocalDateTime receivedAt) {
        this.receivedAt = receivedAt;
    }

    public LocalDateTime getReceivedAt() {
        return receivedAt;
    }

    public void setCollectedAt(LocalDateTime collectedAt) {
        this.collectedAt = collectedAt;
    }

    public LocalDateTime getCollectedAt() {
        return collectedAt;
    }

    public OrderStatus getStatus() {
        return status;
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
    public boolean checkOrder() throws Exception {
        switch (status) {
            case CREATED:
                return false;

        
            default:
                break;
        }
        if (LocalDateTime.now().isBefore(collectedAt)) {
            return false;
        } else if (LocalDateTime.now().isAfter(collectedAt) && LocalDateTime.now().isBefore(collectedAt.plusWeeks(2))) {
            return true;
        } else {
            throw new Exception();
        }
    }

    public BigDecimal getTotalCost() {
        BigDecimal summ = new BigDecimal("0");//сумма выходит 0, пока не понимаю почему
        for (Product product2 : products) {
            summ.add(product2.getPrice());
        }
        return summ;
    }

    public String createList(){
        String list = "";
        for (Product product : products) {
        list+=product.getName()+", ";
        }
        return list;
    }

    @Override
    public String createNotification() {
        final String notificationFormat = "Уважаемый %s!" +
                "\n\nРады сообщить, что ваш заказ %s готов к выдаче." +
                "\n\nСостав заказа:\n%s" +
                "\n\n\nСумма к оплате: %s" +
                "\n\nСрок хранения заказа %s." +
                "\n\n\nС наилучшими пожеланиями, магазин Кошки и картошки\"";

        String list = createList();
        String price = getTotalCost().toString();
        String date = collectedAt.plusWeeks(2).toString();
        return String.format(notificationFormat,
                clientName, getOrderNumber(), list, price, date);
    }

    @Override
    public void toCollect() {
        if (this.status == OrderStatus.CREATED) {
            status = OrderStatus.COLLECTED;
            collectedAt = LocalDateTime.now();
        }
    }

    @Override
    public void toGive() {
        if (this.status == OrderStatus.COLLECTED && !hasExpired()) {
            status = OrderStatus.CLOSED;

        }
    }

    @Override
    public boolean hasExpired() {
        if (this.status == OrderStatus.COLLECTED
            && LocalDateTime.now().isAfter(collectedAt.plusWeeks(2))) {
            status = OrderStatus.EXPIRED;
        }
        return this.status == OrderStatus.EXPIRED;
    }
}
