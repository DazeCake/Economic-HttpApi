package moe.dazecake.eco.mapper;

import moe.dazecake.eco.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Mapper
@Repository
public interface UserMapper {

    //资金操作
    User addMoneyByName(String name, Long money);

    User spendMoneyByName(String name, Long money);

    User transferMoneyToUserByName(String nameA,String nameB, Long money);

    User transferMoneyToUserByQQ(String qqA,String qqB, Long money);

    //信息查询
    User getUserByName(String name);

    User getUserByQQ(String qq);

    //连续签到
    Integer checkInByName(String name);

    Integer checkInByQQ(String qq);


}
