package br.edu.atitus.paradigma.cambio_service.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.atitus.paradigma.cambio_service.entities.CambioEntity;

@Repository
public interface CambioRepository extends JpaRepository<CambioEntity, Integer>{
	
	Optional<CambioEntity> findByOrigemAndDestino(String origem, String destino);

}
