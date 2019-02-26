package com.platform.dao;

import java.util.List;

import com.platform.entity.ActivityGoodsEntity;
import com.platform.entity.example.ActivityGoodsExample;

/**
 * Dao
 *
 * @author xuyang
 * @email 295640759@qq.com
 * @date 2018-10-29 13:56:24
 */
public interface  ActivityGoodsMapper extends BaseMapper< ActivityGoodsEntity,  ActivityGoodsExample> {

	public List<ActivityGoodsEntity> selectActivityGoods(Integer activityId);
	public List<ActivityGoodsEntity>  selectAllActivityGoods();
	
}
