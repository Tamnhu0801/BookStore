package com.hcmute.bookstore.dtos.user;

import com.hcmute.bookstore.entities.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserResDto {
    private Long id;
    private String email;
    private String password;
    private String username;
    private String fullname;
    private boolean enabled;
    private Set<Role> roles;
//    @JsonProperty("username")
//    private String username;
//
//    @JsonProperty("password")
//    private String password;
//
//    @JsonProperty("fullname")
//    private String fullname;
//
//    @JsonProperty("email")
//    private String email;
//
//    @JsonProperty("phone")
//    private String phone;
//
//    @JsonProperty("address")
//    private String address;
//
//    @JsonProperty("enabled")
//    private boolean enabled = true;
//
//    @JsonProperty("roles")
//    private Set<Role> role;
//
//    public UserResDto() {
//        super();
//    }
//
//    public UserResDto(String username, String password, String fullname, String email, String phone, String address, boolean enabled, Set<Role> role) {
//        this.username = username;
//        this.password = password;
//        this.fullname = fullname;
//        this.email = email;
//        this.phone = phone;
//        this.address = address;
//        this.enabled = enabled;
//        this.role = role;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public String getFullname() {
//        return fullname;
//    }
//
//    public void setFullname(String fullname) {
//        this.fullname = fullname;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getPhone() {
//        return phone;
//    }
//
//    public void setPhone(String phone) {
//        this.phone = phone;
//    }
//
//    public String getAddress() {
//        return address;
//    }
//
//    public void setAddress(String address) {
//        this.address = address;
//    }
//
//    public boolean isEnabled() {
//        return enabled;
//    }
//
//    public void setEnabled(boolean enabled) {
//        this.enabled = enabled;
//    }
//
//    public Set<Role> getRole() {
//        return role;
//    }
//
//    public void setRole(Set<Role> role) {
//        this.role = role;
//    }
}
