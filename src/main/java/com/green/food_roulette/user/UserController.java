package com.green.food_roulette.user;

import com.green.food_roulette.user.model.UserInsDto;
import com.green.food_roulette.user.model.UserIuserDto;
import com.green.food_roulette.user.model.UserVo;
import io.swagger.v3.oas.annotations.Operation;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.zip.ZipException;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class UserController {
    private final UserService service;
    @PostMapping
    @Operation(summary ="유저생성" )
    public UserVo postUser(@RequestBody UserInsDto dto){
        return service.postUser(dto);
    }
    @GetMapping("/{iuser}")
    @Operation(summary = "유저 불러오기")
    public UserVo getUser(@PathVariable Long iuser){
        UserIuserDto dto = new UserIuserDto();
        dto.setIuser(iuser);
        return service.getUser(dto);
    }
}
