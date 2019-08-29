package com.example.tasklist.controller;


import com.example.tasklist.model.User;
import com.example.tasklist.service.UserService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Transactional
@CrossOrigin(origins = "*")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //create Session Factory
    SessionFactory factory = new Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(User.class)
            .buildSessionFactory();

    

    @GetMapping("/users")
    public List<User> getUserList(){
        return userService.findAll();
    }

    @PostMapping("/user")
    public User postUser(@Valid @RequestBody User user){

        System.out.println("girdim");
        userService.save(user);
        return user;

    }

    @GetMapping("/user/{name}")
    public List<User> login(@PathVariable String name){
        //create Session
        Session session = factory.getCurrentSession();


        session.beginTransaction();
        //session.setCacheMode(CacheMode.REFRESH);

        //User tempUser = userService.findByUsername(name);

        System.out.println("girdim");

        String hql = "SELECT * FROM register WHERE username= :name ";

        Query query = session.createSQLQuery(hql).setParameter("name" , name);

        List<User> users = query.getResultList();
        //System.out.println(users);


        session.getTransaction().commit();

        return users;

    }
}
