package hieuubuntu.com.profileservice.services;

import org.springframework.stereotype.Service;

import hieuubuntu.com.profileservice.dtos.requests.userprofile.CreateProfileRequest;
import hieuubuntu.com.profileservice.dtos.responses.userprofile.UserProfileResponse;
import hieuubuntu.com.profileservice.entities.UserProfile;
import hieuubuntu.com.profileservice.repositories.UserProfileRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserProfileService {
    private final UserProfileRepository userProfileRepository;

    public UserProfileResponse createProfileUser(CreateProfileRequest request) {
        UserProfile userProfile = UserProfile.builder()
                .userId(request.getUserId())
                .positionId(request.getPositionId())
                .address(request.getAddress())
                .birthday(request.getBirthday())
                .build();

        var result = userProfileRepository.save(userProfile);

        return UserProfileResponse.of(result);
    }

    public UserProfileResponse getUserProfile(Integer userId) {
        UserProfile userProfile = userProfileRepository.findUserProfileByUserId(userId);
        return UserProfileResponse.of(userProfile);
    }
}
