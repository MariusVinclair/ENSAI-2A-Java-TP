package fr.ensai.running.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.ensai.running.model.Competition;
import fr.ensai.running.service.CompetitionService;

@Controller
@RequestMapping("/competition")
public class CompetitionController {

    @Autowired
    private CompetitionService competitionService;

    /**
     * Display all Competitions
     */
    @GetMapping()
    public String findAllCompetitions(Model model) {
        model.addAttribute("competitions", competitionService.findAll());
        return "allCompetitions"; // allCompetition.html
    }

    /**
     * Delete a Competition by idCompetition
     */
    @GetMapping("/delete/{idCompetition}")
    public String deleteCompetitionById(@PathVariable(value = "idCompetition") long idCompetition) {
        Competition competition = competitionService.findById(idCompetition);
        if (competition != null) {
            competitionService.deleteById(idCompetition);
        }
        return "redirect:/competition"; // redirection to endpoint /competition

    }
}