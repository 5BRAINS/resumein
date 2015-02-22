package ua.dou.hack;

import ua.dou.hack.domain.User;

/**
 * mocker on 22.02.15 at 6:40.
 */
public class UserDto {
    private String name;
    private String lastName;

    public UserDto(User user) {
        this.name = user.getName();
        this.lastName = user.getLastName();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
