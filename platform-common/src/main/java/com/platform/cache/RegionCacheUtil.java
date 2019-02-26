package com.platform.cache;

import com.platform.dao.SysRegionDao;
import com.platform.entity.MyRegion;
import com.platform.entity.SysRegionEntity;
import com.platform.utils.SpringContextUtils;
import org.springframework.beans.factory.InitializingBean;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2017-11-04 11:19:31
 */
public class RegionCacheUtil implements InitializingBean {

    public static List<SysRegionEntity> sysRegionEntityList;
    public static List<MyRegion> myRegionList;
    public static List<MyRegion> myRegionLevelList;
    public static Map<Integer ,MyRegion > regionMap=new HashMap();
    public static void init() {
        SysRegionDao regionDao = SpringContextUtils.getBean(SysRegionDao.class);
        myRegionList=new ArrayList();
        myRegionLevelList=new ArrayList();
       
        if (null != regionDao) {
        	
            sysRegionEntityList = regionDao.queryList(new HashMap<String, Object>());
            for(SysRegionEntity sysRegionEntity:sysRegionEntityList) {
            	MyRegion myRegion=new MyRegion();
            	myRegion.setId(sysRegionEntity.getId());
            	myRegion.setName(sysRegionEntity.getName());
            	myRegion.setPid(sysRegionEntity.getParentId());
            	myRegion.setType(sysRegionEntity.getType());
            	myRegion.setChildList(new ArrayList());
            	
            	MyRegion myRegion2=new MyRegion();
            	myRegion2.setId(sysRegionEntity.getId());
            	myRegion2.setName(sysRegionEntity.getName());
            	myRegion2.setPid(sysRegionEntity.getParentId());
            	myRegion2.setType(sysRegionEntity.getType());
            	
            	
            	
            	myRegionList.add(myRegion2);
            	MyRegion pmyRegion=regionMap.get(sysRegionEntity.getParentId());
            	if(pmyRegion!=null) {
            		pmyRegion.getChildList().add(myRegion);
            	}else {
            		pmyRegion=new MyRegion();
            		pmyRegion.setId(sysRegionEntity.getParentId());
            		pmyRegion.setChildList(new ArrayList());
            		regionMap.put(pmyRegion.getId(), pmyRegion);
            	}
            	MyRegion tmpmyRegion=regionMap.get(sysRegionEntity.getId());
            	if(tmpmyRegion==null) {
            		regionMap.put(myRegion.getId(), myRegion);
            	}else {
            		myRegion.setChildList(tmpmyRegion.getChildList());
            		regionMap.put(myRegion.getId(), myRegion);
            	}
            	
            }
           
            Collection<MyRegion> collection= regionMap.values();
            for(MyRegion myRegion:collection) {
            	if(myRegion.getType()!=null&&myRegion.getType().equals(1)) {
            		myRegionLevelList.add(myRegion);
            	}
            }
        }
    }

    /**
     * 获取所有国家
     *
     * @return
     */
    public static List<SysRegionEntity> getAllCountry() {
        List<SysRegionEntity> resultObj = new ArrayList<SysRegionEntity>();
        if (null != sysRegionEntityList) {
            for (SysRegionEntity areaVo : sysRegionEntityList) {
                if (areaVo.getType().equals(0)) {
                    resultObj.add(areaVo);
                }
            }
        }
        return resultObj;
    }

    /**
     * 获取全部省份
     *
     * @return
     */
    public static List<SysRegionEntity> getAllProvice() {
        List<SysRegionEntity> resultObj = new ArrayList<SysRegionEntity>();
        if (null != sysRegionEntityList) {
            for (SysRegionEntity areaVo : sysRegionEntityList) {
                if (areaVo.getType().equals(1)) {
                    resultObj.add(areaVo);
                }
            }
        }
        return resultObj;
    }

    /**
     * 获取全部所有
     *
     * @return
     */
    public static List<MyRegion> getAll() {
       
        return myRegionList;
    }
    /**
     * 获取全部所有
     *
     * @return
     */
    public static List<MyRegion> getAllLevel() {
       
        return myRegionLevelList;
    }
   
    /**
     * 获取所有城市
     *
     * @return
     */
    public static List<SysRegionEntity> getAllCity() {
        List<SysRegionEntity> resultObj = new ArrayList<SysRegionEntity>();
        if (null != sysRegionEntityList) {
            for (SysRegionEntity areaVo : sysRegionEntityList) {
                if (areaVo.getType().equals(2)) {
                    resultObj.add(areaVo);
                }
            }
        }
        return resultObj;
    }

    /**
     * 根据国家获取全部省份
     *
     * @return
     */
    public static List<SysRegionEntity> getAllProviceByParentId(Integer areaId) {
        List<SysRegionEntity> resultObj = new ArrayList<SysRegionEntity>();
        if (null == areaId) {
            return resultObj;
        }
        if (null != sysRegionEntityList) {
            for (SysRegionEntity areaVo : sysRegionEntityList) {
                if (null != areaVo.getParentId() && areaVo.getType().equals(1) && areaId.equals(areaVo.getParentId())) {
                    resultObj.add(areaVo);
                }
            }
        }
        return resultObj;
    }

    /**
     * 获取地市
     *
     * @return
     */
    public static List<SysRegionEntity> getChildrenCity(Integer areaId) {
        List<SysRegionEntity> resultObj = new ArrayList<SysRegionEntity>();
        if (null == areaId) {
            return resultObj;
        }
        if (null != sysRegionEntityList) {
            for (SysRegionEntity areaVo : sysRegionEntityList) {
                if (null != areaVo.getParentId() && areaVo.getType().equals(2) && areaId.equals(areaVo.getParentId())) {
                    resultObj.add(areaVo);
                }
            }
        }
        return resultObj;
    }

