package net.askkevin.askkevin.controllers;

import lombok.AllArgsConstructor;
import net.askkevin.askkevin.models.Insurance;
import net.askkevin.askkevin.models.User;
import net.askkevin.askkevin.repositories.InsuranceRepository;
import net.askkevin.askkevin.repositories.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@AllArgsConstructor
@Controller
public class InsuranceController {

    private final UserRepository userDao;
    private final InsuranceRepository insuranceDao;

    @GetMapping("/user/{id}/insurance")
    @Transactional
    public String showInsuranceForm(@PathVariable long id, Model model) {

        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (loggedInUser == null) {
            return "/user";
        }

        User user = userDao.getReferenceById(loggedInUser.getId());

        Insurance currentInsuranceSettings = insuranceDao.findByUserId(user.getId());

        model.addAttribute("insurance", currentInsuranceSettings);

        System.out.println("******* curernt *******");
        System.out.println(currentInsuranceSettings);
        System.out.println("***********************");

        return "users/insurance";
    }

    @PostMapping(path = "/user/{id}/insurance")
    public String submitInsuranceInfo(@ModelAttribute Insurance newInsurance, Model model, @PathVariable long id) {

        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        model.addAttribute("user", user);

        Insurance existingInsurance = insuranceDao.findByUserId(user.getId());

        if (existingInsurance != null) {
            // User already has insurance data, update it with the new answers
            existingInsurance.setQ1(newInsurance.getQ1());
            existingInsurance.setQ1os(newInsurance.getQ1os());
            existingInsurance.setQ2(newInsurance.getQ2());
            existingInsurance.setQ2os(newInsurance.getQ2os());
            existingInsurance.setQ3(newInsurance.getQ3());
            existingInsurance.setQ4(newInsurance.getQ4());
            existingInsurance.setQ5(newInsurance.getQ5());
            existingInsurance.setQ5os(newInsurance.getQ5os());
            existingInsurance.setQ6(newInsurance.getQ6());
            existingInsurance.setQ6os(newInsurance.getQ6os());
            existingInsurance.setQ7(newInsurance.getQ7());

            if (existingInsurance.getQ4() == 2) {
                existingInsurance.setQ5(99);
                existingInsurance.setQ6(9);
                existingInsurance.setQ7("NA");
            }

            // Update the existing insurance object
            insuranceDao.save(existingInsurance);

        } else {
            // Create a new Insurance object and save it
            newInsurance.setUser(user);

            if (newInsurance.getQ4() == 2) {
                newInsurance.setQ5(99);
                newInsurance.setQ6(9);
                newInsurance.setQ7("NA");
            }

            insuranceDao.save(newInsurance);
        }

        return "redirect:/user";
    }

}
