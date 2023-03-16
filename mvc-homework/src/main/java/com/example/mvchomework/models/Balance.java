package com.example.mvchomework.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "balance")
public class Balance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="value")
    private double amount;
    @OneToMany(mappedBy = "balance",fetch = FetchType.EAGER)
    private List<Operation> operations;

    public Balance() {
    }

    public int getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public List<Operation> getOperations() {
        return operations;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setOperations(List<Operation> operations) {
        this.operations = operations;
    }
}
