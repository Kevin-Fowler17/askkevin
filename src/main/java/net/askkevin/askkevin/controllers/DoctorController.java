package net.askkevin.askkevin.controllers;

import lombok.AllArgsConstructor;
import net.askkevin.askkevin.models.Doctor;
import net.askkevin.askkevin.models.User;
import net.askkevin.askkevin.repositories.DoctorRepository;
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
public class DoctorController {

    private final UserRepository userDao;

    private final DoctorRepository doctorDao;

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

    @PostMapping("/user/{id}/doctors")
    public String submitDoctorsForm(@ModelAttribute Doctor doctor, Model model, @PathVariable long id) {

        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        model.addAttribute("user", user);

        doctor.setUser(user);

        doctorDao.save(doctor);

        return "users/doctors";

    }

}
