package com.exercise.eventregistrationmvc.repo;

import com.exercise.eventregistrationmvc.model.PersonalDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonalDetailsRepo extends JpaRepository<PersonalDetails, Long> {
}
