package com.example.sem3HomeTask.services;

import com.example.sem3HomeTask.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {


    public DataProcessingService getDataProcessingService() {
        return dataProcessingService;
    }

    @Autowired
    private DataProcessingService dataProcessingService;

    //Поля UserService, NotificationService
    private final UserService userService;
    private final NotificationService notificationService;

    //Конструктор
    public RegistrationService(UserService userService, NotificationService notificationService) {
        this.userService = userService;
        this.notificationService = notificationService;
    }


    //Метод processRegistration
    public void processRegistration(String userName, int age, String email) {
       //User user = new User(userName, age, email);
       // userService.save(user);
        userService.createUser(userName, age, email);
        notificationService.sendNotification("Пользователь " + userName + " успешно зарегистрирован!");
    }

}
