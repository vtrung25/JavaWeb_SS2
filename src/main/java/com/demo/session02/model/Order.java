package com.demo.session02.model;

import java.util.Date;

public class Order {
    private final String orderCode;
    private final String productName;
    private final double totalAmount;
    private final Date orderDate;

    public Order(String orderCode, String productName, double totalAmount, Date orderDate) {
        this.orderCode = orderCode;
        this.productName = productName;
        this.totalAmount = totalAmount;
        this.orderDate = orderDate;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public String getProductName() {
        return productName;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public Date getOrderDate() {
        return orderDate;
    }
}

