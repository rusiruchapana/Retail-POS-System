package com.rusiruchapana.pos.system.repository;

import com.rusiruchapana.pos.system.dto.response.ItemResponseDTO;
import com.rusiruchapana.pos.system.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface ItemRepo extends JpaRepository<Item,Long> {

    List<Item> findAllByActiveStatusEquals(Boolean flag);
}
