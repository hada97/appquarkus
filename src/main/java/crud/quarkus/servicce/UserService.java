package crud.quarkus.servicce;

import crud.quarkus.entity.UserEntity;
import crud.quarkus.exception.UserNotFoundException;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class UserService {


    public UserEntity createUser(UserEntity userEntity) {
        UserEntity.persist(userEntity);
        return userEntity;
    }

    public List<UserEntity> findAll(Integer page, Integer pagesize) {
        return UserEntity.findAll().page(page, pagesize).list();
    }

    public static UserEntity findById(UUID userId) {
        return (UserEntity) UserEntity.findByIdOptional(userId).orElseThrow(UserNotFoundException::new);
    }


    public UserEntity updateUser(UUID userId, UserEntity userEntity) {
        var user = findById(userId);
        user.username = userEntity.username;
        UserEntity.persist(user);
        return user;
    }


    public void deleteById(UUID userId, UserEntity userEntity) {
        var user = findById(userId);
        UserEntity.deleteById(user.userId);
    }
}
