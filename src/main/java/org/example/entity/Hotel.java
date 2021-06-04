package org.example.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "name", nullable = true, length = 45)
    private String name;
    @Column(name = "comfort", nullable = true, length = 45)
    private String comfort;
    @Column(name = "food", nullable = true, length = 45)
    private String food;

    @OneToMany( mappedBy = "hotel", cascade = {CascadeType.ALL})
    private Collection<Staff> staff;

    @OneToMany( mappedBy = "hotel", cascade = {CascadeType.ALL})
    private Collection<Ticket> tickets;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComfort() {
        return comfort;
    }

    public void setComfort(String comfort) {
        this.comfort = comfort;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public Collection<Staff> getStaff() {
        return staff;
    }

    public void setStaff(Collection<Staff> staff) {
        this.staff = staff;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", comfort='" + comfort + '\'' +
                ", food='" + food + '\'' +
                '}';
    }
}
