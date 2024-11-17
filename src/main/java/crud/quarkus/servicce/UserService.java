package crud.quarkus.servicce;

import crud.quarkus.entity.UserEntity;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class UserService {

    public UserEntity createUser(UserEntity userEntity) {
        UserEntity.persist(userEntity);
        return userEntity;
    }

    public List<UserEntity> findAll(Integer page, Integer pagesize) {
        return UserEntity.findAll().page(page, pagesize).list();
    }
}
