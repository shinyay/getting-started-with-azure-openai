package com.microsoft.shinyay.ai.service;

import com.microsoft.shinyay.ai.model.CartItem;
import com.microsoft.shinyay.ai.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ShoppingCartService {

    private final List<CartItem> cartItems = new ArrayList<>();

    public void addItemToCart(Product product, int quantity) {
        Optional<CartItem> existingItem = cartItems.stream()
                .filter(item -> item.getProduct().getId().equals(product.getId()))
                .findFirst();

        existingItem.ifPresentOrElse(item -> item.setQuantity(item.getQuantity() + quantity),
                () -> cartItems.add(new CartItem(product, quantity)));
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public double calculateTotalPrice() {
        return cartItems.stream()
                .mapToDouble(item -> item.getProduct().getPrice() * item.getQuantity())
                .sum();
    }

    public void clearCart() {
        cartItems.clear();
    }
}
