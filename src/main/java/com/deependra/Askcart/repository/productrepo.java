package com.deependra.Askcart.repository;

import com.deependra.Askcart.model.cart;
import com.deependra.Askcart.model.cartitem;
import com.deependra.Askcart.model.product;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface productrepo extends JpaRepository <product,Integer> {
    @Query("select p from product p "+" Where CAST(p.id as string) Like CONCAT('%', :keyword, '%') "+ " OR lower(p.name) like lower(concat( '%' ,:keyword,'%'))"+ " OR lower(p.brand) like lower(concat( '%' ,:keyword,'%'))" +" OR lower(p.category) like lower(concat( '%' ,:keyword,'%')) ")

    List<product> search(String keyword);
}




