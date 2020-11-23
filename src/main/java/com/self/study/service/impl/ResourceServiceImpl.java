package com.self.study.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.google.common.collect.Lists;
import com.self.study.po.UserResource;
import com.self.study.dao.UserResourceDao;
import com.self.study.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: duyubo
 * @date: 2020年11月19日, 0019 15:43
 * @description:
 */

@Service
public class ResourceServiceImpl implements ResourceService {
    @Autowired
    private UserResourceDao userResourceDao;

    @Override
    public List<UserResource> listAllResource() {

        List<UserResource> resources = userResourceDao.listAllResource();
        if (CollectionUtil.isNotEmpty(resources)) {
            return userResourceDao.listAllResource();
        }
        return Lists.newArrayList();
    }
}
