package hieuubuntu.com.profileservice.controllers;

import hieuubuntu.com.profileservice.dtos.requests.userprofile.CreateProfileRequest;
import hieuubuntu.com.profileservice.dtos.responses.DefaultResponse;
import hieuubuntu.com.profileservice.dtos.responses.userprofile.UserProfileResponse;
import hieuubuntu.com.profileservice.services.UserProfileService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class InternalUserProfileController {
    private final UserProfileService userProfileService;

    @PostMapping("/internal/users")
    public DefaultResponse<UserProfileResponse> createUserProfile(@RequestBody @Valid CreateProfileRequest request) {
        DefaultResponse<UserProfileResponse> response = new DefaultResponse<>();
        response.setData(userProfileService.createProfileUser(request));
        return response;
    }
}
