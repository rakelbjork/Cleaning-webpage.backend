package Godkanna;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class Godkanna_Controller {

	//Skapar upp adressen http://localhost:8080/mina_sidor
	@GetMapping("/mina_sidor")
	public String formular_godkanna_stadning(Model model)

	{
		Kunder user = new Kunder();
			model.addAttribute("user", user);

		//Skapar en lista med de olika typer av städningar som finns att välja
		List<String> typAvStadning = Arrays.asList("Toppstädning", "Diamantstädning", "Basic");
		model.addAttribute("typAvStadning", typAvStadning);
		
		return "inloggad";
	}


	@PostMapping("/mina_sidor")
	public String submitForm(@ModelAttribute("user") Kunder user)

	{
			return "stadning_godkand";
	}

}
