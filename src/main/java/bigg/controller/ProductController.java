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
public class ProductController {
    @Autowired
    private IProductService productService;

    @ModelAttribute("cart")
    public Cart setCart(){
        return new Cart();
    }

    @GetMapping("shop")
    public ModelAndView shop(){
        ModelAndView modelAndView = new ModelAndView("/shop");
        modelAndView.addObject("products", productService.findAll());
        return modelAndView;
    }

    @GetMapping("/add/{id}")
    public ModelAndView addCart(@PathVariable Long id, @ModelAttribute Cart cart, @RequestParam("action") String action) {
        Optional<Product> productOptional = productService.findById(id);
        if(!productOptional.isPresent()){
            return new ModelAndView("/404");
        }
        if(action.equals("show")){
            cart.addProduct(productOptional.get());
            return new ModelAndView("redirect:/shopping-cart");
        }
        cart.addProduct(productOptional.get());
        return new ModelAndView("redirect:/shop");
    }

}
