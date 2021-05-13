package ru.kermilov.targetaudience.event.transform;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import ru.kermilov.targetaudience.TestConstants;
import ru.kermilov.targetaudience.domain.CityEntity;
import ru.kermilov.targetaudience.domain.TargetAudienceEntity;
import ru.kermilov.targetaudience.event.dto.TargetAudience;
import ru.kermilov.targetaudience.repository.CityRepository;
import ru.kermilov.targetaudience.repository.TargetAudienceRepository;

@ExtendWith(MockitoExtension.class)
class TargetAudienceTransformTest {

    @Mock
    TargetAudienceRepository targetAudienceRepository;
    @Mock
    CityRepository cityRepository;

    @Test
    void transformTest() {
        // что ожидаем
        var expectedFriend = new TargetAudienceEntity(null,
            TestConstants.FRIEND_EXTERNAL_ID,
            TestConstants.SOURCE_ID,
            TestConstants.FRIEND_FIRST_NAME,
            TestConstants.FRIEND_LAST_NAME,
            new CityEntity(TestConstants.FRIEND_CITY),
            null);
        var expected = new TargetAudienceEntity(null,
            TestConstants.EXTERNAL_ID,
            TestConstants.SOURCE_ID,
            TestConstants.FIRST_NAME,
            TestConstants.LAST_NAME,
            new CityEntity(TestConstants.CITY),
            Set.of(expectedFriend));
        var friend = new TargetAudience(TestConstants.FRIEND_EXTERNAL_ID,
            TestConstants.FRIEND_FIRST_NAME,
            TestConstants.FRIEND_LAST_NAME,
            TestConstants.FRIEND_CITY);
        // входные данные
        var targetAudience = new TargetAudience(TestConstants.EXTERNAL_ID,
            TestConstants.FIRST_NAME,
            TestConstants.LAST_NAME,
            TestConstants.CITY,
            List.of(friend));
        // что получаем
        var targetAudienceTransform = new TargetAudienceTransform(targetAudienceRepository, cityRepository);
        var actual = targetAudienceTransform.transform(targetAudience);
        // сравниваем
        assertThat(actual)
            .usingRecursiveComparison()
            .ignoringExpectedNullFields()
            .isEqualTo(expected);
    }
}
