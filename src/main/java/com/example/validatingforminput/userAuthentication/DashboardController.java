package com.example.validatingforminput.userAuthentication;

import com.example.validatingforminput.userAuthentication.FinancialDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

// Controller for handling dashboard requests
@Controller
public class DashboardController {

    @Autowired
    private FinancialDataRepository financialDataRepository;

    @GetMapping("/dashboard")
    public String showDashboard(Model model) {
        model.addAttribute("financialData", new FinancialData());
        return "dashboard";
    }

    @PostMapping("/submitData")
    public String submitData(@ModelAttribute("financialData") @Valid FinancialData financialData, BindingResult bindingResult, Model model) {
        // Perform validation
        if (bindingResult.hasErrors()) {
            return "dashboard"; // Return to dashboard with validation errors
        }

        // Save financial data to database
        financialDataRepository.save(financialData);
        return "redirect:/dashboard";
    }
}
