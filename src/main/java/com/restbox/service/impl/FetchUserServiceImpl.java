package com.restbox.service.impl;

import com.restbox.model.BbsUser;
import com.restbox.service.api.FetchUserService;

public class FetchUserServiceImpl implements FetchUserService {
    @Override
    public BbsUser getUser(String username) {
        return null;
    }

    @Override
    public BbsUser addPoint(BbsUser bbsUser) {
        bbsUser.setCoins(bbsUser.getCoins()+1);
        return bbsUser;
    }
}
