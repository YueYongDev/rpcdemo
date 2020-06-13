package com.lyy.client.remoteservice;

import com.lyy.client.anno.RemoteClass;

@RemoteClass("com.lyy.server.service.UserService")
public interface UserService {
    Integer getUserCount();

    String getUserInfo(Integer id);

    Integer addUser(String name, String email, Integer age, Integer sex, String schoolName);
}