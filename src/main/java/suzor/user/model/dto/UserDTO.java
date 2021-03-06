package suzor.user.model.dto;

import java.io.Serializable;

public class UserDTO implements Serializable {
    /**
     * 用户ID
     */
    private String userId;
    /**
     * 用户名
     */
    private String username;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "userId='" + userId + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
