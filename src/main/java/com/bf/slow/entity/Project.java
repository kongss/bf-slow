package com.bf.slow.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Project
 *
 * @author kongshuaishuai
 * Created on 2019/5/20 12:48
 * Email is kongshuaishuai@mrfresh.com
 * Copyright is
 */

@Data
//@Document(indexName = "project", type = "project")
public class Project implements Serializable {

    private String id;

    private String name;

    private Date insertTime;

    private Integer status;

    private Date endTime;

    private Date beginTime;

    private String teaCode;

    private String founder;

    private Date updateTime;
}
