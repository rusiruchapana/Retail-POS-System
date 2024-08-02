package com.rusiruchapana.pos.system.repository;

import com.rusiruchapana.pos.system.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface ItemRepo extends JpaRepository<Item,Long> {
}
