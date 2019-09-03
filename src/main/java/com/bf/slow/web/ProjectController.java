//package com.bf.slow.web;
//
//import com.alibaba.fastjson.JSON;
//import com.bf.slow.dao.ProjectReposiory;
//import com.bf.slow.entity.Project;
//import lombok.extern.slf4j.Slf4j;
//import org.elasticsearch.index.query.BoolQueryBuilder;
//import org.elasticsearch.index.query.QueryBuilder;
//import org.elasticsearch.index.query.QueryBuilders;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.openfeign.SpringQueryMap;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Sort;
//import org.springframework.util.StringUtils;
//import org.springframework.web.bind.annotation.*;
//
//import javax.validation.constraints.Max;
//import javax.validation.constraints.Min;
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
//@RequestMapping(value = "/project", produces = {"application/json;charset=UTF-8"})
//public class ProjectController {
//
//    public static final String ID = "id";
//    public static final String NAME = "name";
//    public static final String INSERT_TIME = "insertTime";
//    public static final String STATUS = "status";
//    public static final String END_TIME = "endTime";
//    public static final String BEGIN_TIME = "beginTime";
//    public static final String TEA_CODE = "teaCode";
//    public static final String FOUNDER = "founder";
//    public static final String UPDATE_TIME = "updateTime";
//
//    @Autowired
//    ProjectReposiory projectReposiory;
//
//    @GetMapping("/")
//    public String index(){
//        return "ok";
//    }
//
//    @PostMapping("/add")
//    public String add(@SpringQueryMap Project project){
//        log.info("新增project参数:{}", project);
//        project.setId(UUID.randomUUID().toString());
//        project.setInsertTime(new Date());
//        Project pro = projectReposiory.save(project);
//        log.info("新增project结果:{}", pro);
//        return JSON.toJSONString(pro);
//    }
//
//    @GetMapping("/page")
//    public String page(@SpringQueryMap Project project, @Min(0) @RequestParam int pageIndex,@Max(100) @RequestParam int pageSize){
//        log.info("查询project参数:{}", project);
//        QueryBuilder queryBuilder = getBaseQueryBuilder(project);
//        PageRequest pageRequest = queryPageParams(pageIndex, pageSize);
//        Page<Project> search = projectReposiory.search(queryBuilder, pageRequest);
//        log.info("查询project结果:{}", JSON.toJSONString(search));
//        return JSON.toJSONString(search);
//    }
//
//    @PutMapping("/update")
//    public String update(@SpringQueryMap Project project){
//        project.setUpdateTime(new Date());
//        Project pro = projectReposiory.save(project);
//        return JSON.toJSONString(pro);
//    }
//
//    @DeleteMapping("/delete")
//    public String delete(@PathVariable String id){
//        Optional<Project> pro = projectReposiory.findById(id);
//        projectReposiory.deleteById(id);
//        return JSON.toJSONString(pro);
//    }
//
//    /**
//     * 基础查询条件组装
//     * @param project
//     * @return
//     */
//    QueryBuilder getBaseQueryBuilder(Project project){
//        BoolQueryBuilder queryBuilder = QueryBuilders.boolQuery();
//        if (!StringUtils.isEmpty(project.getId())){
//            queryBuilder.filter(QueryBuilders.termQuery(ID, project.getId()));
//        }
//        if (!StringUtils.isEmpty(project.getName())){
//            queryBuilder.filter(QueryBuilders.termQuery(NAME, project.getName()));
//        }
//        if (!StringUtils.isEmpty(project.getInsertTime())){
//            queryBuilder.filter(QueryBuilders.termQuery(INSERT_TIME, project.getInsertTime()));
//        }
//        if (!StringUtils.isEmpty(project.getStatus())){
//            queryBuilder.filter(QueryBuilders.termQuery(STATUS, project.getStatus()));
//        }
//        if (!StringUtils.isEmpty(project.getBeginTime())){
//            queryBuilder.filter(QueryBuilders.termQuery(BEGIN_TIME, project.getBeginTime()));
//        }
//        if (!StringUtils.isEmpty(project.getEndTime())){
//            queryBuilder.filter(QueryBuilders.termQuery(END_TIME, project.getEndTime()));
//        }
//        if (!StringUtils.isEmpty(project.getTeaCode())){
//            queryBuilder.filter(QueryBuilders.termQuery(TEA_CODE, project.getTeaCode()));
//        }
//        if (!StringUtils.isEmpty(project.getFounder())){
//            queryBuilder.filter(QueryBuilders.termQuery(FOUNDER, project.getFounder()));
//        }
//        if (!StringUtils.isEmpty(project.getUpdateTime())){
//            queryBuilder.filter(QueryBuilders.termQuery(UPDATE_TIME, project.getUpdateTime()));
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
//    PageRequest queryPageParams(int pageIndex, int pageSize){
//        Sort sort = Sort.by(new Sort.Order(Sort.Direction.DESC, INSERT_TIME));
//        PageRequest pageRequest = PageRequest.of(pageIndex, pageSize, sort);
//        return pageRequest;
//    }
//}
