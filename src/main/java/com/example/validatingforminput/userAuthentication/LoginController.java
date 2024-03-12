package com.example.validatingforminput.userAuthentication;

import com.example.validatingforminput.PersonForm;
import com.example.validatingforminput.PersonFormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @Autowired
    private PersonFormRepository personFormRepository;

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("loginForm", new LoginForm());
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("loginForm") LoginForm loginForm, Model model) {
        // Implement authentication using personFormRepository
        // For example:
        PersonForm user = personFormRepository.findByEmail(loginForm.getEmail());
        if (user != null && user.getPassword().equals(loginForm.getPassword())) {
            return "redirect:/dashboard";
        } else {
            model.addAttribute("error", "Invalid email or password");
            return "login";
        }
    }
}
