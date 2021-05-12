package ru.kermilov.targetaudience.repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;

import ru.kermilov.targetaudience.domain.TargetAudienceEntity;

public interface TargetAudienceRepository extends Neo4jRepository<TargetAudienceEntity, Long> {

}
