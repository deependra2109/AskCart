package com.deependra.Askcart.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int price;
    private String name;
    private String description;
    private String brand;
    private String category;
    private boolean isAvailable;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern="dd-MM-yyyy")
    private Date mfg;
    private int quantity;
    private String imgName;
    private String imgType;
    @Lob
    private byte[] imgData;



}
