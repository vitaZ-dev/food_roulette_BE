package com.green.food_roulette.user;

import com.green.food_roulette.user.model.UserInsDto;
import com.green.food_roulette.user.model.UserVo;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class UserController {
    private final UserService service;
    @PostMapping
    @Operation(summary ="유저생성" )
    public UserVo postUser(@RequestBody UserInsDto dto) {
        return service.postUser(dto);
    }
}
