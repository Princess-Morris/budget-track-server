package com.princess.purchase;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class CartService {

  @Autowired
  private final CartRepository cartRepository;

  public CartService(CartRepository cartRepository){
    this.cartRepository = cartRepository;
  }

  public List<Cart> getCart(){ 
    return cartRepository.findAll();
  }

  public Cart addCart(Cart cart){
    // Optional<Cart> cartOptional = cartRepository.findCartById(cart.getId());

    // if(cartOptional.isPresent()){
    //   throw new IllegalStateException("This id" + cart.getId() + " already exists");
    // }
    
    return cartRepository.save(cart);
  }

  public void deleteCart(Long cartId){
    boolean idExists = cartRepository.existsById(cartId);
    if(!idExists){
      throw new IllegalStateException("This id: " + cartId + "does not exist");
    }
    cartRepository.deleteById(cartId);;
  }

  @Transactional
  public Cart updateCart(Long cartId, Cart updatedCart){
    updatedCart.setId(cartId);
    return cartRepository.save(updatedCart);
    // Cart cart = cartRepository.findById(cartId)
    // .orElseThrow(() -> new IllegalStateException(
    //   "Cart with the id " + cartId + " does not exist"
    // ));

    // if(updatedCart.getCategory() != null && !updatedCart.getCategory().isBlank() 
    // && !Objects.equals(cart.getCategory(), updatedCart.getCategory()) ){
    //   cart.setCategory(updatedCart.getCategory());
    // }

    // if(updatedCart.getDescription() != null && !updatedCart.getDescription().isBlank()
    // && !Objects.equals(cart.getDescription(), updatedCart.getDescription()) ){
    //   cart.setCategory(updatedCart.getCategory());
    // }

    // if(updatedCart.getAmount() != null 
    //    && !Objects.equals(cart.getAmount(), updatedCart.getAmount()) ){
    //   cart.setAmount(updatedCart.getAmount());
    // }

    // if(updatedCart.getDateTime() != null 
    // && !Objects.equals(cart.getDateTime(), updatedCart.getDateTime()) ){
    //   cart.setDateTime(updatedCart.getDateTime());
    // }

  }

}
