
package ru.kermilov.targetaudience;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

import ru.kermilov.targetaudience.event.consumer.ConsumerChannels;

@SpringBootApplication
@EnableNeo4jRepositories
@EnableBinding(ConsumerChannels.class)
public class TargetAudienceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TargetAudienceApplication.class, args);
	}

}
