package com.restbox.mongorepo;

import java.util.Map;

public interface UserChange {
    void updateUserProfile(Map<String, String> map, String username);
    void updateUserCoins(String username, long coin);
}
