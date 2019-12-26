package microservices.project.UserMicroservice.Services;

import microservices.project.UserMicroservice.models.request.UserDetailsRequest;
import microservices.project.UserMicroservice.models.response.UserRest;

public interface UserService {
    UserRest createUser(UserDetailsRequest userDetailsRequest);
}
