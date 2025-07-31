package com.deependra.Askcart.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class cartitem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cartitemid;
@ManyToOne
@JoinColumn(name = "cartid", insertable = false, updatable = false)

@JsonIgnore
    private cart cart;
    private String name;
    @JoinColumn(name="id",nullable = false)
    @ManyToOne
    private product product;

    private int quantity;
    private double price;
    private double totalprice;

public void caltotals(){
    this.price=product.getPrice();
    this.totalprice=this.price*quantity;
}


}
