package com.deependra.Askcart.controller;

import com.deependra.Askcart.model.cart;
import com.deependra.Askcart.model.cartitem;
import com.deependra.Askcart.model.product;
import com.deependra.Askcart.service.cartservice;
import org.apache.logging.log4j.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/cart")
public class cartcontroller {
    @Autowired
    private cartservice cartservice;


    @GetMapping("")
    public ResponseEntity<List<cartitem>> getcartitems(){
      List<cartitem> items   = cartservice.getallitems();
        return new ResponseEntity<>(items,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getcartitems(@PathVariable int id){
        cartitem items   = cartservice.getitembyid(id);
        if(items!=null)
        return new ResponseEntity<>(items,HttpStatus.OK);
        else
            return new ResponseEntity<>("product not found",HttpStatus.NOT_FOUND);
    }



    @PostMapping("")
    public ResponseEntity<cart> addtocart(@RequestBody cartitem item) {

        cart cart= cartservice.addproductstocart(item);
        if(cart != null){
            return new ResponseEntity<>(cart,HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteitemfromcart(@PathVariable int id){
        cartitem cartitem= cartservice.getitembyid(id);

        if(cartitem!=null) {
            cartservice.deletefromcart(id);
            return new ResponseEntity<>("Product deleted successfully", HttpStatus.OK);
        }
        else
            return new ResponseEntity<>("product not found",HttpStatus.NOT_FOUND);

            }

}
