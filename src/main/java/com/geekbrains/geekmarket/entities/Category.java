package com.geekbrains.geekmarket.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "categories")
public class Category {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @NotNull
    @Column(name = "title")
    private String title;

    @ManyToOne
    @JoinColumn(name="parent")
    private Category parent;

    public Category() {
    }

    public Category(@NotNull String title) {
        this.title = title;
    }

    public Category(@NotNull long id,@NotNull String title) {
        this.id = id;
        this.title = title;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Category getParent() {
        return parent;
    }

    public void setParent(Category parent) {
        this.parent = parent;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", parent=" + parent +
                '}';
    }
}
