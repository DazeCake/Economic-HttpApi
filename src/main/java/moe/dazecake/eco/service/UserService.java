package moe.dazecake.eco.service;

public interface UserService {

    //资金操作
    String addMoneyByName(String name, Long money);

    String spendMoneyByName(String name, Long money);

    String transferMoneyToUserByName(String nameA, String nameB, Long money);

    String transferMoneyToUserByQQ(String qqA, String qqB, Long money);

    //信息查询
    String getUserByName(String name);

    String getUserByQQ(String qq);

    //连续签到
    String checkInByName(String name);

    String checkInByQQ(String qq);

}
