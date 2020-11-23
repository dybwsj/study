package com.self.study.dao;

import com.self.study.po.UserResource;

import java.util.List;

/**
 * @author: duyubo
 * @date: 2020年11月20日, 0020 14:05
 * @description:
 */
public interface UserResourceDao {
    /**
     * getResourceListById
     * @param userId
     * @return
     */
    List<UserResource> getResourceListById(Long userId);
    /**
     * listAllResource
     * @return
     */
    List<UserResource> listAllResource();

}
