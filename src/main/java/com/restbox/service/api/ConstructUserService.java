package com.restbox.service.api;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.restbox.model.BbsUser;

public interface ConstructUserService {
    BbsUser constructUser(ObjectNode userData);
}
