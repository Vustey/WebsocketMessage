package com.vustey.websocket.user;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRespository extends MongoRepository<User, String> {

    List<User> findAllByStatus(Status status);
}
