package com.fengze.shop.service;

import com.fengze.shop.common.Response;
import com.fengze.shop.dto.UserDto;
import com.fengze.shop.model.MenuDo;
import com.fengze.shop.model.UserDo;
import com.fengze.shop.vo.UserVo;

/**
 * Created by Administrator on 2017-01-02.
 */
public interface UserService extends BaseService<UserDo> {


    public Response<UserDto> loginUser(UserVo userVo);
}
