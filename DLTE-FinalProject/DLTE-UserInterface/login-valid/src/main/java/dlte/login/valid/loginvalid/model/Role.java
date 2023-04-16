package dlte.login.valid.loginvalid.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role {

   private Integer role_id;
   private String role_name;
   private String role_desc;
   private String role_status;
   private Integer branch_id;
   private String username;
   private String password;

}
