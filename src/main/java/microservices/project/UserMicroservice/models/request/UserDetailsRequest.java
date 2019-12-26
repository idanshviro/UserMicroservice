package microservices.project.UserMicroservice.models.request;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class UserDetailsRequest {

    @NotNull(message = "First name can't be null")
    private String firstName;

    @NotNull(message = "Last name can't be null")
    private String lastName;

    @NotNull(message = "email can't be null")
    @Email
    private String email;

    @NotNull
    @Size(min=8,max=16, message = "password must be equal or grater than 8 characters and less than 16 characters")
    private String password;
}
