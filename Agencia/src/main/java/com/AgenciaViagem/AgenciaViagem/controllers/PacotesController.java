package com.AgenciaViagem.AgenciaViagem.controllers;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.AgenciaViagem.AgenciaViagem.models.Pacotes;
import com.AgenciaViagem.AgenciaViagem.repository.PacotesRepository;

@Controller
public class PacotesController {
    
    @Autowired
    private PacotesRepository pr;

    // CADASTRA PACOTE
    @RequestMapping(value = "/cadastrarPacote", method = RequestMethod.GET)
    public String form() {
        return "pacote/formPacote";
    }

    @RequestMapping(value = "/cadastrarPacote", method = RequestMethod.POST)
    public String form(@Valid Pacotes pacote, BindingResult result, RedirectAttributes attributes) {

        if (result.hasErrors()) {
            attributes.addFlashAttribute("mensagem", "Verifique os campos...");
            return "redirect:/cadastrarPacote";
        }

        pr.save(pacote);
        attributes.addFlashAttribute("mensagem", "Pacote cadastrado com sucesso!");
        return "redirect:/cadastrarPacote";
    }

    // LISTA PACOTES

    @RequestMapping("/pacotes")
    public ModelAndView listaPacotes() {
        ModelAndView mv = new ModelAndView("pacote/listaPacote");
        Iterable<Pacotes> pacotes = pr.findAll();
        mv.addObject("pacotes", pacotes);
        return mv;
    }

    //

    @RequestMapping(value = "/pacote/{codigo}", method = RequestMethod.GET)
    public ModelAndView detalhesPacote(@PathVariable("codigo") String codigo) {
        Pacotes pacote = pr.findByCodigo(codigo);
        ModelAndView mv = new ModelAndView("pacote/detalhesPacote");
        mv.addObject("pacote", pacote);
        return mv;
    }

    // Deletar Pacote

    @RequestMapping("/deletarPacote")
    public String deletarPacote(String codigo) {
        Pacotes pacote = pr.findByCodigo(codigo);
        pr.delete(pacote);
        return "redirect:/pacotes";
    }

    // Adicionar Pacote

    @RequestMapping("/adicionarPacote")
    public String adicionarPacote(String codigo) {
        Pacotes pacote = pr.findByCodigo(codigo);
        pr.save(pacote);
        return "redirect:/pacotes";
    }

    // Editar Pacote
    // formulario para editar pacote
    @RequestMapping(value = "/editar-pacote", method = RequestMethod.GET)
    public ModelAndView editarPacote(String codigo) {
        Pacotes pacote = pr.findByCodigo(codigo);
        ModelAndView mv = new ModelAndView("pacote/update-pacote");
        pr.save(pacote);
        return mv;
    }

    // Update Pacote
    @RequestMapping(value = "/editar-pacote", method = RequestMethod.POST)
    public String updatePacote(@Valid Pacotes pacote, BindingResult result, RedirectAttributes attributes) {

        if (result.hasErrors()) {
            attributes.addFlashAttribute("mensagem", "Verifique os campos...");
            return "redirect:/editar-pacote";
        }

        pr.save(pacote);
        attributes.addFlashAttribute("mensagem", "Pacote atualizado com sucesso!");
        return "redirect:/editar-pacote";
    }
}
