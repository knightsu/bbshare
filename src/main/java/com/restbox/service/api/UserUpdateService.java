package com.restbox.service.api;

import java.util.Map;

public interface UserUpdateService {
    void updateProfile(Map<String, String> map, String username);
    void updateCoins(String username, int coins);
}
