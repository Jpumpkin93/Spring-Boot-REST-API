//package com.example.jungho.controller;
//
//
//import com.example.jungho.advice.exception.CEmailSigninFailedException;
//import com.example.jungho.config.security.JwtTokenProvider;
//import com.example.jungho.domain.TestForm;
//import com.example.jungho.domain.User;
//import com.example.jungho.model.response.CommonResult;
//import com.example.jungho.model.response.SingleResult;
//import com.example.jungho.repo.UserJpaRepo;
//import com.example.jungho.service.ResponseService;
//import io.swagger.annotations.ApiOperation;
//import io.swagger.annotations.ApiParam;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Collections;
//import java.util.Map;
//
//@Controller
//public class LoginController {
//
////    @Autowired
////    UserJpaRepo userJpaRepo;
//    @Autowired
//    private JwtTokenProvider jwtTokenProvider;
//    @Autowired
//    private ResponseService responseService;
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    @GetMapping("/login")
//    public String login(){
//        return "login";
//    }
//
//    @ApiOperation(value = "로그인", notes = "이메일 회원 로그인을 한다.")
//    @PostMapping(value = "/loginCheck")
//    @ResponseBody
//    public SingleResult<String> loginCheck(@RequestBody Map<String, String> map) {
//
//        String id = map.get("id");
//        String password = map.get("password");
//
//        User user = userJpaRepo.findByUid(id).orElseThrow(CEmailSigninFailedException::new);
//        if (!passwordEncoder.matches(password, user.getPassword()))
//            throw new CEmailSigninFailedException();
//
//        return responseService.getSingleResult(jwtTokenProvider.createToken(user.getUsername(), user.getRoles()));
//    }
//
//    @GetMapping("/signUp")
//    public String signup(){
//        return "signUp";
//    }
//
//    @ApiOperation(value = "가입", notes = "회원가입을 한다.")
//    @RequestMapping(value = "/signUpCheck", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
//    @ResponseBody
//    public CommonResult signup(@RequestBody Map<String, String> map) {
//        String id = map.get("id");
//        String password = map.get("password");
//        String name = map.get("name");
//
//
////        CommonResult
//        userJpaRepo.save(User.builder()
//                .uid(id)
//                .password(passwordEncoder.encode(password))
//                .name(name)
//                .roles(Collections.singletonList("ROLE_USER"))
//                .build());
//        return responseService.getSuccessResult();
//    }
//}
