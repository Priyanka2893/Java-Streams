package com.example.streams.Java8Features.streamsOperation;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Order{
    private String id;
    private List<String> item;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getItem() {
        return item;
    }

    public void setItem(List<String> item) {
        this.item = item;
    }

    public Order(String id, List<String> item) {
        this.id = id;
        this.item = item;
    }
}
public class StreamFlatMapOrderExample {
    public static void main(String[] args) {
        List<Order> orders = Arrays.asList(
                new Order("101", Arrays.asList("Item1", "Item2", "Item3")),
                new Order("102", Arrays.asList("Item4", "Item5", "Item6")),
                new Order("103", Arrays.asList("Item7", "Item8"))
        );

        List<Object> allItems = orders.stream()
                .flatMap(order -> order.getItem().stream())
                .collect(Collectors.toList());

        System.out.println(allItems);
    }
}
