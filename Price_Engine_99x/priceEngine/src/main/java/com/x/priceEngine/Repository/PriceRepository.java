package com.x.priceEngine.Repository;

import com.x.priceEngine.Models.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PriceRepository extends JpaRepository<Products,Integer> {
}
