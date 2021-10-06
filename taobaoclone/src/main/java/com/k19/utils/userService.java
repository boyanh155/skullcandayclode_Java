package com.k19.utils;

import com.k19.models.member;

public class userService {
    // account is a account in DB
    // guest(uname,passwd) is a user try to log in this account
    public boolean checkLogin(member account, String uname, String passwd) {
        if (uname.equals(account.getUsername()) && passwd.equals(account.getPassword())) {
            return true;
        } else {
            return false;
        }
    }
}
