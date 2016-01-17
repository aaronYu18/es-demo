package com.badun.elsearchdemo.web;

import com.badun.elsearchdemo.data.entity.UserAction;
import com.badun.elsearchdemo.service.UserActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Artsiom Badun.
 */
@RestController
@RequestMapping("/v1")
public class ApiController {

    @Autowired
    private UserActionService userActionService;

    @RequestMapping(value = "user", method = RequestMethod.GET)
    UserAction findUserAction(@RequestParam String actionId) {
        return userActionService.findUserAction(actionId);
    }

    @RequestMapping(value = "user", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    UserAction createUserAction(@RequestBody UserAction userAction) {
        return userActionService.createUserAction(userAction);
    }
}
