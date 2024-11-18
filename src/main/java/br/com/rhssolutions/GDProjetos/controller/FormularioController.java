package br.com.rhssolutions.GDProjetos.controller;

import br.com.rhssolutions.GDProjetos.domain.model.Projeto;
import br.com.rhssolutions.GDProjetos.domain.model.Status;
import br.com.rhssolutions.GDProjetos.service.ProjetosService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.nio.channels.ScatteringByteChannel;

@Controller
@RequestMapping("/projetos")
public class FormularioController {

    final ProjetosService projetosService;

    public FormularioController(ProjetosService projetosService) {
        this.projetosService = projetosService;
    }

    @GetMapping("/novo")
    public String formularioProjeto(Model model) {
        model.addAttribute("projeto", new Projeto());
        model.addAttribute("statusProjeto", Status.values());
        return "form-cadastro";
    }

    @PostMapping
    public String cadastrarProjeto(Model model, @ModelAttribute("projeto") Projeto projeto) {
        model.addAttribute("projeto", projeto);
        model.addAttribute("statusProjeto", Status.values());
        projetosService.salvar(projeto);

        return "redirect:/projetos/listar";
    }

    @GetMapping("/listar")
    public String listarProjetos(Model model) {
        model.addAttribute("projeto", projetosService.lista());
        return "projetos";
    }

}