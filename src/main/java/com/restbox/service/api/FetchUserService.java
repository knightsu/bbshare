package com.restbox.service.api;

import com.restbox.model.BbsUser;

public interface FetchUserService {
    BbsUser getUser(String username);
    BbsUser addPoint(BbsUser bbsUser);
}
