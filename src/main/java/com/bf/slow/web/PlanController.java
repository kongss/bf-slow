//package com.bf.slow.web;
//
//import com.alibaba.fastjson.JSON;
//import com.bf.slow.dao.PlanReposiory;
//import com.bf.slow.entity.Plan;
//import io.swagger.annotations.ApiOperation;
//import lombok.extern.slf4j.Slf4j;
//import org.elasticsearch.index.query.BoolQueryBuilder;
//import org.elasticsearch.index.query.QueryBuilders;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.openfeign.SpringQueryMap;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Sort;
//import org.springframework.data.domain.Sort.Direction;
//import org.springframework.util.StringUtils;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Date;
//import java.util.Optional;
//import java.util.UUID;
//
///**
// * xx
// *
// * @author kongshuaishuai
// * Created on 2019/5/20 12:48
// * Email is kongshuaishuai@mrfresh.com
// * Copyright is
// */
//@Slf4j
//@RestController
//@RequestMapping(value = "/plan", produces = {"application/json;charset=UTF-8"})
//public class PlanController {
//
//    //constant
//    public static final String ID = "id";
//    public static final String TITLE = "title";
//    public static final String USER_ID = "userId";
//    public static final String SYNOPSIS = "synopsis";
//    public static final String BEGIN_TIME = "beginTime";
//    public static final String END_TIME = "endTime";
//    public static final String STATUS = "status";
//    public static final String INSERT_TIME = "insertTime";
//    public static final String UPDATE_TIME = "updateTime";
//    public static final String CODE = "code";
//    public static final String FOUNDER = "founder";
//
//    @Autowired
//    PlanReposiory planReposiory;
//
//    @GetMapping("/")
//    public String index(){
//        return "ok";
//    }
//
//    @ApiOperation(value = "add", notes = "新增")
//    @PostMapping("/add")
//    public String add(@SpringQueryMap Plan plan){
//        log.info("新增plan参数:{}, {}", plan.getUserId(), plan);
//        String string = UUID.randomUUID().toString();
//        plan.setId(string);
//        plan.setInsertTime(new Date());
//        Plan pl = planReposiory.save(plan);
//        log.info("新增plan结果:{}", pl);
//        return JSON.toJSONString(pl);
//    }
//
//    @GetMapping("/page")
//    public String page(Plan plan, int pageIndex, int pageSize){
//        log.info("查询plan参数:{}", JSON.toJSONString(plan));
//        BoolQueryBuilder queryBuilder = getBaseQueryBuilder(plan);
//        PageRequest pageRequest = queryPageParams(pageIndex, pageSize);
//        Page<Plan> search = planReposiory.search(queryBuilder, pageRequest);
//        log.info("查询plan结果:{}", JSON.toJSONString(search));
//        return JSON.toJSONString(search);
//    }
//
//    @PutMapping("/update")
//    public String update(Plan plan){
//        plan.setUpdateTime(new Date());
//        Plan pl = planReposiory.save(plan);
//        return JSON.toJSONString(pl);
//    }
//
//    @DeleteMapping("/delete")
//    public String delete(String id){
//        Optional<Plan> plan = planReposiory.findById(id);
//        planReposiory.deleteById(id);
//        return JSON.toJSONString(plan);
//    }
//    /**
//     * 基础查询条件组装
//     * @param plan
//     * @return
//     */
//    private BoolQueryBuilder getBaseQueryBuilder(Plan plan){
//        BoolQueryBuilder queryBuilder = QueryBuilders.boolQuery();
//        if (!StringUtils.isEmpty(plan.getId())){
//            queryBuilder.filter(QueryBuilders.termQuery(ID, plan.getId()));
//        }
//        if (!StringUtils.isEmpty(plan.getUserId())) {
//            queryBuilder.filter(QueryBuilders.fuzzyQuery(USER_ID, plan.getUserId()));
//        }
//        if (!StringUtils.isEmpty(plan.getTitle())) {
//            queryBuilder.filter(QueryBuilders.fuzzyQuery(TITLE, plan.getTitle()));
//        }
//        if (!StringUtils.isEmpty(plan.getSynopsis())){
//            queryBuilder.filter(QueryBuilders.termQuery(SYNOPSIS, plan.getSynopsis()));
//        }
//        if (!StringUtils.isEmpty(plan.getBeginTime())){
//            queryBuilder.filter(QueryBuilders.termQuery(BEGIN_TIME, plan.getBeginTime()));
//        }
//        if (!StringUtils.isEmpty(plan.getEndTime())){
//            queryBuilder.filter(QueryBuilders.termQuery(END_TIME, plan.getEndTime()));
//        }
//        if (!StringUtils.isEmpty(plan.getStatus())) {
//            queryBuilder.filter(QueryBuilders.termQuery(STATUS, plan.getStatus()));
//        }
//        if (!StringUtils.isEmpty(plan.getInsertTime())) {
//            queryBuilder.filter(QueryBuilders.termQuery(INSERT_TIME, plan.getInsertTime()));
//        }
//        if (!StringUtils.isEmpty(plan.getUpdateTime())) {
//            queryBuilder.filter(QueryBuilders.termQuery(UPDATE_TIME, plan.getUpdateTime()));
//        }
//        if (!StringUtils.isEmpty(plan.getCode())) {
//            queryBuilder.filter(QueryBuilders.termQuery(CODE, plan.getCode()));
//        }
//        if (!StringUtils.isEmpty(plan.getFounder())) {
//            queryBuilder.filter(QueryBuilders.termQuery(FOUNDER, plan.getFounder()));
//        }
//        return queryBuilder;
//    }
//
//    /**
//     * 基础查询 分页排序条件组装
//     * @param pageIndex
//     * @param pageSize
//     * @return
//     */
//    private PageRequest queryPageParams(int pageIndex, int pageSize){
//        Sort sort = Sort.by(new Sort.Order(Direction.DESC, INSERT_TIME));
//        PageRequest pageRequest = PageRequest.of(pageIndex, pageSize, sort);
//        return pageRequest;
//    }
//
//}
//
//
//
//
//
