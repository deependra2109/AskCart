package com.deependra.Askcart.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
   private int cartid;
    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true)

    private List<cartitem> items = new ArrayList<>();
    private int totalitems;
    private double totalprice;

    public void total(){
        this.totalitems=items.size();
        this.totalprice = items.stream().mapToDouble(cartitem::getTotalprice).sum();
    }





}
