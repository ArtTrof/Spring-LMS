package com.example.mvchomework.models;

import javax.persistence.*;
import java.util.Optional;

@Entity
@Table(name="operations")
public class Operation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private  int id;
    @Column(name="amount")
    private double amount;
    @ManyToOne
    @JoinColumn(name="balance_id",referencedColumnName = "id")
    private Balance balance;

    public Operation() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Balance getBalance() {
        return balance;
    }

    public void setBalance(Balance balance) {
        this.balance = balance;
    }
}
