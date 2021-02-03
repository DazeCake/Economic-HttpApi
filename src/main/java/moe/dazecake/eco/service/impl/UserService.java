package moe.dazecake.eco.service.impl;

import com.alibaba.fastjson.JSON;
import moe.dazecake.eco.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class UserService implements moe.dazecake.eco.service.UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public String addMoneyByName(String name, Long money) {
        try {
            String r = JSON.toJSONString(userMapper.addMoneyByName(name, money));
            return r;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String spendMoneyByName(String name, Long money) {
        String r = "";
        try {
            if (money <= userMapper.getUserByName(name).getMoney()){

                r = JSON.toJSONString(userMapper.spendMoneyByName(name, money));
            }else {
                r = "{\"code\":3}";
            }
            return r;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String transferMoneyToUserByName(String nameA, String nameB, Long money) {
        try {
            String r = JSON.toJSONString(userMapper.transferMoneyToUserByName(nameA, nameB, money));
            return r;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String transferMoneyToUserByQQ(String qqA, String qqB, Long money) {
        try {
            String r = JSON.toJSONString(userMapper.transferMoneyToUserByQQ(qqA, qqB, money));
            return r;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String getUserByName(String name) {
        try {
            String r = JSON.toJSONString(userMapper.getUserByName(name));
            return r;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String getUserByQQ(String qq) {
        try {
            String r = JSON.toJSONString(userMapper.getUserByQQ(qq));
            return r;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String checkInByName(String name) {
        try {
            String r = JSON.toJSONString(userMapper.checkInByName(name));
            return r;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String checkInByQQ(String qq) {
        try {
            String r = JSON.toJSONString(userMapper.checkInByQQ(qq));
            return r;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
