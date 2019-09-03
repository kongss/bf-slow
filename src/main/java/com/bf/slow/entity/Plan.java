package com.bf.slow.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * Plan
 *
 * @author kongshuaishuai
 * Created on 2019/5/20 12:48
 * Email is kongshuaishuai@mrfresh.com
 * Copyright is
 */

@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
//@Document(indexName = "plan", type = "plan")
public class Plan implements Serializable {
    private String id;

    private String userId;

    private String title;

    private String synopsis;

    private Date beginTime;

    private Date endTime;

    private Integer status;

    private Date insertTime;

    private Date updateTime;

    private String code;

    private String founder;
}

