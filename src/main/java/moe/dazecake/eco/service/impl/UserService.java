package moe.dazecake.eco.service.impl;

import com.alibaba.fastjson.JSON;
import moe.dazecake.eco.mapper.UserMapper;
import moe.dazecake.eco.pojo.RUser;
import org.springframework.beans.factory.annotation.Autowired;

public class UserService implements moe.dazecake.eco.service.UserService {
    @Autowired
    private UserMapper userMapper;

    //资金操作
    @Override
    public String addMoneyByName(String name, Long money) {
        try {
            RUser rUser = new RUser(userMapper.addMoneyByName(name, money), 0);
            String r = JSON.toJSONString(rUser);
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
            if (isMoneyEnough(money, userMapper.getUserByName(name).getMoney())) {
                RUser rUser = new RUser(userMapper.spendMoneyByName(name, money), 0);
                r = JSON.toJSONString(rUser);
            } else {
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
            if (isMoneyEnough(money, userMapper.getUserByName(nameA).getMoney())) {
                RUser rUser = new RUser(userMapper.transferMoneyToUserByName(nameA, nameB, money), 0);
                return JSON.toJSONString(rUser);
            }else {
                String r = "{\"code\":3}";
                return r;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String transferMoneyToUserByQQ(String qqA, String qqB, Long money) {
        try {
            if (isMoneyEnough(money, userMapper.getUserByQQ(qqA).getMoney())) {
                RUser rUser = new RUser(userMapper.transferMoneyToUserByQQ(qqA, qqB, money), 0);
                return JSON.toJSONString(rUser);
            }else {
                String r = "{\"code\":3}";
                return r;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //信息查询
    @Override
    public String getUserByName(String name) {
        try {
            RUser rUser = new RUser(userMapper.getUserByName(name), 0);
            String r = JSON.toJSONString(rUser);
            return r;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "{\"code\":2}";
    }

    @Override
    public String getUserByQQ(String qq) {
        try {
            RUser rUser = new RUser(userMapper.getUserByQQ(qq), 0);
            String r = JSON.toJSONString(rUser);
            return r;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "{\"code\":2}";
    }

    //连续签到
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

    //金额检查
    public static boolean isMoneyEnough(Long spend, Long have) {
        if (spend < have) {
            return true;
        } else {
            return false;
        }
    }

}
