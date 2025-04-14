package com.princess.purchase;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/cart")
public class CartController {

  @Autowired
  private final CartService cartService;

  public CartController(CartService cartService) {
    this.cartService = cartService;
  }

  @GetMapping("/all")
  public List<Cart> getCart() {
    return cartService.getCart();
  }

  @PostMapping("/add")
  public Cart addCart(@RequestBody Cart cart) {
    return cartService.addCart(cart);
  }

  @DeleteMapping(path = "/delete/{cartId}")
  public void deleteCart(@PathVariable("cartId") Long cartId){
    cartService.deleteCart(cartId);
  }
  

  @PutMapping(path = "/update/{cartId}")
  public Cart updateCart(
    @PathVariable("cartId") Long cartId,
    @RequestBody Cart updatedCart
    // @RequestParam(required = false) String category,
  ){
     return cartService.updateCart(cartId, updatedCart);
  }

}
