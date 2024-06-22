package com.pace.demo.model;
import java.time.LocalDateTime;


import javax.persistence.*;
import javax.persistence.Id;
@Entity
public class Transaction {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double amount;
    private String type; // "DEPOSIT" or "WITHDRAW"
    
    @ManyToOne
    private Account account;
    
    private LocalDateTime date;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Double getAmount() { return amount; }
    public void setAmount(Double amount) { this.amount = amount; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public Account getAccount() { return account; }
    public void setAccount(Account account) { this.account = account; }
    public LocalDateTime getDate() { return date; }
    public void setDate(LocalDateTime date) { this.date = date; }

}
