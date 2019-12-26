package microservices.project.UserMicroservice.Services;

import microservices.project.UserMicroservice.models.request.UserDetailsRequest;
import microservices.project.UserMicroservice.models.response.UserRest;
import microservices.project.UserMicroservice.shared.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

//This class will include all the business logic

@Service
public class UserServiceImp implements UserService {

    private Map<String, UserRest> users;

    private Utils utils;

    public UserServiceImp(){}

    @Autowired
    public UserServiceImp(Utils utils){
        this.utils = utils;
    }

    @Override
    public UserRest createUser(UserDetailsRequest userDetailsRequest) {
        UserRest user = new UserRest();
        user.setFirstName(userDetailsRequest.getFirstName());
        user.setLastName(userDetailsRequest.getLastName());
        user.setEmail(userDetailsRequest.getEmail());
        String userId = utils.generateUserId();
        user.setUserId(userId);
        if (users == null) {
            users = new HashMap<>();
        }
        users.put(userId, user);
        return user;
    }
}
