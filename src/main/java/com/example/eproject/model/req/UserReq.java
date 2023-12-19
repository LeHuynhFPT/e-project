package com.example.eproject.model.req;

import com.example.eproject.entity.Gif;
import com.example.eproject.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserReq {

    @NotNull(message = "Name is required")
    @NotEmpty(message = "Name is required")
    private String name;

    @NotNull(message = "Email is required")
    @NotEmpty(message = "Email is required")
    @Email(message = "Please provide a valid email")
    private String email;

    @NotNull(message = "Password is required")
    @NotEmpty(message = "Password is required")
    @Size(min = 4, max = 20, message = "Pasword must be between 4 and 20 characters")
    private String password;

    @NotNull(message = "Telephone is required")
    @NotEmpty(message = "Telephone is required")
    private String tel;

    @NotNull(message = "Address is required")
    @NotEmpty(message = "Address is required")
    private String address;

    @NotNull(message = "Birthday is required")
    @NotEmpty(message = "Birthday is required")
    private Date birthday;

    @NotNull(message = "Type is required")
    @NotEmpty(message = "Type is required")
    private String type;

    private Integer status;

    private Set<Role> roles;

    private List<Gif> gifs;
}
