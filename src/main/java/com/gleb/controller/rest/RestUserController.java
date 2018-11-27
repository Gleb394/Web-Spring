package com.gleb.controller.rest;

import com.gleb.controller.constrain.model.UserDto;
import com.gleb.serves.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class RestUserController {

    @Autowired
    private UserServices userServices;

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(path = "/user", method = RequestMethod.GET)
    public ResponseEntity<UserDto> getByEmail(@RequestParam String email) {
        return userServices.getUserByEmail(email)
                .map(UserDto::of)
                .map(ResponseEntity::ok)
                .orElseGet(ResponseEntity.notFound()::build);
    }
}