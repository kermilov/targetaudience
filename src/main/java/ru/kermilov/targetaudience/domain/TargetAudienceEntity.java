
package ru.kermilov.targetaudience.domain;

import java.util.HashSet;
import java.util.Set;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor // Empty constructor required as of Neo4j API 2.0.5
@Node("TargetAudience")
public class TargetAudienceEntity {

	public TargetAudienceEntity(Integer externalId, Integer sourceId, String firstName, String lastName) {
        this.externalId = externalId;
        this.sourceId = sourceId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Id
    @GeneratedValue
    private Long id;
    private Integer externalId;
    private Integer sourceId;

    private String firstName;
	private String lastName;

	public TargetAudienceEntity(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
	@Relationship(type = "FRIEND")
	public Set<TargetAudienceEntity> friends;

	public void addFriend(TargetAudienceEntity person) {
		if (friends == null) {
			friends = new HashSet<>();
		}
		friends.add(person);
	}

}
