package springbootajax;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class SearchCriteria {

    @NotEmpty(message = "username can't empty!")
    @Size(min=5,max=50)
    String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}