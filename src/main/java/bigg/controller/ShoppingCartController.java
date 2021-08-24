package bigg.controller;

import bigg.model.Cart;
import bigg.model.Product;
import bigg.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@SessionAttributes("cart")
public class ShoppingCartController {

    @Autowired
    private IProductService service;

    @ModelAttribute("cart")
    public Cart setCart() {
        return new Cart();
    }

    @GetMapping("/shopping-cart")
    public ModelAndView showCart(@SessionAttribute("cart") Cart cart) {
        ModelAndView modelAndView = new ModelAndView("/cart");
        modelAndView.addObject("cart", cart);
        return modelAndView;
    }

    @GetMapping("/decrease/{id}")
    public ModelAndView addCart(@PathVariable Long id, @ModelAttribute Cart cart) {
        Optional<Product> productOptional = service.findById(id);
        cart.decreaseProduct(productOptional.get());
        return new ModelAndView("redirect:/shopping-cart");
    }

    @GetMapping("/payment")
    public ModelAndView pay(@ModelAttribute Cart cart){
        cart.emptyCart();
        return new ModelAndView("redirect:/shopping-cart");
    }
}
