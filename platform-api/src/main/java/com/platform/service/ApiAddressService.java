package com.platform.service;

import com.platform.dao.ApiAddressMapper;
import com.platform.entity.AddressVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class ApiAddressService {
    @Autowired
    private ApiAddressMapper addressDao;


    public AddressVo queryObject(Integer id) {
        return addressDao.queryObject(id);
    }


    public List<AddressVo> queryList(Map<String, Object> map) {
        return addressDao.queryList(map);
    }


    public int queryTotal(Map<String, Object> map) {
        return addressDao.queryTotal(map);
    }


    public void save(AddressVo address) {
    	updateIsDefault(address);
        addressDao.save(address);
    }


    public void update(AddressVo address) {
    	updateIsDefault(address);
        addressDao.update(address);
    }
    private void updateIsDefault(AddressVo address) {
    	 if(address.getIs_default()!=null&&address.getIs_default()==1) {
    		 addressDao.updateIsDefault(address.getUserId());
         }
    }


    public void delete(Integer id) {
        addressDao.delete(id);
    }


    public void deleteBatch(Integer[] ids) {
        addressDao.deleteBatch(ids);
    }

}
