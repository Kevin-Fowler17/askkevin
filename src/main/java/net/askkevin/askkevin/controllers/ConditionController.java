package net.askkevin.askkevin.controllers;

import lombok.AllArgsConstructor;
import net.askkevin.askkevin.models.Condition;
import net.askkevin.askkevin.models.User;
import net.askkevin.askkevin.repositories.ConditionRepository;
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
public class ConditionController {

    private final UserRepository userDao;

    private final ConditionRepository conditionDao;

    @GetMapping("/user/{id}/conditions")
    @Transactional
    public String showConditionsForm(@PathVariable long id, Model model) {

        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (loggedInUser == null) {
            return "/user";
        }

        User user = userDao.getReferenceById(loggedInUser.getId());

        model.addAttribute("condition", new Condition());

        return "users/conditions";
    }

    @PostMapping("/user/{id}/condtions")
    public String submitSurgeriesForm(@ModelAttribute Condition condition, Model model, @PathVariable long id) {

        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        model.addAttribute("user", user);

        condition.setUser(user);

        conditionDao.save(condition);

        return "users/condtions";

    }

}
