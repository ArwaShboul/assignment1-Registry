package com.training.usermanagementassignment.adapter.repository;

import com.training.usermanagementassignment.model.User;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
@Component
public class UserRepoImpl implements UserRepository{
    Map<String,User> users=new HashMap<>(){{
       put("1000",new User("1000","Mohammad",20));
       put("1001",new User("1001","Ibrahim",19));
       put("1002",new User("1002","Muna",17));
    }};

    @Override
    public String save(User user) {
         users.put(user.getId(), user);
        return user.getId();
    }

    @Override
    public Optional<User> getById(String userID) {

        return Optional.ofNullable(users.get(userID));
    }

    @Override
    public Optional<User> update(String userId, User newUser) {
        Optional<User> updatedUser = updateUser(userId, newUser);
        return updatedUser;
    }

    @Override
    public Optional<User> delete(String userId) {

        return Optional.ofNullable( users.remove(userId));
    }

    private Optional<User> updateUser(String userId, User newUser) {
        users.get(userId).setName(newUser.getName());
        users.get(userId).setAge(newUser.getAge());
        return  Optional.ofNullable(users.get(userId)) ;
    }


}
