package com.x.priceEngine.Services;

import com.x.priceEngine.Models.Products;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface PriceService {

    Double calculateTotalPrice(Integer productId, Integer carton, Integer sUnits);

    List<Products> findAll();
}
