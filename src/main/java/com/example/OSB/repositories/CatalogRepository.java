package com.example.OSB.repositories;

import com.example.OSB.entities.Catalog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatalogRepository  extends JpaRepository<Catalog, Long> { }
