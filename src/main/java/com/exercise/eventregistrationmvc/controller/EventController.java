package com.exercise.eventregistrationmvc.controller;

import com.exercise.eventregistrationmvc.model.Address;
import com.exercise.eventregistrationmvc.model.PersonalDetails;
import com.exercise.eventregistrationmvc.repo.AddressRepo;
import com.exercise.eventregistrationmvc.repo.PersonalDetailsRepo;
import jakarta.persistence.GeneratedValue;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EventController {

    @Autowired
    PersonalDetailsRepo personalDetailsRepo;
    @Autowired
    AddressRepo addressRepo;

    @GetMapping("/registration")
    public String registration(Model model){
        model.addAttribute("personalDetails", new PersonalDetails());
        return "registration-form";
    }

    @PostMapping("/processForm")
    public String processForm(@Valid @ModelAttribute("personalDetails") PersonalDetails personalDetails, BindingResult binder, Model model){
        if(binder.hasErrors()){
            return "registration-form";
        }

        Address address = personalDetails.getAddress();
        address.setPersonalDetails(personalDetails);
        personalDetails.setAdditionalInfo(personalDetails.getAdditionalInfo());
        personalDetailsRepo.save(personalDetails);
        addressRepo.save(address);
        model.addAttribute("personalDetails", personalDetails);
        return"confirmation";
    }
}
