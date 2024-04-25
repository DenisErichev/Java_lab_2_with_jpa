package org.example.performance;

import jakarta.persistence.*;

import java.util.List;
@Entity
@Table(name = "staff")
public class Staff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;
    private String address;
    private String dateOfBirth;
    private String position;
    private List<String> rooms;

    public void setRooms(List<String> rooms) {
        this.rooms = rooms;
    }

    public List<String> getRooms() {
        return rooms;
    }

    public Long getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getAddress() {
        return address;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getPosition() {
        return position;
    }



    public void setId(Long id) {
        this.id = id;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setPosition(String position) {
        this.position = position;
    }

}
