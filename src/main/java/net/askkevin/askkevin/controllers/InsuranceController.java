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

        model.addAttribute("insurance", new Insurance());

        return "users/insurance";
    }

    @PostMapping(path = "/user/{id}/insurance")
    public String submitInsuranceInfo(@ModelAttribute Insurance insurance, Model model) {

        System.out.println("***************************");
        System.out.println("We got into Post Mapping!!!");
        System.out.println("***************************");

        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        model.addAttribute("user", user);

        insurance.setUser(user);

        System.out.println("***************************");
        System.out.println(user);
        System.out.println("***************************");

        System.out.println("***************************");
        System.out.println(insurance);
        System.out.println("***************************");

        insuranceDao.save(insurance);

        System.out.println("***************************");
        System.out.println("*********** 3 *************");
        System.out.println("***************************");

        return "redirect:/user";
    }



}
