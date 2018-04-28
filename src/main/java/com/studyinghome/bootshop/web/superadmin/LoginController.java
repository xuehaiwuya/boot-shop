package com.studyinghome.bootshop.web.superadmin;

import com.studyinghome.bootshop.entity.LocalAuth;
import com.studyinghome.bootshop.service.LocalAuthService;
import com.studyinghome.bootshop.util.HttpServletRequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/superadmin")
public class LoginController {
    @Autowired
    private LocalAuthService localAuthService;

    @PostMapping("/logincheck")
    private Map<String, Object> loginCheck(HttpServletRequest request) {
        Map<String, Object> modelMap = new HashMap<>();
        String userName = HttpServletRequestUtil.getString(request, "userName");
        String password = HttpServletRequestUtil.getString(request, "password");
        if (userName != null && password != null) {
//			password = MD5.getMd5(password);
            LocalAuth localAuth = localAuthService.getLocalAuthByUserNameAndPwd(userName, password);
            if (localAuth != null) {
                if (localAuth.getPersonInfo().getAdminFlag() == 1) {
                    modelMap.put("success", true);
                    request.getSession().setAttribute("user", localAuth.getPersonInfo());
                } else {
                    modelMap.put("success", false);
                    modelMap.put("errMsg", "非管理员没有权限访问");
                }
            } else {
                modelMap.put("success", false);
                modelMap.put("errMsg", "用户名或密码错误");
            }
        } else {
            modelMap.put("success", false);
            modelMap.put("errMsg", "用户名和密码均不能为空");
        }
        return modelMap;
    }
}
