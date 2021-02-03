package moe.dazecake.eco.mapper;

import moe.dazecake.eco.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {

    User addMoneyByName(String name, Long money);

    User spendMoney(Long money);

    User getUserByName(String name);

    User getUserByQQ(String qq);

    User getUserByXuid(String xuid);

    User getUserByEmail(String email);

    int checkIn(String qq);


}
