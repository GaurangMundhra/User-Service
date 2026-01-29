package com.gaurangdev.userservice.repository;


import com.gaurangdev.userservice.entities.UserInfo;
import com.gaurangdev.userservice.entities.UserInfoDto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<UserInfo, String> {

    Optional<UserInfo> findByUserId(String userId);
}
