package microservices.project.UserMicroservice.models.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UpdateUserDetailsRequest {

    @NotNull(message = "First name can't be null")
    private String firstName;

    @NotNull(message = "Last name can't be null")
    private String lastName;

}
