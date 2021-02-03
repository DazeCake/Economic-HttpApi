package moe.dazecake.eco.controller;

import moe.dazecake.eco.mapper.UserMapper;
import moe.dazecake.eco.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@ResponseBody
@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    public HashMap<String,String> addMoneyByName(String name,Long money){
        HashMap<String, String> map = new HashMap<>();

        try {
            User r = userMapper.addMoneyByName(name, money);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return map;
    }

}
