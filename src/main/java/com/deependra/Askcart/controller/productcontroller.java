package com.deependra.Askcart.controller;

import com.deependra.Askcart.model.product;
import com.deependra.Askcart.service.productservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
@RestController
@CrossOrigin
@RequestMapping("/api")
public class productcontroller {

    @Autowired
    private productservice service;
    @RequestMapping("/")
    public String greet(){
        return "Welcome to Askcart";
    }
    @GetMapping("/products")
    public ResponseEntity< List<product>> getallproduct(){
        return new ResponseEntity<>(service.getallproducts(),HttpStatus.OK) ;
    }
    @GetMapping("/products/{id}")
    public ResponseEntity< product> getproductbyid(@PathVariable int id){
               product p=service.getproductbyid(id);
               if(p!=null)

        return new ResponseEntity<>(p, HttpStatus.OK);
               else
                   return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PostMapping("/products")
    public ResponseEntity<?> addproduct(@RequestPart("p")product p,
                                        @RequestPart("img") MultipartFile img){

        try {
            product p1 =service.addproduct(p,img);
            return new ResponseEntity<>(p1,HttpStatus.CREATED);

        } catch (Exception e) {
           return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }
    @GetMapping("/products/{id}/image")
    public ResponseEntity<byte[]> getproductimg(@PathVariable int id)
    {
        product p=service.getproductbyid(id);
        byte imgf[]=p.getImgData();
                return  ResponseEntity.ok().contentType(MediaType.valueOf(p.getImgType())).body(imgf);
    }
       @PutMapping("/products/{id}")
        public ResponseEntity<String> updateproduct(@PathVariable int id,@RequestPart product p,
        @RequestPart MultipartFile img) throws IOException {
            product p1=service.updateproduct(id,p,img);
            if(p1!= null)
            return new ResponseEntity<>("product updated successfully",HttpStatus.OK);
            else
                return new ResponseEntity<>("failed to update",HttpStatus.BAD_REQUEST);
        }

        @DeleteMapping("/products/{id}")
    public ResponseEntity<String> deleteproduct(@PathVariable int id){

        product p1=service.getproductbyid(id);
        if(p1!=null){
            service.deleteproductby(id);

            return new ResponseEntity<>(" Product Deleted Successfully",HttpStatus.OK);}
        else
            return new ResponseEntity<>("Failed to Delete....Try Again",HttpStatus.NOT_FOUND);
    }
@GetMapping("/products/search")
    public ResponseEntity<List<product>> searchproduct(@RequestParam String keyword){
    System.out.println("Searching with :"+keyword);

        List<product> listofproduct=service.searchproduct(keyword);

        if(listofproduct!=null)
            return new ResponseEntity<>(listofproduct,HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
}


}
