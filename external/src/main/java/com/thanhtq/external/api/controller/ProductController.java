package com.thanhtq.external.api.controller;

import com.thanhtq.core.domain.product.command.IProductCommandHandler;
import com.thanhtq.external.api.command.ProductCreateCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
    private final IProductCommandHandler productCommandHandler;
    
    @PostMapping("/create")
    public String createProduct(@RequestBody ProductCreateCommand productCreateCommand) {
        productCommandHandler.on(productCreateCommand);
        return "Create product success!";
    }
}
