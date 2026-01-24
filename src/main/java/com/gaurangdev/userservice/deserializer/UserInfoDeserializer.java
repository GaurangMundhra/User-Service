package com.gaurangdev.userservice.deserializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gaurangdev.userservice.entities.UserInfoDto;
import org.springframework.core.serializer.Deserializer;

import java.util.Map;

public class UserInfoDeserializer implements Deserializer<UserInfoDto> {

    @Override
    public void configure(Map<String , ?> configs, boolean isKey) {
        // No configuration needed
    }

    @Override
    public UserInfoDto deserialize(String arg0, byte[] arg1) {
        ObjectMapper objectMapper = new ObjectMapper();
        UserInfoDto user = null;
        try {
            user = objectMapper.readValue(arg1.toString(), UserInfoDto.class);
            return user;
        } catch (Exception e) {
            System.out.println("Cannot deserialize user info: " + e.getMessage());
            return null;
        }
    }

    @Override
    public void close() {
        // No resources to close
    }
}
