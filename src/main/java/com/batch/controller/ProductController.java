package com.batch.controller;

import com.batch.service.ProductService;
import com.batch.service.ProductServiceV2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    private final ProductServiceV2 productServiceV2;


    public ProductController(ProductService productService,ProductServiceV2 productServiceV2) {
        this.productService = productService;
        this.productServiceV2 =productServiceV2;
    }

    //this endpoint for testing
    @GetMapping("/ids")
    public ResponseEntity<List<Long>> getIds() {
        return ResponseEntity.ok(productService.getProductIds());
    }

    //this endpoint for data reset
    @PostMapping("/reset")
    public ResponseEntity<String> resetProductRecords() {
        String response = productService.resetRecords();
        return ResponseEntity.ok(response);
    }

    @PostMapping("/process")
    public ResponseEntity<String> processProductIds(@RequestBody ProductRequest productRequest) {
        productService.processProductIds(productRequest.getId());
        return ResponseEntity.ok("Products processed and events published.");
    }

    @PostMapping("/process/v2")
    public ResponseEntity<String> processProductIdsV2(@RequestBody ProductRequest productRequest) {
        productServiceV2.executeProductIds(productRequest.getId());
        return ResponseEntity.ok("Products processed and events published.");
    }



}
