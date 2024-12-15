package com.luv2code.springdemo.mcv;

import jakarta.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {

    //InitBinder will preprocess all web requests coming into the controller
    @InitBinder
    public void initBinder(WebDataBinder dataBinder){
        // StringTrimmerEditor removes whitespace that is training or leading, true means trim to null
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping("/")
    public String showForm(Model theModel){

        theModel.addAttribute("customer", new Customer());

        return "customer-form";
    }

    @PostMapping("/processForm")
    public  String processForm(
            @Valid @ModelAttribute("customer") Customer theCustomer,
            BindingResult bindingResult
            //bindingResult is responsbile for the validation result
    ){
        System.out.println("Binding Results " + bindingResult.toString());
        if(bindingResult.hasErrors()){
            //send back to form
            return "customer-form";
        }else{
            //success
            return "customer-confirmation";
        }
    }
}
