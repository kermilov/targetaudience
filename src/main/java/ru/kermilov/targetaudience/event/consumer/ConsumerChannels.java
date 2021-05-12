package ru.kermilov.targetaudience.event.consumer;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

import ru.kermilov.targetaudience.event.Constants;

public interface ConsumerChannels {

    @Input(Constants.TARGET_AUDIENCE_TOPIC_PUBLISH)
    SubscribableChannel targetAudienceTopicPublish();

}
