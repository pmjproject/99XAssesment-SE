package com.x.priceEngine.Controllers;

import com.x.priceEngine.Models.Products;
import com.x.priceEngine.Services.PriceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/priceEngine")
public class Price<PriceCalculationResponseDTO> {

    @Autowired
    private PriceService priceService;

    @GetMapping("/getPriceTable")
    public List<Products> getPriceTable() {
        List<Products> productsList = priceService.findAll();
        return productsList;
    }

    @GetMapping("/calculatePrice/{productId}/{carton}/{sUnits}")
    public Double calculateSingleItemPrice(@PathVariable("productId") Integer productId,
                                           @PathVariable("carton") Integer carton,
                                           @PathVariable("sUnits") Integer sUnits) {
        Double price = (Double) priceService.calculateTotalPrice(productId, carton, sUnits);
        return price;
    }
}
