package hieuubuntu.com.profileservice.controllers;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.*;

import hieuubuntu.com.profileservice.dtos.requests.userprofile.CreateProfileRequest;
import hieuubuntu.com.profileservice.dtos.responses.DefaultResponse;
import hieuubuntu.com.profileservice.dtos.responses.userprofile.UserProfileResponse;
import hieuubuntu.com.profileservice.services.UserProfileService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user-profile")
public class UserProfileController {
    private final UserProfileService userProfileService;

    @PostMapping
    public DefaultResponse<UserProfileResponse> createUserProfile(@RequestBody @Valid CreateProfileRequest request) {
        DefaultResponse<UserProfileResponse> response = new DefaultResponse<>();
        response.setData(userProfileService.createProfileUser(request));
        return response;
    }

    @GetMapping
    public DefaultResponse<UserProfileResponse> getUserProfile(@RequestParam(name = "user_id") Integer userId) {
        DefaultResponse<UserProfileResponse> response = new DefaultResponse<>();

        response.setData(userProfileService.getUserProfile(userId));
        return response;
    }
}
