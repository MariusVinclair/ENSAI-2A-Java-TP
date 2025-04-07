package fr.ensai.running.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.ensai.running.model.Registration;

public interface RegistrationRepository extends JpaRepository<Registration, Long> {
}