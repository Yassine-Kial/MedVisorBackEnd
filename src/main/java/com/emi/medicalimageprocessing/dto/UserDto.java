package com.emi.medicalimageprocessing.dto;

import com.emi.medicalimageprocessing.model.User;
import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class UserDto {
    private Integer id;
    private String username;
    private String password;
    private String fullName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public static UserDto fromEntity (User user){
        if (user ==null) {
            return null;
        }
        return UserDto.builder()
                .id(user.getId())
                .fullName(user.getFullName())
                .password(user.getPassword())
                .username(user.getUsername())
                .build();
    }

    public static User toEntity (UserDto userDto){
        if (userDto ==null) {
            return null;
        }
        User user=new User();
        user.setId(userDto.getId());
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setFullName(userDto.getFullName());
        return user;
    }


}
