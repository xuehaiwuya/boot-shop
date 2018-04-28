package com.studyinghome.bootshop.web.superadmin;

import com.studyinghome.bootshop.dto.PersonInfoExecution;
import com.studyinghome.bootshop.entity.ConstantForSuperAdmin;
import com.studyinghome.bootshop.entity.PersonInfo;
import com.studyinghome.bootshop.enums.PersonInfoStateEnum;
import com.studyinghome.bootshop.service.PersonInfoService;
import com.studyinghome.bootshop.util.HttpServletRequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/superadmin")
public class PersonInfoController {
    @Autowired
    private PersonInfoService personInfoService;

    @PostMapping("/listpersonInfos")
    private Map<String, Object> listPersonInfos(HttpServletRequest request) {
        Map<String, Object> modelMap = new HashMap<>();
        PersonInfoExecution personInfos = null;
        int pageIndex = HttpServletRequestUtil.getInt(request, ConstantForSuperAdmin.PAGE_NO);
        int pageSize = HttpServletRequestUtil.getInt(request, ConstantForSuperAdmin.PAGE_SIZE);
        if (pageIndex > 0 && pageSize > 0) {
            try {
                PersonInfo personInfo = new PersonInfo();
                int enableStatus = HttpServletRequestUtil.getInt(request, "enableStatus");
                if (enableStatus > -1) {
                    personInfo.setEnableStatus(enableStatus);
                }
                String name = HttpServletRequestUtil.getString(request, "name");
                if (name != null) {
                    personInfo.setName(URLDecoder.decode(name, "UTF-8"));
                }
                personInfos = personInfoService.getPersonInfoList(personInfo, pageIndex, pageSize);
            } catch (Exception e) {
                modelMap.put("success", false);
                modelMap.put("errMsg", e.toString());
                return modelMap;
            }
            if (personInfos.getPersonInfoList() != null) {
                modelMap.put(ConstantForSuperAdmin.PAGE_SIZE, personInfos.getPersonInfoList());
                modelMap.put(ConstantForSuperAdmin.TOTAL, personInfos.getCount());
                modelMap.put("success", true);
            } else {
                modelMap.put(ConstantForSuperAdmin.PAGE_SIZE, new ArrayList<PersonInfo>());
                modelMap.put(ConstantForSuperAdmin.TOTAL, 0);
                modelMap.put("success", true);
            }
            return modelMap;
        } else {
            modelMap.put("success", false);
            modelMap.put("errMsg", "空的查询信息");
            return modelMap;
        }
    }

    @PostMapping("/modifypersonInfo")
    private Map<String, Object> modifyPersonInfo(HttpServletRequest request) {
        Map<String, Object> modelMap = new HashMap<>();
        long userId = HttpServletRequestUtil.getLong(request, "userId");
        int enableStatus = HttpServletRequestUtil.getInt(request, "enableStatus");
        if (userId > 0 && enableStatus > 0) {
            try {
                PersonInfo pi = new PersonInfo();
                pi.setUserId(userId);
                pi.setEnableStatus(enableStatus);
                PersonInfoExecution ae = personInfoService.modifyPersonInfo(pi);
                if (ae.getState() == PersonInfoStateEnum.SUCCESS.getState()) {
                    modelMap.put("success", true);
                } else {
                    modelMap.put("success", false);
                    modelMap.put("errMsg", ae.getStateInfo());
                }
            } catch (RuntimeException e) {
                modelMap.put("success", false);
                modelMap.put("errMsg", e.toString());
                return modelMap;
            }
        } else {
            modelMap.put("success", false);
            modelMap.put("errMsg", "请输入需要修改的帐号信息");
        }
        return modelMap;
    }
}
