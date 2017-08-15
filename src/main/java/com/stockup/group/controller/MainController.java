package com.stockup.group.controller;

import com.stockup.group.model.Product;
import com.stockup.group.model.Transaction;
import com.stockup.group.repository.ProductRepo;
import com.stockup.group.repository.TransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Date;

@Controller
public class MainController {

    @Autowired
    ProductRepo productRepo;
    @Autowired
    TransactionRepo transactionRepo;

    @GetMapping("/enterproduct")
    public String addproductGet(Model model) {
//        System.out.println("++++++++++++++++++++++++++++++ JUST ENTERED /addproduct GET route ++++++++++++++++++");

        model.addAttribute("newProduct", new Product());

        return "enterproduct";
    }

    @PostMapping("/enterproduct")
    public String addproductPost(@ModelAttribute("newProduct") Product Product ) {
//        System.out.println("++++++++++++++++++++++++++++++ JUST ENTERED /addproduct POST route ++++++++++++++++++");
//
//        if(bindingResult.hasErrors()) {
//            return "addproduct";
//        }


        // Product should have first and last names, and email at this point
        // the collections in Product are null at this point, which shows up as a BLOB in the db!  ...blob is you uncle
        productRepo.save(Product);

        return "/addproductconfirmation";
    }


    @GetMapping("/purchaseproduct")
    public String PurchaseProduct(Model model) {
//        System.out.println("++++++++++++++++++++++++++++++ JUST ENTERED /addproduct GET route ++++++++++++++++++");

        model.addAttribute("newTransaction", new Transaction());

        return "purchaseproduct";
    }

    @PostMapping("/purchaseproduct")
    public String PurchaseProductPost(@ModelAttribute("newTransaction") Transaction transaction ) {
//        System.out.println("++++++++++++++++++++++++++++++ JUST ENTERED /addproduct POST route ++++++++++++++++++");
//
//        if(bindingResult.hasErrors()) {
//            return "addproduct";
//        }


        // Product should have first and last names, and email at this point
        // the collections in Product are null at this point, which shows up as a BLOB in the db!  ...blob is you uncle
        transactionRepo.save(transaction);

        return "/purchaseproductconfirmation";
    }
}
