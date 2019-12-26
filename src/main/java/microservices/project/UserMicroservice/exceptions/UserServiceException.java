package microservices.project.UserMicroservice.exceptions;

public class UserServiceException extends RuntimeException{

    public UserServiceException(String message) {
        super(message);
    }
}
