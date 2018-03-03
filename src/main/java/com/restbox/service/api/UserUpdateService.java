package com.restbox.service.api;

import com.restbox.model.BbsUser;

import java.util.Map;

public interface UserUpdateService {
    BbsUser updateProfile(Map<String, String> map, String username);
    void updateCoins(String username, long coins);
}
