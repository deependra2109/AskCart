package com.deependra.Askcart.repository;

import com.deependra.Askcart.model.cartitem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface cartitemrepo extends  JpaRepository<cartitem,Integer> {
}
