package com.fengze.shop.service;


import com.fengze.shop.model.MenuDo;

import java.util.List;
import java.util.Map;

/**
 * Created by zhangls on 2016/12/20 0020.
 */
public interface MenuService extends BaseService<MenuDo> {

    /**
     * 查询菜单
     * @return
     */
    public Map<Long, List<MenuDo>> queryMenuAll();
}
