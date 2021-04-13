package pers.qjw.admin.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.qjw.admin.annotations.Authorization;
import pers.qjw.admin.annotations.CurrentUser;
import pers.qjw.admin.model.BlogUser;

import java.util.Objects;

@RestController
@RequestMapping("/api/currentUser")
@Api(tags = "user 接口")
public class UserController {

    @GetMapping("/state")
    @ApiOperation("获取用户的登录状态")
    public ResponseEntity<Boolean> getUserStatus(@CurrentUser BlogUser currentUser){
        if (Objects.isNull(currentUser)) {
            return new ResponseEntity<>(false, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(true, HttpStatus.OK);
        }
    }

    @GetMapping
    @Authorization
    @ApiOperation("获取用户信息")
    public ResponseEntity<BlogUser> getUser(@CurrentUser BlogUser currentUser){
        return new ResponseEntity<>(currentUser, HttpStatus.OK);
    }

}
