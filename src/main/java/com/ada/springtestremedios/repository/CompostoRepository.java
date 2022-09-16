package com.ada.springtestremedios.repository;

import com.ada.springtestremedios.domain.Composto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompostoRepository extends JpaRepository<Composto, Long> {
}
