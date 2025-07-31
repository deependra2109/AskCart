package com.deependra.Askcart.repository;

import com.deependra.Askcart.model.cart;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface cartrepo extends JpaRepository<cart,Integer> {
}
