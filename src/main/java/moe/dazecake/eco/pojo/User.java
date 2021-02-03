package moe.dazecake.eco.pojo;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private String name;
    private String qq;
    private String xuid;
    private String email;
    private Long money;
    private Date time;
    private String token;

}
