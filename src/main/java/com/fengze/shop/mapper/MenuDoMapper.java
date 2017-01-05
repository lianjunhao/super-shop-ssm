package com.fengze.shop.mapper;

import com.fengze.shop.model.MenuDo;
import com.fengze.shop.util.MyMapper;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface MenuDoMapper extends MyMapper<MenuDo> {

    /**
     * 查询所有叶子节点
     * @return
     */
    public List<Long> queryLeafNode();
}