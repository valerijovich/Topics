package com.example.topics.model;

import javax.persistence.*;

@Entity
@Table(name = "topics")
public class Topic {

    private long id;
    private String name;
    private String description;
    private long topicItemId;

    public Topic() {}

    public Topic(long id, String name, String description, long topicItemId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.topicItemId = topicItemId;
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

    @Column(name = "description", nullable = false)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "topicItemId", nullable = false)
    public long getTopicItemId() {
        return topicItemId;
    }

    public void setTopicItemId(long topicItemId) {
        this.topicItemId = topicItemId;
    }

    @Override
    public String toString() {
        return "Topics{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", topicItemId=" + topicItemId +
                '}';
    }
}
