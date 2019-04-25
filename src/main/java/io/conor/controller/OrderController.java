//package io.conor.controller;
//
//import java.util.HashSet;
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import io.conor.model.UserOrder;
//import io.conor.service.ProductService;
//import io.conor.service.UserService;
//
//@Controller
//public class OrderController {
//
//
//
// 
//
//    @Autowired
//    private UserService userService;
//
//    @Autowired
//    private ProductService productService;
//
//    @Autowired
//    private CartItemsService cartItemsService;
//
//    PurchaseServiceFacadeImpl purchaseServiceFacade;
//
//  
//
//    @PostMapping("order")
//    public String order( @ModelAttribute("userOrder") UserOrder userOrder, @RequestParam("total") int totalPrice, HttpServletRequest request) {
//        
//        
//        Set<Product> shoppingCart = new HashSet<>();
//
//        ArrayList<CartItems> cart_items = new ArrayList<CartItems>();
//        cart_items.addAll(cart.getCartItems());
//
//        purchaseServiceFacade = new PurchaseServiceFacadeImpl();
//
//        if (purchaseServiceFacade.placeOrder(cart_items)) {
//
//            items.addAll(items);
//
//            UserOrder order = new UserOrder(total, user, items);
//
//            if (request.getParameter("payment_method").equals("Visa")) {
//                Visa visa = new Visa(request.getParameter("name"), request.getParameter("cardNumber"), request.getParameter("expires"));
//
//                if (order.pay(visa, cart)){
//                    orderService.saveOrder(order);
//                    cartItemsService.emptyCart(cartItemsService.findByCartId(cart.getId()));
//
//                    String visaSuccess = "";
//                    model.addObject("visaSuccess", visaSuccess);
//                    model.setViewName("homepage");
//                }
//                else {
//                    String visaError = "";
//                    model.addObject("total", total);
//                    model.addObject("visaError", visaError);
//                    model.setViewName("order");
//                }
//            } else if (request.getParameter("payment_method").equals("Mastercard")) {
//                MasterCard mastercard = new MasterCard(request.getParameter("name"), request.getParameter("cardNumber"), request.getParameter("expires"));
//
//                if (order.pay(mastercard, cart)) {
//                    orderService.saveOrder(order);
//                    cartItemsService.emptyCart(cartItemsService.findByCartId(cart.getId()));
//
//                    String mastercardSuccess = "";
//                    model.addObject("mastercardSuccess", mastercardSuccess);
//                    model.setViewName("homepage");
//                }
//                else {
//                    String mastercardError = "";
//                    model.addObject("total", total);
//                    model.addObject("mastercardError", mastercardError);
//                    model.setViewName("order");
//                }
//            }
//        }
//        else {
//            String errorMessage = "";
//            model.addObject("errorMessage", errorMessage);
//            model.setViewName("order");
//            model.addObject("total", total);
//        }
//
//        return model;
//    }
//}
