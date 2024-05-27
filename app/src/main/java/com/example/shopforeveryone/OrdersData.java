package com.example.shopforeveryone;

import java.util.ArrayList;
import java.util.List;

public class OrdersData {
    static List<List<ItemData>> orderLists=new ArrayList<>();
    static List<String> states=new ArrayList<>();
    static List<Integer> totals=new ArrayList<>();

    public static List<List<ItemData>> getOrderLists() {
        return orderLists;
    }

    public static void setOrderLists(List<ItemData> orderList) {
        OrdersData.orderLists.add(orderList);
    }

    public static void setAllOrderLists(List<List<ItemData>> orderLists) {
        OrdersData.orderLists=orderLists;
    }

    public static List<String> getStates() {
        return states;
    }

    public static void setStates(String state) {
        OrdersData.states.add(state);
    }
    public static void setAllStates(List<String> state) {
        OrdersData.states=state;
    }

    public static List<Integer> getTotals() {
        return totals;
    }

    public static void setTotals(int total) {
        OrdersData.totals.add(total);
    }
    public static void setAllTotals(List<Integer> total) {
        OrdersData.totals=total;
    }
}
