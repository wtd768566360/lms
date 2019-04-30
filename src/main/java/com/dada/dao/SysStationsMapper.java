package com.dada.dao;

import org.apache.ibatis.annotations.Mapper;

import com.dada.entity.SysStations;

import java.util.List;

@Mapper
public interface SysStationsMapper {

    int insertSelective(SysStations record);

    /**
     * 新增数据
     * @param sysStations
     * @return
     */
    int insert(SysStations sysStations);

    /**
     * 删除数据
     * @param sysStations
     * @return
     */
    int remove(SysStations sysStations);

    /**
     * 更新数据
     * @param sysStations
     * @return
     */
    int update(SysStations sysStations);

    /**
     * 列表查询
     * @param stationName
     * @return
     */
    List<SysStations> list(String stationName);

    /**
     * 分页查询
     * @param stationName
     * @param currentPage
     * @param pageSize
     * @return
     */
    List<SysStations> findPage(String stationName, int currentPage, int pageSize);

    /**
     * 获取分页条数
     * @param stationName
     * @param currentPage
     * @param pageSize
     * @return
     */
    int findPageByCount(String stationName, int currentPage, int pageSize);
}