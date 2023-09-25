package net.askkevin.askkevin.controllers;

import net.askkevin.askkevin.models.Insurance;
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
    private final InsuranceRepository insuranceDao;
    private final DoctorRepository doctorDao;
    private final PrescriptionRepository prescriptionDao;
    private final ConditionRepository conditionDao;
    private final SurgeryRepository surgeryDao;

    @GetMapping("/user")
    public String showProfileForm(Model model) {

        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (loggedInUser == null) {
            return "/login";
        }

        User user = userDao.getReferenceById(loggedInUser.getId());
        Insurance insurance = insuranceDao.findByUserId(user.getId());
        Insurance doctors = insuranceDao.findByUserId(user.getId());
        Insurance prescriptions = insuranceDao.findByUserId(user.getId());
        Insurance conditions = insuranceDao.findByUserId(user.getId());
        Insurance surgeries = insuranceDao.findByUserId(user.getId());


        model.addAttribute("user", user);
        model.addAttribute("insurance", insurance);
        model.addAttribute("doctors", doctors);
        model.addAttribute("prescriptions", prescriptions);
        model.addAttribute("conditions", conditions);
        model.addAttribute("surgeries", surgeries);

        return "users/profile";
    }

}
