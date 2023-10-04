package net.askkevin.askkevin.controllers;

import lombok.AllArgsConstructor;
import net.askkevin.askkevin.models.Insurance;
import net.askkevin.askkevin.models.Prescription;
import net.askkevin.askkevin.models.User;
import net.askkevin.askkevin.repositories.PrescriptionRepository;
import net.askkevin.askkevin.repositories.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.lang.model.element.NestingKind;

@AllArgsConstructor
@Controller
public class PrescriptionController {

    private final UserRepository userDao;

    private final PrescriptionRepository prescriptionDao;

    @GetMapping("/user/{id}/prescriptions")
    public String showPrescriptionsForm(@PathVariable long id, Model model) {

        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (loggedInUser == null) {
            return "/user";
        }

        User user = userDao.getReferenceById(loggedInUser.getId());

        model.addAttribute("prescription", new Prescription());

        return "users/prescriptions";
    }

    @PostMapping("/user/{id}/prescriptions")
    public String submitPrescriptionsForm(@ModelAttribute Prescription prescription, Model model, @PathVariable long id) {

        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        model.addAttribute("user", user);

        prescription.setUser(user);

        prescriptionDao.save(prescription);

        return "users/prescriptions";

    }

}
