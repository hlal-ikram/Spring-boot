package com.ecommerce.admin.controller;

import com.ecommerce.library.model.MembreDepartement;
import com.ecommerce.library.service.MembresDepartementService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class MembreDepartementController {

    private final MembresDepartementService MembreDepartementService;

    @GetMapping("/GestionMembres")
    public String GestionMembres(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return "redirect:/login";
        }
        model.addAttribute("title", "Manage Members");
        List<MembreDepartement> MembreDepartement = MembreDepartementService.findALl();
        model.addAttribute("MembreDepartement", MembreDepartement);
        System.out.println("La valeur  MembreDepartement : " + MembreDepartement);

        model.addAttribute("MmbreDepartementNew", new MembreDepartement());
        return "Responsable/GestionMembres";
    }

    @PostMapping("/save-Members")
    public String save(@ModelAttribute("MmbreDepartementNew") MembreDepartement MembreDepartement, Model model, RedirectAttributes redirectAttributes) {
        try {
            MembreDepartementService.save(MembreDepartement);
            System.out.println("Failed to find user with ID: " + MembreDepartement);
            model.addAttribute("MmbreDepartementNew", MembreDepartement);
            redirectAttributes.addFlashAttribute("success", "Add successfully!");
        } catch (DataIntegrityViolationException e1) {
            e1.printStackTrace();
            redirectAttributes.addFlashAttribute("error", "Duplicate name of category, please check again!");
        } catch (Exception e2) {
            e2.printStackTrace();
            model.addAttribute("MmbreDepartementNew", MembreDepartement);
            redirectAttributes.addFlashAttribute("error",
                    "Error server");
        }
        return "redirect:/GestionMembres";
    }

    @RequestMapping(value = "/findByIdMembers", method = {RequestMethod.PUT, RequestMethod.GET})
    @ResponseBody
    public Optional<MembreDepartement> findById(Long id) {
        return MembreDepartementService.findById(id);
    }

    @GetMapping("/update-Members")
    public String update(MembreDepartement MembreDepartement, RedirectAttributes redirectAttributes) {
        try {
            MembreDepartementService.update(MembreDepartement);
            redirectAttributes.addFlashAttribute("success", "Update successfully!");
        } catch (DataIntegrityViolationException e1) {
            e1.printStackTrace();
            redirectAttributes.addFlashAttribute("error", "Duplicate name of category, please check again!");
        } catch (Exception e2) {
            e2.printStackTrace();
            redirectAttributes.addFlashAttribute("error", "Error from server or duplicate name of category, please check again!");
        }
        return "redirect:/GestionMembres";
    }


    @RequestMapping(value = "/delete-Members", method = {RequestMethod.GET, RequestMethod.PUT})
    public String delete(Long id, RedirectAttributes redirectAttributes) {
        try {
            MembreDepartementService.deleteById(id);
            redirectAttributes.addFlashAttribute("success", "Deleted successfully!");
        } catch (DataIntegrityViolationException e1) {
            e1.printStackTrace();
            redirectAttributes.addFlashAttribute("error", "Duplicate name of category, please check again!");
        } catch (Exception e2) {
            e2.printStackTrace();
            redirectAttributes.addFlashAttribute("error", "Error server");
        }
        return "redirect:/GestionMembres";
    }




}