    /**
     * 获取地市
     *
     * @return
     */
    public static List<SysRegionEntity> getChildrenCity(String proviceName) {
        List<SysRegionEntity> resultObj = new ArrayList<SysRegionEntity>();
        if (null == proviceName) {
            return resultObj;
        }
        if (null != sysRegionEntityList) {
            for (SysRegionEntity areaVo : sysRegionEntityList) {
                if (null != areaVo.getParentId() && areaVo.getType().equals(2) && proviceName.equals(areaVo.getParentName())) {
                    resultObj.add(areaVo);
                }
            }
        }
        return resultObj;
    }

    /**
     * 获取区县
     *
     * @return
     */
    public static List<SysRegionEntity> getChildrenDistrict(Integer areaId) {
        List<SysRegionEntity> resultObj = new ArrayList<SysRegionEntity>();
        if (null == areaId) {
            return resultObj;
        }
        if (null != sysRegionEntityList) {
            for (SysRegionEntity areaVo : sysRegionEntityList) {
                if (null != areaVo.getParentId() && areaVo.getType().equals(3) && areaId.equals(areaVo.getParentId())) {
                    resultObj.add(areaVo);
                }
            }
        }
        return resultObj;
    }

    /**
     * 获取区县
     *
     * @return
     */
    public static List<SysRegionEntity> getChildrenDistrict(String provinceName, String cityName) {
        List<SysRegionEntity> resultObj = new ArrayList<SysRegionEntity>();
        if (null == provinceName || null == cityName) {
            return resultObj;
        }
        if (null != sysRegionEntityList) {
            for (SysRegionEntity areaVo : sysRegionEntityList) {
                if (null != areaVo.getParentId() && areaVo.getType().equals(3)
                        && cityName.equals(areaVo.getParentName())
                        && null != getAreaByAreaId(areaVo.getParentId())
                        && provinceName.equals(getAreaByAreaId(areaVo.getParentId()).getParentName())) {
                    resultObj.add(areaVo);
                }
            }
        }
        return resultObj;
    }


    /**
     * 获取区县
     *
     * @return
     */
    public static List<SysRegionEntity> getChildrenByParentId(Integer parentId) {
        List<SysRegionEntity> resultObj = new ArrayList<SysRegionEntity>();
        if (null == parentId) {
            return resultObj;
        }
        if (null != sysRegionEntityList) {
            for (SysRegionEntity areaVo : sysRegionEntityList) {
                if (null != areaVo.getParentId() && parentId.equals(areaVo.getParentId())) {
                    resultObj.add(areaVo);
                }
            }
        }
        return resultObj;
    }

    /**
     * 获取区域名称
     *
     * @return
     */
    public static String getAreaNameByAreaId(Integer areaId) {
        if (null == areaId) {
            return "";
        }
        String resultObj = areaId.toString();
        if (null != sysRegionEntityList) {
            for (SysRegionEntity areaVo : sysRegionEntityList) {
                if (areaVo.getId().equals(areaId)) {
                    resultObj = areaVo.getName();
                    break;
                }
            }
        }
        return resultObj;
    }

    /**
     * 根据Id获取区域
     *
     * @return
     */
    public static SysRegionEntity getAreaByAreaId(Integer areaId) {
        SysRegionEntity resultObj = null;
        if (null == areaId) {
            return resultObj;
        }
        if (null != sysRegionEntityList) {
            for (SysRegionEntity areaVo : sysRegionEntityList) {
                if (areaVo.getId().equals(areaId)) {
                    resultObj = areaVo;
                    break;
                }
            }
        }
        return resultObj;
    }

    /**
     * 根据Id获取区域
     *
     * @return
     */
    public static Integer getProvinceIdByName(String areaName) {
        Integer resultObj = null;
        if (null == areaName) {
            return resultObj;
        }
        if (null != sysRegionEntityList) {
            for (SysRegionEntity areaVo : sysRegionEntityList) {
                if (areaVo.getType() == 1 && areaVo.getName().equals(areaName)) {
                    resultObj = areaVo.getId();
                    break;
                }
            }
        }
        return resultObj;
    }

    /**
     * 根据Id获取区域
     *
     * @return
     */
    public static Integer getCityIdByName(Integer provinceId, String areaName) {
        Integer resultObj = null;
        if (null == areaName) {
            return resultObj;
        }
        if (null != sysRegionEntityList) {
            for (SysRegionEntity areaVo : sysRegionEntityList) {
                if (areaVo.getType() == 2 && areaVo.getName().equals(areaName)
                        && areaVo.getParentId().equals(provinceId)) {
                    resultObj = areaVo.getId();
                    break;
                }
            }
        }
        return resultObj;
    }


    /**
     * 根据Id获取区域
     *
     * @return
     */
    public static Integer getDistrictIdByName(Integer provinceId, Integer cityId, String areaName) {
        Integer resultObj = null;
        if (null == areaName) {
            return resultObj;
        }
        if (null != sysRegionEntityList) {
            for (SysRegionEntity areaVo : sysRegionEntityList) {
                if (areaVo.getType() == 3 && areaVo.getName().equals(areaName)
                        && areaVo.getParentId().equals(cityId)
                        && null != getAreaByAreaId(areaVo.getParentId())
                        && null != getAreaByAreaId(areaVo.getParentId()).getParentId()
                        && getAreaByAreaId(areaVo.getParentId()).getParentId().equals(provinceId)) {
                    resultObj = areaVo.getId();
                    break;
                }
            }
        }
        return resultObj;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        init();
    }

}