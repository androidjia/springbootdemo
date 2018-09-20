package com.ligong.springbootdemo.web;

import com.ligong.springbootdemo.entity.Area;
import com.ligong.springbootdemo.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/superAdmin")
public class AreaController {
    @Autowired
    private AreaService areaService;

    @RequestMapping(value = "/listArea", method = RequestMethod.GET)
    private Map<String,Object> listArea(){
        Map<String ,Object> map = new HashMap<String,Object>();
        List<Area> list = areaService.getAreaList();

        map.put("areaList",list);
        return map;
    }

    @RequestMapping(value = "/getAreaById", method = RequestMethod.GET)
    private Map<String,Object> getAreaById(Integer areaId){
        Map<String ,Object> map = new HashMap<String, Object>();
        Area area = areaService.getAreaById(areaId);
        map.put("area",area);
        return map;
    }

    @RequestMapping(value = "/addArea", method = RequestMethod.POST)
    private Map<String,Object> addArea(@RequestBody Area area){
        Map<String ,Object> map = new HashMap<String, Object>();
        map.put("success",areaService.addArea(area));
        return map;
    }

    @RequestMapping(value = "/modifyArea",method = RequestMethod.POST)
    private Map<String,Object> modifyArea(@RequestBody Area area){
        Map<String ,Object> map = new HashMap<String, Object>();
        //修改区域信息成功
        map.put("success",areaService.modifyArea(area));
        return map;
    }

    @RequestMapping(value = "/removeArea", method = RequestMethod.GET)
    private Map<String,Object> removeArea(Integer areaId){
        Map<String ,Object> map = new HashMap<String, Object>();
        //删除区域信息成功
        map.put("success",areaService.deleteArea(areaId));
        return map;
    }
}
