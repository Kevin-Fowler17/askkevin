package net.askkevin.askkevin.controllers;

import lombok.AllArgsConstructor;
import net.askkevin.askkevin.models.User;
import net.askkevin.askkevin.repositories.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@AllArgsConstructor
@Controller
public class DoctorController {

    private final UserRepository userDao;

    @GetMapping("/user/{id}/doctors")
    @Transactional
    public String showDoctorsForm(@PathVariable long id, Model model) {

        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (loggedInUser == null) {
            return "/user";
        }

        User user = userDao.getReferenceById(loggedInUser.getId());

        return "users/doctors";
    }

}
