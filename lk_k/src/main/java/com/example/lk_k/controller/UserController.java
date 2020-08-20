package com.example.lk_k.controller;


import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.example.lk_k.common.lang.Result;
import com.example.lk_k.common.lang.dto.LoginDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author write by zjy
 * @since 2020-07-22
 */
@RestController
public class UserController {
    @PostMapping(value = "/index")
    public Result Toindex2(@RequestBody(required = false) LoginDto loginDto){
        System.out.println("kt");
        System.out.println("username:"+loginDto.getUsername());
        System.out.println("password:"+loginDto.getPassword());
        return Result.succ("username:");
    }
}
