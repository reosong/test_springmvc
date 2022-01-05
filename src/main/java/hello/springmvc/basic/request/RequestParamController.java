package hello.springmvc.basic.request;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@Slf4j
@Controller
public class RequestParamController {

    @RequestMapping("/request-param-v1")
    public void requestParamV1(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));

        log.info("username ={}, age={} ", username, age);
        response.getWriter().write("ok");

    }

    @ResponseBody
    @RequestMapping("/request-param-v2")
    public String requestParmaV2(
        @RequestParam("username") String memberName,
        @RequestParam("age") int memberAge ) {

        log.info("username ={}, age={} ", memberName, memberAge);
        return "ok";
    }


    @ResponseBody
    @RequestMapping("/request-param-v3")
    public String requestParmaV3(
            @RequestParam String username,
            @RequestParam int age ) {

        log.info("username ={}, age={} ", username, age);
        return "ok";
    }


    @ResponseBody
    @RequestMapping("/request-param-v4")
    public String requestParmaV4(String username, int age ) {
        log.info("username ={}, age={} ", username, age);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-required")
    public String requestParmaRequired(@RequestParam(required = false) String username,
                                       @RequestParam(required = false) int age ) {
        log.info("username ={}, age={} ", username, age);
        return "ok";
    }
    @ResponseBody
    @RequestMapping("/request-param-map")
    public String requestParamMap(@RequestParam Map<String ,Object> map) {
        log.info("username ={}, age={} ",map.get("username"), map.get("age"));
        return "ok";
    }

}
