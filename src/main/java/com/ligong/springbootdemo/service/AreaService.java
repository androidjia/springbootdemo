package com.ligong.springbootdemo.service;

import com.ligong.springbootdemo.entity.Area;

import java.util.List;

public interface AreaService {
    List<Area> getAreaList();

    Area getAreaById(int areaId);

    boolean addArea(Area area);

    /**
     * 更新区域
     * @param area
     * @return
     */
    boolean modifyArea(Area area);

    boolean deleteArea(int areaId);
}
