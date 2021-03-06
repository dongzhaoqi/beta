package com.dong.beta.controller;

import com.dong.beta.annotation.ControllerWebLog;
import com.dong.beta.config.ArticleConfig;
import com.dong.beta.controller.domain.Users;
import com.dong.beta.controller.vo.ResponseModel;
import com.dong.beta.entity.DataListDTO;
import com.dong.beta.service.impl.UserService;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    ArticleConfig articleConfig;

    @RequestMapping("/test")
    public void test(){
        System.out.println(articleConfig);
    }

    @RequestMapping("/query")
    public ResponseModel<List<Users>> query(@Param("username") String username) {
        List<Users> list = userService.selectUserByName(username);
        DataListDTO dataListDTO = new DataListDTO();
        dataListDTO.setDataList(list);
        dataListDTO.setSize(list.size());
        return ResponseModel.successResponse(dataListDTO);
    }

    @RequestMapping("/deleteByUserName")
    @ControllerWebLog(name = "删除用户", intoDb = true)
    public ResponseModel<String> testDelete(@RequestParam("username") String username) {
        userService.deleteService(username);
        return ResponseModel.successResponse(String.format("%s删除成功", username));
    }

    @RequestMapping("/updateByUserName")
    @ControllerWebLog(name = "更新用户", intoDb = true)
    public ResponseModel<Users> update(@RequestBody Users users){
        DataListDTO dataListDTO = new DataListDTO();
        dataListDTO.setDataList(userService.updateByUserName(users));
        return ResponseModel.successResponse(dataListDTO);
    }
}