package lesson6.api.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

@SuppressWarnings("unused")
public class UserDto {
    @Null
    private Long id;
    @NotNull
    private String name;

    @NotNull
    private String login;

    @NotNull
    private String password;

    @NotNull
    @Email
    private String email;


    public UserDto(){}

    public UserDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
