package com.ada.springtestremedios.controller;

import com.ada.springtestremedios.domain.Remedio;
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

    @GetMapping("/home")
    public String home(Model model) {
        List<Remedio> lista = this.remedioService.listarRemedios();

        model.addAttribute("remedios",lista);
        return "home";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("remedio", new Remedio());
        return "create";
    }

    @PostMapping("/save")
    public String save(@Valid Remedio remedio, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "create";
        }
        remedioService.adicionaRemedio(remedio);
        return "redirect:/home";
    }
}
