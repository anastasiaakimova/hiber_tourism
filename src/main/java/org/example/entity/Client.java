package org.example.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "name", nullable = true, length = 45)
    private String name;
    @Column(name = "adress", nullable = true, length = 100)
    private String adress;
    @Column(name = "tel", nullable = true, length = 45)
    private String tel;

    @OneToMany( mappedBy = "client", cascade = {CascadeType.ALL})
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

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Collection<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(Collection<Ticket> tickets) {
        this.tickets = tickets;
    }

    @Override
    public String toString() {
        return "Клиент: " +
                "id: " + id +
                ", имя: " + name +
                ", адрес: " + adress +
                ", телефон: " + tel;
    }
}
