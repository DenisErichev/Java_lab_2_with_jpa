package org.example.performance;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "departments")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "head_id")
    private Staff head;
    private List<String> rooms;
    private int countStaff;

    public void setCountStaff(int countStaff) {
        this.countStaff = countStaff;
    }

    public void setHead(Staff head) {
        this.head = head;
    }

    public Staff getHead() {
        return head;
    }

    public int getCountStaff() {
        return countStaff;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void setRooms(List<String> rooms) {
        this.rooms = rooms;
    }

    public List<String> getRooms() {
        return rooms;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}