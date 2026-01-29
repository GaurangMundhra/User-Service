package com.gaurangdev.userservice.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserInfoDto {

    private Long id;
    private String userId;

    // Kafka events may be partial → must be nullable
    private String firstName;
    private String lastName;
    private Long phoneNumber;

    // Usually safe to expect email, but still nullable at DTO level
    private String email;

    private String profilePic;
}
