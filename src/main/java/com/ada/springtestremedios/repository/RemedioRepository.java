package com.ada.springtestremedios.repository;

import com.ada.springtestremedios.domain.Remedio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RemedioRepository extends JpaRepository<Remedio, Long> {
}
