package com.etena.cloud;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

public class ShiroTest {


    @Test
    public void test01(){
        SecurityManager securityManager = new IniSecurityManagerFactory("classpath:shiro.ini").getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("admin", "123");
        try{
            subject.login(token);
            System.out.println(subject.getPrincipal());
        }catch (UnknownAccountException e){
            System.out.println("用户名不存在");
        }catch (IncorrectCredentialsException e){
            System.out.println("密码错误");
        }catch (LockedAccountException e){
            System.out.println("账号锁定");
        }catch (ExcessiveAttemptsException e){
            System.out.println("重试次数超出限制");
        }catch (AuthenticationException e){
            System.out.println("其他问题 : " + e.getMessage());
        }
    }
}
