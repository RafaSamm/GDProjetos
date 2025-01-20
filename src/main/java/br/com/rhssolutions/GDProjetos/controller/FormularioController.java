package br.com.rhssolutions.GDProjetos.controller;

import br.com.rhssolutions.GDProjetos.domain.model.Projeto;
import br.com.rhssolutions.GDProjetos.domain.model.Status;
import br.com.rhssolutions.GDProjetos.service.ProjetosService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @DeleteMapping("/{id}")
    public String excluirProjeto(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
            projetosService.excluirPorId(id);
            redirectAttributes.addFlashAttribute("mensagem", "Projeto excluído com sucesso!");
        } catch (RuntimeException e) {
            redirectAttributes.addFlashAttribute("erro", "Erro ao excluir o projeto: " + e.getMessage());
        }
        return "redirect:/projetos/listar";
    }

    @GetMapping("/editar/{id}")
    public String editarProjeto(@PathVariable Long id, Model model) {
        var projeto = projetosService.buscarPorId(id);
        model.addAttribute("projeto", projeto);
        model.addAttribute("statusProjeto", Status.values());
        return "form-cadastro";
    }

    @PutMapping("/editar/{id}")
    public String atualizarProjeto(@PathVariable Long id, @ModelAttribute("projeto") Projeto projeto) {
        projetosService.atualizar(id, projeto);
        projetosService.salvar(projeto);
        return "redirect:/projetos/listar";
    }



}
