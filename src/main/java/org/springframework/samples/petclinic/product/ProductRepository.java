package org.springframework.samples.petclinic.product;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;



public interface ProductRepository extends CrudRepository<Product,Integer>{
    List<Product> findAll();
    
    @Query("SELECT p FROM ProductType p")
    List<ProductType> findAllProductTypes();
    
    
    Optional<Product> findById(int id);
    

    Product findByName(String name);
    
    @Query("Select p From ProductType p WHERE p.name=?1")
    ProductType getProductType(String name);
    
    @Query("Select p From Product p WHERE p.price<=?1")
    List<Product> findByPriceLessThan(Double price);
    
    
    Product save(Product p);
}
