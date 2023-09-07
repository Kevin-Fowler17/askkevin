package net.askkevin.askkevin.controllers;

import lombok.AllArgsConstructor;
import net.askkevin.askkevin.models.User;
import net.askkevin.askkevin.repositories.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@AllArgsConstructor
@Controller
public class InsuranceController {

    private final UserRepository userDao;

    @GetMapping("/insurance")
    @Transactional
    public String showInsuranceForm(Model model) {

        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (loggedInUser == null) {
            return "/user";
        }

        User user = userDao.getReferenceById(loggedInUser.getId());

        return "users/insurance";
    }

}
