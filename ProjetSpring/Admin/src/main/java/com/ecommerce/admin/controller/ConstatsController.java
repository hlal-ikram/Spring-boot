package com.ecommerce.admin.controller;

import com.ecommerce.library.service.OrdinateurService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class ConstatsController {

    private final OrdinateurService OrdinateurService;

    @GetMapping("/AllConstats")
    public String getAll(Model model, Principal principal) {
//        if (principal == null) {
//            return "redirect:/login";
//        } else {
//            List<Ordinateur> OrdinateurList = OrdinateurService.getAllOrdinateurs();
//            model.addAttribute("Ordinateurs", OrdinateurList);
//            System.out.println("ERYTIU"+OrdinateurList);
//            return "products.html";
//        }
        return "Responsable/constats";
    }




}
