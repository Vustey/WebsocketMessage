package com.vustey.websocket.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRespository respository;

    public void saveUser(User user) {
        user.setStatus(Status.ONLINE);
        respository.save(user);
    }

    public void disconnect(User user) {
        var storedUser = respository.findById(user.getNickName()).orElse(null);
        if (storedUser != null) {
            storedUser.setStatus(Status.OFFLINE);
            respository.save(storedUser);
        }
    }

    public List<User> findConnectedUsers(){
        return respository.findAllByStatus(Status.ONLINE);
    }
}
