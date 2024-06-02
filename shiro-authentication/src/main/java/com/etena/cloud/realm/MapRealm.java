package com.etena.cloud.realm;

import org.apache.shiro.authc.*;
import org.apache.shiro.realm.Realm;

import java.util.HashMap;
import java.util.Map;

public class MapRealm implements Realm {

    private static Map<String,String> users;
    static {
        users = new HashMap<String,String>();
        users.put("admin","123");
        users.put("zs","111");
        users.put("lisi","123");
    }

    @Override
    public String getName() {
        return "mapRealm";
    }

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof UsernamePasswordToken;
    }

    @Override
    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = token.getPrincipal().toString();
        Object credentials = token.getCredentials();
        String password = new String((char[])credentials);
        System.out.println("username:" + username + " password:" + password);
        if(!users.containsKey(username)){
            throw new UnknownAccountException("用户名不存在");
        }
        if(!password.equals(users.get(username))){
            throw new IncorrectCredentialsException("密码错误");
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(username, password, getName());
        return authenticationInfo;
    }
}
