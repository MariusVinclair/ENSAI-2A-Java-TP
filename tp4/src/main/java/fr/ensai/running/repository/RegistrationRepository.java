package fr.ensai.running.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.ensai.running.model.Athlete;
import fr.ensai.running.model.Registration;
import java.util.List;

public interface RegistrationRepository extends JpaRepository<Registration, Long> {

    Registration findByIdAthleteAndIdCompetition(long idAthlete, long idCompetition);

    @Query(value = """
            SELECT r.athlete.id
            FROM Registration r
            WHERE r.competition.id = :idCompetition
            """, nativeQuery = false)
    List<Athlete> findAthleteIdByCompetitionId(@Param("idCompetition") Long idCompetition);
}