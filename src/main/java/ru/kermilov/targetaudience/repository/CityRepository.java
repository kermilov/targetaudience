package ru.kermilov.targetaudience.repository;

import java.util.Optional;

import org.springframework.data.neo4j.repository.Neo4jRepository;

import ru.kermilov.targetaudience.domain.CityEntity;

public interface CityRepository extends Neo4jRepository<CityEntity, Long> {
    Optional<CityEntity> findByName(String name); // TODO: spring cash
}
