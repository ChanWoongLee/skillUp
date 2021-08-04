package com.example.prj.order;

public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemPrice);
}
