package net.askkevin.askkevin.controllers;

import lombok.AllArgsConstructor;
import net.askkevin.askkevin.models.Surgery;
import net.askkevin.askkevin.models.User;
import net.askkevin.askkevin.repositories.SurgeryRepository;
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
public class SurgeryController {

    private final UserRepository userDao;

    private final SurgeryRepository surgeryDao;

    @GetMapping("/user/{id}/surgeries")
    @Transactional
    public String showSurgeriesForm(@PathVariable long id, Model model) {

        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (loggedInUser == null) {
            return "/user";
        }

        User user = userDao.getReferenceById(loggedInUser.getId());

        model.addAttribute("surgery", new Surgery());

        return "users/surgeries";
    }

    @PostMapping("/user/{id}/surgeries")
    public String submitSurgeriesForm(@ModelAttribute Surgery surgery, Model model, @PathVariable long id) {

        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        model.addAttribute("user", user);

        surgery.setUser(user);

        surgeryDao.save(surgery);

        return "users/prescriptions";

    }

}
