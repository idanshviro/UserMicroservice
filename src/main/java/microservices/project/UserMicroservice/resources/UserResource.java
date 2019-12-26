package microservices.project.UserMicroservice.resources;

import microservices.project.UserMicroservice.Services.UserService;
import microservices.project.UserMicroservice.exceptions.UserServiceException;
import microservices.project.UserMicroservice.models.request.UpdateUserDetailsRequest;
import microservices.project.UserMicroservice.models.request.UserDetailsRequest;
import microservices.project.UserMicroservice.models.response.UserRest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserResource {

    Map<String, UserRest> users; //TODO : REMOVE


    @Autowired
    UserService userService;

    @GetMapping(path = "/{userId}",
            produces = {
                    MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_JSON_VALUE
            })
    public ResponseEntity<UserRest> getUser(@PathVariable String userId) {

        if (users.containsKey(userId)) {
            return new ResponseEntity<UserRest>(users.get(userId), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(
            consumes = {
                    MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_JSON_VALUE
            },
            produces = {
                    MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_JSON_VALUE
            })
    public ResponseEntity<UserRest> createUser(@Valid @RequestBody UserDetailsRequest userDetailsRequest) {
        UserRest userRset = userService.createUser(userDetailsRequest);
        return new ResponseEntity<UserRest>(userRset, HttpStatus.OK);
    }

    @PutMapping(path = "/{userId}",
            consumes = {MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_JSON_VALUE
            },
            produces = {MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE
            })
    public ResponseEntity<UserRest> updateUser(@PathVariable String userId, @Valid @RequestBody UpdateUserDetailsRequest updateUserDetailsRequest) {
        UserRest user = users.get(userId);


        if (true) {
            throw new UserServiceException("null poiter exce");
        }


        if (user != null) {
            user.setFirstName(updateUserDetailsRequest.getFirstName());
            user.setLastName(updateUserDetailsRequest.getLastName());
            return new ResponseEntity<UserRest>(user, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }

    @DeleteMapping(path = "/{userId}")
    public void deleteUser(@PathVariable String userId) {
        users.remove(userId);
    }

}
