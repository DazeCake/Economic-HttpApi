package moe.dazecake.eco.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RUser {
    private String name;
    private String qq;
    private String xuid;
    private String email;
    private Long money;
    private Date time;
    private String token;
    private Integer code;

    public RUser(User user, Integer code) {
        this.name = user.getName();
        this.qq = user.getQq();
        this.xuid = user.getXuid();
        this.email = user.getEmail();
        this.money = user.getMoney();
        this.time = user.getTime();
        this.code = code;
    }
}
