package com.hcmute.bookstore.dtos.user;

import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserReqDto {

    private Long id;
    private String email;
    private String password;
    private String username;
    private String fullname;
    private boolean enabled;
    private Set<Integer> roleIds;

}
