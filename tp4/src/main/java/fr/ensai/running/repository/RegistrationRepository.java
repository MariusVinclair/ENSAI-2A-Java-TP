package fr.ensai.running.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.ensai.running.model.Athlete;
import fr.ensai.running.model.Registration;
import java.util.List;

public interface RegistrationRepository extends JpaRepository<Registration, Long> {

    /*@Query(value = """
            SELECT r.registration.id
            FROM Registration r
            WHERE r.competition.id = :idCompetition
            AND r.athlete.id = :idAthlete
            """, nativeQuery = false)
    Registration findByIdAthleteAndIdCompetition(@Param("idCompetition") Long idCompetition, @Param("idAthlete") Long idAthlete);*/

    /*@Query(value = """
        SELECT r.athlete.id
        FROM Registration r
        WHERE r.competition.id = :idCompetition
        """, nativeQuery = false)
    List<Athlete> findIdAthleteByIdCompetition(@Param("idCompetition") Long idCompetition);*/
}