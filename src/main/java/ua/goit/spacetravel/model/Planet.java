package ua.goit.spacetravel.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "planet")
@Getter
@Setter
@AllArgsConstructor
public class Planet {
    @Id
    @Column(length = 3, nullable = false)
    private String id;

    @Column(length = 500, nullable = false)
    private String name;

    public Planet() {
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Planet{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}

