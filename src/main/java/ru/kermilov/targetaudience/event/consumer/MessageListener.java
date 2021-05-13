package ru.kermilov.targetaudience.event.consumer;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.context.annotation.Configuration;

import lombok.RequiredArgsConstructor;
import ru.kermilov.targetaudience.event.Constants;
import ru.kermilov.targetaudience.event.dto.TargetAudience;
import ru.kermilov.targetaudience.event.transform.TargetAudienceTransform;
import ru.kermilov.targetaudience.repository.TargetAudienceRepository;

@Configuration
@RequiredArgsConstructor
public class MessageListener {

    private final TargetAudienceRepository targetAudienceRepository;
    private final TargetAudienceTransform targetAudienceTransform;

    @StreamListener(Constants.TARGET_AUDIENCE_TOPIC_PUBLISH)
    public void targetAudienceTopicPublish(TargetAudience targetAudience) {
        if (targetAudience.getFriends() != null) {
            targetAudience.getFriends().forEach(this::targetAudienceTopicPublish);
        }
        targetAudienceRepository.save(targetAudienceTransform.transform(targetAudience));
    }

}
