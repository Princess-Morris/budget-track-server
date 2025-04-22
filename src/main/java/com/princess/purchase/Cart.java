package com.princess.purchase;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table
public class Cart {

    @Id
    @SequenceGenerator(
        name= "cart_sequence",
        sequenceName = "cart_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "cart_sequence"
    )
    private Long id;
    private String category;
    private String description;
    private Integer amount;
    private LocalDate dateTime;


    public Cart(){

    }

    public Cart(Long id, String category, String description, Integer amount, LocalDate dateTime){
        this.id = id;
        this.category = category;
        this.description = description;
        this.amount = amount;
        this.dateTime = dateTime;
    }

    public Cart(String category, String description, Integer amount, LocalDate dateTime){
        this.category = category;
        this.description = description;
        this.amount = amount;
        this.dateTime = dateTime;
    }
    
    public Long getId(){
        return id;
    }

    public void setId(Long id){ 
        this.id = id;
    }

    public String getCategory(){
        return category;
    }

    public void setCategory(String category){
        this.category = category;
    }

    public String getDescription(){
        return description;
    }
    

    public void setDescription(String description){
        this.description = description;
    }

    public Integer getAmount(){
        return amount;
    }

    public void setAmount(Integer amount){
        this.amount = amount;
    }

    public LocalDate getDateTime(){
        return dateTime;
    }

    public void setDateTime(LocalDate dateTime){
         this.dateTime = dateTime;
    }

    @Override
    public String toString(){
        return "Cart{" +
        "id=" + id +
        ", name='" + category + '\'' +
        ", email='" + description + '\'' +
        ", dob=" + amount +
        ", age=" + dateTime +
        '}';
    }

}
