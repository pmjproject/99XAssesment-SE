package com.x.priceEngine.Services;

import com.x.priceEngine.Models.Products;
import com.x.priceEngine.Repository.PriceRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class PriceServiceImpl implements PriceService {

    @Autowired
    private PriceRepository priceRepository;

    @Override
//    @Cacheable(cacheNames = "product")
    public Double calculateTotalPrice(Integer id, Integer carton, Integer sUnits) {
        log.info("============Log start for price calculation ===========================");
        Optional<Products> productDetails = priceRepository.findById(id);
        Double totalPrice, cartonPrice, singleUnitPrice, discountParentage, totalCartonPrice, totalisingUnitsPrice, discountPrice = null;
        cartonPrice = productDetails.get().getCartonPrice();
        singleUnitPrice = productDetails.get().getUnitPrice();
        discountParentage = productDetails.get().getDiscountPrecentage();
        totalCartonPrice = carton * cartonPrice;
        totalisingUnitsPrice = sUnits * singleUnitPrice;
        discountPrice = carton * cartonPrice * discountParentage;

        if (carton >= 3) {
            totalPrice = totalCartonPrice + totalisingUnitsPrice - discountPrice;
        } else {
            totalPrice = totalCartonPrice + totalisingUnitsPrice;
        }
        log.info("==================Log end for total price calculation=============================");
        return totalPrice;

    }

    @Override
    public List<Products> findAll() {
        log.info("============Log start for Product List ===========================");
        List<Products> productsList = priceRepository.findAll();
        log.info("==================Log end for Product List=============================");
        return productsList;
    }
}
