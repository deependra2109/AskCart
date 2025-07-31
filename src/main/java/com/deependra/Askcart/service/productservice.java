package com.deependra.Askcart.service;

import com.deependra.Askcart.model.product;
import com.deependra.Askcart.repository.productrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class productservice {
    @Autowired
    private productrepo rep;

    public List<product> getallproducts(){
        return rep.findAll();
    }

    public product getproductbyid(int id) {

        return rep.findById(id).orElse(null);
    }


    public product addproduct(product p, MultipartFile img) throws IOException {
        p.setImgName(img.getOriginalFilename());
        p.setImgType(img.getContentType());
        p.setImgData(img.getBytes());
               return rep.save(p);
    }

    public product updateproduct(int id, product p, MultipartFile img) throws IOException {
        p.setImgData(img.getBytes());
        p.setImgType(img.getContentType());
        p.setImgName(img.getOriginalFilename());

        return rep.save(p);


    }


    public void deleteproductby(int id) {
        rep.deleteById(id);
    }

    public List<product> searchproduct(String keyword) {
        return rep.search(keyword);
    }
}
