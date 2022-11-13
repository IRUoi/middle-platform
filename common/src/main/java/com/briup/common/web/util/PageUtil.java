package com.briup.common.web.util;

/**
 * @Auther: ZHU(lc))
 * @Date: 11/14/2022-11-14-12:57 AM
 * @Description：com.briup.common.web.util
 */
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@ApiModel("分页模型")
public class PageUtil<T> implements Serializable {
    /**
     * 当前页
     */
    @ApiModelProperty(name = "pageNumber",value = "当前页",example = "0")
    private Integer pageNumber;
    /**
     * 每页条数
     */
    @ApiModelProperty(name = "pageSize",value = "每页数量",example = "5")
    private Integer pageSize;
    /**
     * 总条数
     */
    @ApiModelProperty(hidden = true)
    private long total;
    /**
     * 数据列表
     */
    @ApiModelProperty(hidden = true)
    private List<T> list;
    /**
     * 搜索条件
     */
    @ApiModelProperty(name = "params",value = "查询条件")
    private Map<String, Object> params = new HashMap<>(8);
}