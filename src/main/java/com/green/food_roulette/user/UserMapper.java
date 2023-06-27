package com.green.food_roulette.user;

import com.green.food_roulette.user.model.UserEntity;
import com.green.food_roulette.user.model.UserInsDto;
import com.green.food_roulette.user.model.UserVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
   Long insUser(UserEntity entity);
    UserVo findUser(UserEntity entity);

}
