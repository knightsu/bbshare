package com.restbox.service.api;

import com.restbox.model.BbsUser;

public interface FetchUserService {
    BbsUser getUser(String username);
    void addPoint(BbsUser bbsUser);
}
