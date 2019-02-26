package com.platform.dao;

import java.util.List;

import com.platform.entity.GoodsEntity;

/**
 * Dao
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2017-08-21 21:19:49
 */
public interface GoodsDao extends BaseDao<GoodsEntity> {
    Integer queryMaxId();
    List<GoodsEntity> queryAll();
}
