package ru.kermilov.targetaudience.event;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Constants {

    /**
     * Координаты топика, куда прилетают данные из адаптеров
     */
    public static final String TARGET_AUDIENCE_TOPIC_PUBLISH = "targetAudienceTopicPublish";

}
