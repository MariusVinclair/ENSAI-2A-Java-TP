package fr.ensai.running.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.ensai.running.model.Competition;
import fr.ensai.running.repository.CompetitionRepository;
/*import fr.ensai.running.repository.RegistrationRepository;*/
import fr.ensai.running.model.Athlete;

@Service
public class CompetitionService {

    private static final Logger log = LoggerFactory.getLogger(CompetitionService.class);

    @Autowired
    private CompetitionRepository competitionRepository;
    
    /*@Autowired
    private RegistrationRepository registrationRepository;*/

    /**
     * Find a Competition by idCompetition
     * 
     * @return Competition or null if not found
     */
    public Competition findById(Long idCompetition) {
        return competitionRepository.findById(idCompetition).orElse(null);
    }

    /**
     * List of all Competitions
     */
    public List<Competition> findAll() {
        return competitionRepository.findAll();
    }

    /**
     * Delete a Competition by idCompetition
     */
    public void deleteById(Long idCompetition) {
        competitionRepository.deleteById(idCompetition);
        log.warn("Competition {} deleted", idCompetition);
    }

    /*public List<Athlete> findRegisteredAthletes(Long idCompetition) {
        return registrationRepository.findIdAthleteByIdCompetition(idCompetition);
    }*/
}