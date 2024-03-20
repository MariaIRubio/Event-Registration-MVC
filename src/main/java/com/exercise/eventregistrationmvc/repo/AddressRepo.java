package com.exercise.eventregistrationmvc.repo;

import com.exercise.eventregistrationmvc.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepo extends JpaRepository<Address, Long> {
}
