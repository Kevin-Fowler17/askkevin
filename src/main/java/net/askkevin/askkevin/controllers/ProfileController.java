package net.askkevin.askkevin.controllers;

import net.askkevin.askkevin.models.User;

import net.askkevin.askkevin.repositories.*;

import lombok.AllArgsConstructor;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@AllArgsConstructor
@Controller
public class ProfileController {

    private final UserRepository userDao;

    @GetMapping("/user")
    public String showProfileForm(Model model) {

        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println("*********************");
        System.out.println(loggedInUser);
        System.out.println("*********************");

        if (loggedInUser == null) {
            return "/login";
        }

        User user = userDao.getReferenceById(loggedInUser.getId());
        model.addAttribute("user", user);

        System.out.println("*********************");
        System.out.println(user);
        System.out.println("*********************");

        return "users/profile";
    }

}
