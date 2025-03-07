package com.uptoser.spring.cloud.alibaba.rockermq.producter;

public class Order {

    private String orderId;

    private String address;

    public Order(String orderId, String address) {
        this.orderId = orderId;
        this.address = address;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
