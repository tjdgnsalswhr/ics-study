package com.springboot.api.controller;

import com.springboot.api.data.dto.MemberDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/get-api")
public class GetController {

    // 예제 5.26
    private final Logger LOGGER = LoggerFactory.getLogger(GetController.class);

    // 예제 5.2
    // RequestMapping을 사용한 메서드 구현, 스프링 4.3 이후로는 사용하지 않음
    // http://localhost:8080/api/v1/get-api/hello
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String getHello() {
        // 예제 5.27
        LOGGER.info("getHello 메소드가 호출되었습니다.");
        return "Hello World";
    }

    // 예제 5.3
    // 매개변수가 없는 경우의 GetMapping, 하지만 실무에서는 매개변수 없는 매핑은 거의 없음
    // http://localhost:8080/api/v1/get-api/name
    @GetMapping(value = "/name")
    public String getName() {
        // 예제 5.27
        LOGGER.info("getName 메소드가 호출되었습니다.");
        return "Flature";
    }

    // 예제 5.4
    // PathVariable을 사용한 GetMapping, Value 내에 괄호친 매개변수가 PathVariable 어노테이션 안의 값과 매핑됨, 둘은 변수 명이 일치해야함
    // http://localhost:8080/api/v1/get-api/variable1/{String 값}
    @GetMapping(value = "/variable1/{variable}")
    public String getVariable1(@PathVariable String variable) {
        // 예제 5.28
        LOGGER.info("@PathVariable을 통해 들어온 값 : {}", variable);
        return variable;
    }

    // 예제 5.5
    // PathVariable과 GetMapping에서 명시된 매개변수 명이 서로 일치하지 않을 때 매핑 시키는 방법
    // http://localhost:8080/api/v1/get-api/variable2/{String 값}
    @GetMapping(value = "/variable2/{variable}")
    public String getVariable2(@PathVariable("variable") String var) {
        return var;
    }

    // 예제 5.6, 예제 5.23
    // 쿼리형식으로 달하는 GetMapping, @RequestParam으로 넘어온 값과 매핑시킴
    // http://localhost:8080/api/v1/get-api/request2?name=flature&email=thinkground.flature@gmail.com&organization=thinkground
    @Operation(summary = "GET 메소드 예제", description = "@RequestParam을 활용한 GET Method")
    @GetMapping(value = "/request1")
    public String getRequestParam1(
            @Parameter(name = "이름", required = true) @RequestParam String name,
            @Parameter(name = "이메일", required = true) @RequestParam String email,
            @Parameter(name = "회사", required = true) @RequestParam String organization) {
        return name + " " + email + " " + organization;
    }

    // 예제 5.7
    // http://localhost:8080/api/v1/get-api/request2?key1=value1&key2=value2
    // 어떠한 값이 들어올지 모를때, 즉 선택 매개변수가 있을 때 적절하다. ==> ICAS의 경우에 어떠한 값으로 조회할지 모르므로 이 방법 적절?
    @GetMapping(value = "/request2")
    public String getRequestParam2(@RequestParam Map<String, String> param) {
        StringBuilder sb = new StringBuilder();

        param.entrySet().forEach(map -> {
            sb.append(map.getKey() + " : " + map.getValue() + "\n");
        });

        return sb.toString();
    }

    // 예제 5.9
    // http://localhost:8080/api/v1/get-api/request3?name=value1&email=value2&organization=value3
    // DTO를 활용하여 주고 받는 예제, 사실상 ICAS 에서 제일 어울림, DTO 클래스에 선언된 필드는 컨트롤러의 메서드에 파라미터 키와 매핑됨
    @GetMapping(value = "/request3")
    public String getRequestParam3(MemberDto memberDTO) {
        return memberDTO.toString();
    }

}
