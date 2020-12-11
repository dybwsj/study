package com.self.study.service.impl;

import com.alibaba.fastjson.JSON;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.self.study.service.SmsService;
import com.self.study.utils.AssertUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author: duyubo
 * @date: 2020年11月26日, 0026 15:40
 * @description:
 */

@Service
//@DubboService(interfaceClass = SmsService.class, version = "1.0.0")
@Slf4j
public class SmsServiceImpl implements SmsService {
    @Value("${aliyun.accessKeyID}")
    private String accessKeyID;
    @Value("${aliyun.accessKeySecret}")
    private String accessKeySecret;
    @Value("${aliyun.signName}")
    private String signName;
    @Value("${aliyun.templateCode}")
    private String templateCode;

    @Value("${sendSms.codeExpiration}")
    private Long codeExpiration;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public boolean sendMessage(String phone) {

        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyID, accessKeySecret);
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        request.setSysMethod(MethodType.POST);
        request.setSysDomain("dysmsapi.aliyuncs.com");
        request.setSysVersion("2017-05-25");
        request.setSysAction("SendSms");
        request.putQueryParameter("SignName", signName);
        request.putQueryParameter("PhoneNumbers", phone);
        request.putQueryParameter("TemplateCode", templateCode);

        Map<String, String> params = new HashMap<>();
        String code;
        if ((code = redisTemplate.opsForValue().get(phone)) == null) {
            code = String.valueOf(Math.random()).substring(3, 9);
            redisTemplate.opsForValue().set(phone, code, codeExpiration, TimeUnit.SECONDS);
        }
        params.put("code", code);
        request.putQueryParameter("TemplateParam", JSON.toJSONString(params));
        try {
            CommonResponse response = client.getCommonResponse(request);
            Map resultMap = JSON.parseObject(response.getData(), Map.class);
            log.info(resultMap.toString());
            AssertUtil.isEqual(resultMap.get("Code").toString(), "OK", resultMap.get("Message").toString());
            return true;
        } catch (ClientException e) {
            log.error(e.getErrMsg());
            e.printStackTrace();
        }
        return false;
    }
}
