package pers.qjw.admin.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.qjw.admin.service.TokenService;

@RestController
@RequestMapping("/api/token")
@AllArgsConstructor
@Api(tags = "token 接口")
public class TokenController {

    private final TokenService tokenService;

    @PostMapping
    @ApiOperation("创建token")
    public ResponseEntity<String> createToken(String name, String password) {
        return new ResponseEntity<>(tokenService.createToken(name,password), HttpStatus.OK);
    }

}
