package com.example.validatingforminput;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.validation.Valid;

@Controller
public class WebController implements WebMvcConfigurer {

	private final PersonService personService;

	public WebController(PersonService personService) {
		this.personService = personService;
	}

	@GetMapping("/")
	public String showForm(Model model) {
		model.addAttribute("personForm", new PersonForm());
		return "form";
	}

	@PostMapping("/")
	public String checkPersonInfo(@Valid @ModelAttribute("personForm") PersonForm personForm, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "form";
		}

		personService.savePerson(personForm);

		// Redirect to login page after successful registration
		return "redirect:/login";
	}

	@GetMapping("/results")
	public String showResults() {
		return "results";
	}
}
