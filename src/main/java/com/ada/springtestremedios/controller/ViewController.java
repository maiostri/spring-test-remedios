package com.ada.springtestremedios.controller;

import com.ada.springtestremedios.domain.Composto;
import com.ada.springtestremedios.domain.Remedio;
import com.ada.springtestremedios.service.CompostoService;
import com.ada.springtestremedios.service.RemedioService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@AllArgsConstructor
public class ViewController {

    private RemedioService remedioService;
    private CompostoService compostoService;

    @GetMapping("/home")
    public String home(Model model) {
        List<Remedio> lista = this.remedioService.listarRemedios();

        model.addAttribute("remedios", lista);
        return "home";
    }

    @GetMapping("/create")
    public String create(Model model) {
        Remedio remedio = new Remedio();
        remedio.setListaDeCompostos(List.of
                (new Composto(), new Composto(), new Composto()));

        model.addAttribute("remedio", remedio);
        model.addAttribute("compostos", compostoService.listarCompostos());
        return "create";
    }

    @GetMapping("/create-composto")
    public String createComposto(Model model) {
        model.addAttribute("composto", new Composto());
        return "create-composto";
    }

    @PostMapping("/save")
    public String save(@Valid Remedio remedio, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "create";
        }
        remedioService.adicionaRemedio(remedio);
        return "redirect:/home";
    }

    @PostMapping("/save-composto")
    public String saveComposto(@Valid Composto composto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "create";
        }
        compostoService.adicionaComposto(composto);
        return "redirect:/home";
    }
}
