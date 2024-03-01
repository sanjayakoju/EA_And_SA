package model;

import jakarta.persistence.*;

@Entity
public class House {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double cost;

    @OneToOne(cascade = CascadeType.PERSIST)
    private Address address;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Realtor realtor;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public House() {
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Realtor getRealtor() {
        return realtor;
    }

    public void setRealtor(Realtor realtor) {
        this.realtor = realtor;
    }

    @Override
    public String toString() {
        return "House{" +
                "name='" + name + '\'' +
                ", cost=" + cost +
                '}';
    }
}
