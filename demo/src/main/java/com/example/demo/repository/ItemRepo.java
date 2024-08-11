package com.example.demo.repository;

import com.example.demo.entity.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepo extends JpaRepository<Item , Long> {
    Page<Item> findAllByActiveStatusEquals(Boolean activeStaus, PageRequest of);
    List<Item> findAllByActiveStatusEquals(Boolean status);
}
