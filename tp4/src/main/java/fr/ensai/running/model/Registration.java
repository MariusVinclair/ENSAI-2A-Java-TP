package fr.ensai.running.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Registration {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_registration")
    private Long idRegistration;

    @ManyToOne
    @JoinColumn(name = "id_athlete")
    private Athlete idAthlete;

    @ManyToOne
    @JoinColumn(name = "id_competition")
    private Competition idCompetition;

    @Column(name = "registration_date")
    private LocalDate registrationDate;

}
