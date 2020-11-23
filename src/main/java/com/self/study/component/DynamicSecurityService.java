package com.self.study.component;

import org.springframework.security.access.ConfigAttribute;

import java.util.Map;

/**
 * @author: duyubo
 * @date: 2020年11月19日, 0019 15:04
 * @description: 动态权限相关业务类
 */
public interface DynamicSecurityService {

    /**
     * 加载资源ANT通配符和资源对应MAP
     */
    Map<String, ConfigAttribute> loadDataSource();
}
