package com.self.study.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: duyubo
 * @date: 2020年11月19日, 0019 15:05
 * @description:
 */

@Data
@ConfigurationProperties(prefix = "secure.ignored")
@EnableConfigurationProperties(IgnoreUrlsConfig.class)
public class IgnoreUrlsConfig {
    private List<String> urls = new ArrayList<>();

}
