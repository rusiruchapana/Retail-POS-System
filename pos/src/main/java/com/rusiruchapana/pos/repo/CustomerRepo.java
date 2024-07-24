package com.rusiruchapana.pos.repo;

import com.rusiruchapana.pos.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@EnableJpaRepositories
@Repository
public interface CustomerRepo extends JpaRepository<Customer,Long> {


    List<Customer> findAllByCustomerName(String name);
}
