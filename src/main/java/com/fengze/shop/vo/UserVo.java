package com.fengze.shop.vo;

import lombok.Data;
import net.sf.oval.constraint.NotEmpty;
import net.sf.oval.constraint.NotNull;

/**
 * Created by Administrator on 2017-01-02.
 */
@Data
public class UserVo {

    @NotNull
    @NotEmpty
    private String userName;
    @NotNull
    @NotEmpty
    private String passWord;
}
