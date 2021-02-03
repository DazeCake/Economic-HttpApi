package moe.dazecake.eco.controller;

import moe.dazecake.eco.mapper.UserMapper;
import moe.dazecake.eco.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@ResponseBody
@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @PostMapping("/addMoneyByName")
    public String addMoneyByName(String name, Long money) {
        return new UserService().addMoneyByName(name, money);
    }

    @PostMapping("/spendMoneyByName")
    public String spendMoneyByName(String name, Long money) {
        return new UserService().spendMoneyByName(name, money);
    }

    @PostMapping("/transferMoneyToUserByName")
    public String transferMoneyToUserByName(String nameA, String nameB, Long money) {
        return new UserService().transferMoneyToUserByName(nameA, nameB, money);
    }

    @PostMapping("/transferMoneyToUserByQQ")
    public String transferMoneyToUserByQQ(String qqA, String qqB, Long money) {
        return new UserService().transferMoneyToUserByQQ(qqA, qqB, money);
    }

    @GetMapping("/getUserByName")
    public String getUserByName(String name) {
        return new UserService().getUserByName(name);
    }

    @GetMapping("/getUserByQQ")
    public String getUserByQQ(String qq) {
        return new UserService().getUserByQQ(qq);
    }

    @PostMapping("/checkInByName")
    public String checkInByName(String name) {
        return new UserService().checkInByName(name);
    }

    @PostMapping("/checkInByQQ")
    public String checkInByQQ(String qq) {
        return new UserService().checkInByQQ(qq);
    }

}
