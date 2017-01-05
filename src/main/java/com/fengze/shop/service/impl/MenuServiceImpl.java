package com.fengze.shop.service.impl;

import com.fengze.shop.mapper.MenuDoMapper;
import com.fengze.shop.model.MenuDo;
import com.fengze.shop.service.MenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by zhangls on 2016/12/21 0021.
 */
@Slf4j
@Service
public class MenuServiceImpl extends BaseServiceImpl<MenuDo> implements MenuService {

    @Autowired(required = false)
    private MenuDoMapper menuDoMapper;

    private static List<Long> ls = null;

    @Override
    public Map<Long, List<MenuDo>> queryMenuAll() {
        MenuDo menuDo = new MenuDo();
        menuDo.setTypePId(0L);

        menuDo.setRedisKeyId(menuDo.getTypePId());

        return getMenuDetail(select(menuDo), 0L, new LinkedHashMap<Long, List<MenuDo>>());
    }

    /**
     * 递归方法，实现菜单信息的查询
     *
     * @return
     */
    private Map<Long, List<MenuDo>> getMenuDetail(List<MenuDo> ls, Long menuId, Map<Long, List<MenuDo>> map) {
        if (ls.size() != 0) {
            map.put(menuId, ls);
        }

        for (MenuDo menu : ls) {
            MenuDo menuDo = new MenuDo();
            menuDo.setTypePId(menu.getTypeId());
            menuDo.setRedisKeyId(menuDo.getTypePId());

            if (!isLeafNode(menu.getTypeId())) {
                getMenuDetail(select(menuDo), menu.getTypeId(), map);
            }
        }

        return map;
    }

    private Boolean isLeafNode(Long id) {
        if(ls==null){
            ls = menuDoMapper.queryLeafNode();
        }

        for (Long nodeId : ls) {
            if (id.equals(nodeId)) return Boolean.TRUE;
        }

        return Boolean.FALSE;
    }
}
