package com.example.shopforeveryone;

import java.util.ArrayList;
import java.util.List;

public class OrderList {
    static List<ItemData> list = new ArrayList<>();
    static String state="hold";
    static int totalPrice=0;

    public static int getTotalPrice() {
        return totalPrice;
    }

    public static void setTotalPrice(int totalPrice) {
        OrderList.totalPrice = totalPrice;
    }

    public static String getState() {
        return state;
    }

    public static void setState(String state) {
        OrderList.state = state;
    }

    public static List<ItemData> getList() {
        return list;
    }

    public static void setList(ItemData list) {
        OrderList.list.add(list);
    }
    public static void setAllList(List<ItemData> list) {
        OrderList.list=list;
    }
}
