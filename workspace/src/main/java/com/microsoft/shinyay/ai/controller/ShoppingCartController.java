package com.microsoft.shinyay.ai.controller;

import com.microsoft.shinyay.ai.model.CartItem;
import com.microsoft.shinyay.ai.model.Product;
import com.microsoft.shinyay.ai.service.ShoppingCartService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class ShoppingCartController {

    private final ShoppingCartService shoppingCartService;

    public ShoppingCartController(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    @PostMapping("/add")
    public ResponseEntity<Void> addItemToCart(@RequestBody Product product, @RequestParam int quantity) {
        shoppingCartService.addItemToCart(product, quantity);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/items")
    public ResponseEntity<List<CartItem>> viewCartItems() {
        return ResponseEntity.ok(shoppingCartService.getCartItems());
    }

    @DeleteMapping("/clear")
    public ResponseEntity<Void> clearCart() {
        shoppingCartService.clearCart();
        return ResponseEntity.ok().build();
    }
}
