package ru.kermilov.targetaudience.event.transform;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import ru.kermilov.targetaudience.domain.CityEntity;
import ru.kermilov.targetaudience.domain.TargetAudienceEntity;
import ru.kermilov.targetaudience.event.dto.TargetAudience;
import ru.kermilov.targetaudience.repository.CityRepository;
import ru.kermilov.targetaudience.repository.TargetAudienceRepository;

@Service
@RequiredArgsConstructor
public class TargetAudienceTransform {

    @Autowired
    private final TargetAudienceRepository targetAudienceRepository;
    @Autowired
    private final CityRepository cityRepository;

    public TargetAudienceEntity transform(TargetAudience targetAudience) {
        var externalId = targetAudience.getExternalId();
        var sourceId = 1;
        var targetAudienceEntity = targetAudienceRepository.findByExternalIdAndSourceId(externalId, sourceId)
            .orElse(new TargetAudienceEntity(externalId, sourceId));
        targetAudienceEntity.setFirstName(targetAudience.getFirstName());
        targetAudienceEntity.setLastName(targetAudience.getLastName());
        Optional.ofNullable(targetAudience.getCity()).ifPresent(city -> {
            var cityEntity = cityRepository.findByName(city)
                .orElse(new CityEntity(city));
            targetAudienceEntity.setCityEntity(cityEntity);
        });
        Optional.ofNullable(targetAudience.getFriends()).ifPresent(friends ->
            friends.stream()
                .map(this::transform)
                .forEach(targetAudienceEntity::addFriend)
        );
        return targetAudienceEntity;
    }

}
