package ru.kermilov.targetaudience.event.transform;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import ru.kermilov.targetaudience.domain.TargetAudienceEntity;
import ru.kermilov.targetaudience.event.dto.TargetAudience;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TargetAudienceTransform {

    public static TargetAudienceEntity transform(TargetAudience targetAudience) {
        return new TargetAudienceEntity(targetAudience.getExternalId(), 1, targetAudience.getFirstName(), targetAudience.getLastName());
    }

}
