package com.yc.jpa.service.impl;

import com.yc.jpa.dao.UserRepository;
import com.yc.jpa.model.User;
import com.yc.jpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findById(Long id) {
        Optional<User> optional = userRepository.findById(id);
        if(optional.isPresent())
            return optional.get();
        return null;
    }

    @Override
    public List<User> findAll() {
        List<User> all = userRepository.findAll();
        return all;

    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
