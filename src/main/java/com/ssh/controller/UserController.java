package com.ssh.controller;

import net.sf.json.JSONObject;
import com.ssh.entity.User;
import com.ssh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    private String result;
    private int i;
    private String str ;

    public String judge(String userName){ //判断userName是电话号码还是邮箱号码
        String regPhone = "^(13[4,5,6,7,8,9]|15[0,8,9,1,7]|188|187)\\d{8}$";
        String regEmail = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
        Pattern p = Pattern.compile(regPhone);
        Pattern e = Pattern.compile(regEmail);
        Matcher m1 = p.matcher(userName);
        Matcher m2 = e.matcher(userName);
        if (m1.matches()){//符合电话号码格式
            str = "0";
            return str;
        }else if (m2.matches()){//符合邮箱号码码格式
            str = "1";
            return str;
        }else {
            str = "3";
            return str;
        }

    }

    public int checkPhone(String cellphone) {//判断电话号码是否已存在
        User user = userService.getByPhone(cellphone);
        if (user == null) {
            i = 1;
        }else{
            i = 0;
        }
        return i;
    	}

    public int checkEmail(String email) { //判断邮箱号码是否已存在
        User user = userService.getByEmail(email);
        if (user == null) {
            i = 1;
        }else {
            i = 0;
        }
        return i;
    }


    @RequestMapping("/register")
    public void register(User user){//注册
        String warnMsg = "";
        JSONObject jo = new JSONObject();
        judge(user.getName());
        if (str.equals("0")){//符合电话号码格式
            checkPhone(user.getName());
            if (i==1){//该电话号码可用
                user.setCellphone(user.getName());
                user.setPassword("加密密码");
                userService.add(user);
                warnMsg = "注册成功";
            }else {
                warnMsg = "注册失败，该电话号码已经被注册注册失败";
            }
        }else if (str.equals("1")){//符合邮箱号码码格式
            checkEmail(user.getName());
            if (i==1){//该邮箱号码可用
                user.setEmail(user.getName());
                user.setPassword("加密密码");
                userService.add(user);
                warnMsg = "注册成功";
            }else {
                warnMsg = "注册失败，该邮箱号码已经被注册";
            }
        }else {
            warnMsg = "注册失败，用户名格式不正确";
        }
        jo.put("warnMsg", warnMsg);
        result = jo.toString();
    }


    @RequestMapping("/login")
    public void login(User user){//注册
        String warnMsg = "";
        JSONObject jo = new JSONObject();
        judge(user.getName());
        if (str.equals("0")){//符合电话号码格式
            checkPhone(user.getName());
            if (i==0){//存在该电话号码
                User user1 = userService.getByPhone(user.getName());
                if (user1.getPassword().equals(user.getPassword())){
                    warnMsg = "登陆成功";
                }else {
                    warnMsg = "登陆失败，密码错误";
                }
            }else {
                warnMsg = "登陆失败，没有该用户";
            }
        }else if (str.equals("1")){//符合邮箱号码码格式
            checkEmail(user.getName());
            if (i==0){//存在该邮箱号码
                User user1 = userService.getByEmail(user.getName());
                if (user1.getPassword().equals(user.getPassword())){
                    warnMsg = "登陆成功";
                }else {
                    warnMsg = "登陆失败，密码错误";
                }
            }else {
                warnMsg = "登陆失败，没有该用户";
            }
        }else {//格式全不符合
                warnMsg = "登陆失败，没有该用户";
        }
        jo.put("warnMsg", warnMsg);
        result = jo.toString();
    }
}
