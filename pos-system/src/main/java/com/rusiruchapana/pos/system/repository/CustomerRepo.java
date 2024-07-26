package com.rusiruchapana.pos.system.repository;

import com.rusiruchapana.pos.system.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer,Long> {
}
