package com.platform.dao;

import com.platform.entity.CommentVo;
import com.platform.entity.GroupCountVo;

import java.util.List;
import java.util.Map;

/**
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2017-08-11 09:14:26
 */
public interface ApiCommentMapper extends BaseDao<CommentVo> {
    int queryhasPicTotal(Map<String, Object> map);
    List<GroupCountVo>  queryGroupCount(Map<String, Object> map);
}
