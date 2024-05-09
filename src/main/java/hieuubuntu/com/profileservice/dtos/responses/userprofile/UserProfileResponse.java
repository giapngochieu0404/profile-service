package hieuubuntu.com.profileservice.dtos.responses.userprofile;

import java.time.LocalDate;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import hieuubuntu.com.profileservice.entities.UserProfile;
import lombok.*;

@Getter
@Setter
@Builder
public class UserProfileResponse {
    @JsonProperty("user_profile_id")
    private Long userProfileId;

    @JsonProperty("user_id")
    private Integer userId;

    private LocalDate birthday;

    @JsonProperty("position_id")
    private Integer positionId;

    private String address;

    public static UserProfileResponse of(UserProfile userProfile) {
        if (Objects.isNull(userProfile)) {
            return null;
        }
        return UserProfileResponse.builder()
                .userProfileId(userProfile.getId())
                .userId(userProfile.getUserId())
                .positionId(userProfile.getPositionId())
                .address(userProfile.getAddress())
                .birthday(userProfile.getBirthday())
                .build();
    }
}
