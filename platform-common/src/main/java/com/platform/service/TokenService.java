package com.platform.service;

import com.platform.dao.ApiTokenMapper;
import com.platform.entity.TokenEntity;
import com.platform.utils.CharUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@Service
public class TokenService {
    @Autowired
    private ApiTokenMapper tokenDao;
    //12小时后过期
    private final static int EXPIRE = 3600 * 12;

    public TokenEntity queryByUserId(Long userId,Integer type) {
        return tokenDao.queryByUserId(userId,type);
        
        
    } 

    public TokenEntity queryByToken(String token) {
        return tokenDao.queryByToken(token);
    }

    public void save(TokenEntity token) {
    	Map<String,Object> params=new HashMap();
    	params.put("token", token.getToken());
    	tokenDao.delete(params);
        tokenDao.save(token);
    }

    public void update(TokenEntity token) {
        tokenDao.update(token);
    }

    public Map<String, Object> createToken(long userId,Integer type) {
    	//type 0 小程序 1 公众号
        //生成一个token
        String token = CharUtil.getRandomString(32);
        //当前时间
        Date now = new Date();

        //过期时间
        Date expireTime = new Date(now.getTime() + EXPIRE * 1000);
        System.out.println("begin create token");
        //判断是否生成过token
        TokenEntity tokenEntity = queryByUserId(userId,type);
        if (tokenEntity == null) {
            tokenEntity = new TokenEntity();
            tokenEntity.setUserId(userId);
            tokenEntity.setToken(token);
            tokenEntity.setUpdateTime(now);
            tokenEntity.setExpireTime(expireTime);
            tokenEntity.setType(type);
            //保存token
            save(tokenEntity);
        } else {
            tokenEntity.setToken(token);
            tokenEntity.setUpdateTime(now);
            tokenEntity.setExpireTime(expireTime);
            
           
            update(tokenEntity);
        }

        
        Map<String, Object> map = new HashMap<>();
        map.put("token", token);
        map.put("expire", EXPIRE);

        return map;
    }
}
