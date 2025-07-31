package com.deependra.Askcart.service;

import com.deependra.Askcart.model.cart;
import com.deependra.Askcart.model.cartitem;
import com.deependra.Askcart.model.product;
import com.deependra.Askcart.repository.cartitemrepo;
import com.deependra.Askcart.repository.cartrepo;
import com.deependra.Askcart.repository.productrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class cartservice {

    @Autowired
    private cartitemrepo cartitemrepo;
    @Autowired
    private productrepo productrepo;

    @Autowired
    private cartrepo cartrepo;


    public cart addproductstocart(cartitem item) {

        product p=productrepo.findById(item.getProduct().getId()).orElse(null);

        cartitem items=new cartitem();
        items.setProduct(p);
        items.setQuantity(item.getQuantity());
        items.setName(p.getName());
        items.setPrice(p.getPrice());
        items.caltotals();

        cart cart=null;
       List<cart> carts= cartrepo.findAll();

        if(carts.isEmpty()){
            cart=new cart();
            cart=cartrepo.save(cart);
        }
        else
            cart=carts.get(0);

          items.setCart(cart);
          cart.getItems().add(items);

          cart.total();
        //  cartitemrepo.save(items);

          return cartrepo.save(cart);


    }

    public List<cartitem> getallitems() {
        return cartitemrepo.findAll();
    }

    public cartitem getitembyid(int id) {
        return cartitemrepo.findById(id).orElse(null);
    }
    @Transactional
    public void deletefromcart(int cartitemid) {

        cartitem item = cartitemrepo.findById(cartitemid).orElse(null);
        if (item != null) {
            cart cart = item.getCart();
            if (cart != null) {
                cart.getItems().remove(item);
                item.setCart(null);
                cart.total();
                cartrepo.save(cart);
            }
            cartitemrepo.delete(item);
        }
    }
}
