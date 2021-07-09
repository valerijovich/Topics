package com.example.topics.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class TopicItem {

    private long id;
    private String name;
    private long order_item;

    public TopicItem() {
    }

    public TopicItem(long id, String name, long order_item) {
        this.id = id;
        this.name = name;
        this.order_item = order_item;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "order_item", nullable = false)
    public long getOrder_item() {
        return order_item;
    }

    public void setOrder_item(long order_item) {
        this.order_item = order_item;
    }

    @Override
    public String toString() {
        return "TopicsItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", order_item=" + order_item +
                '}';
    }
}
