package com.nfe.low.nfelow.repository;

import com.nfe.low.nfelow.entity.Nfe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NfeRepository extends JpaRepository<Nfe, Long> {
    Optional<Nfe> findByNumeroNota(Long numeroNota);
}
