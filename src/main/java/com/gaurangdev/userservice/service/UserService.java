package com.gaurangdev.userservice.service;

import com.gaurangdev.userservice.entities.UserInfo;
import com.gaurangdev.userservice.entities.UserInfoDto;
import com.gaurangdev.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserInfoDto createOrUpdateUser(UserInfoDto userInfoDto) {

        UserInfo userInfo;

        var optionalUser = userRepository.findByUserId(userInfoDto.getUserId());

        if (optionalUser.isPresent()) {
            // UPDATE
            userInfo = optionalUser.get();
            userInfo.setFirstName(userInfoDto.getFirstName());
            userInfo.setLastName(userInfoDto.getLastName());
            userInfo.setPhoneNumber(userInfoDto.getPhoneNumber());
            userInfo.setEmail(userInfoDto.getEmail());
            userInfo.setProfilePic(userInfoDto.getProfilePic());
        } else {
            // CREATE (FIX IS HERE 👇)
            userInfo = mapToEntity(userInfoDto);
        }

        userInfo = userRepository.save(userInfo);

        return mapToDto(userInfo);
    }

    public UserInfoDto getUser(String userId) {

        UserInfo userInfo = userRepository
                .findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return mapToDto(userInfo);
    }

    private UserInfoDto mapToDto(UserInfo userInfo) {
        return UserInfoDto.builder()
                .userId(userInfo.getUserId())
                .firstName(userInfo.getFirstName())
                .lastName(userInfo.getLastName())
                .phoneNumber(userInfo.getPhoneNumber())
                .email(userInfo.getEmail())
                .profilePic(userInfo.getProfilePic())
                .build();
    }

    // ✅ NEW: replaces transformToUserInfo()
    private UserInfo mapToEntity(UserInfoDto dto) {
        return UserInfo.builder()
                .userId(dto.getUserId())
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .phoneNumber(dto.getPhoneNumber())
                .email(dto.getEmail())
                .profilePic(dto.getProfilePic())
                .build();
    }
}
