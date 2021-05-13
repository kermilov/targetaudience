package ru.kermilov.targetaudience.domain;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor // Empty constructor required as of Neo4j API 2.0.5
@Node("City")
public class CityEntity {

    public CityEntity(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue
    private Long id;
    private String name;

}
