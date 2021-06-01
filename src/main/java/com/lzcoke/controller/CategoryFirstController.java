package com.lzcoke.controller;

import com.lzcoke.mapper.CategoryMapper;
import com.lzcoke.pojo.*;
import com.lzcoke.utils.MybatisUtils;
import com.lzcoke.utils.ResultUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.ibatis.session.SqlSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Api(tags = "分类信息")
public class CategoryFirstController {

    @ApiOperation(value = "获取一级分类信息")
    @GetMapping("/c_first")
    public ResultUtils<CategoryFirst> FirstCategory() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        CategoryMapper mapper = sqlSession.getMapper(CategoryMapper.class);
        List<CategoryFirst> categoryFirsts = mapper.CategoryPage();
        Map<String, Object> map = new HashMap<>();
        map.put("total", 200);
        map.put("list", categoryFirsts);
        ResultUtils resultData = new ResultUtils<>();
        resultData.setCode(200);
        resultData.setMessage("获取成功");
        resultData.setData(map);

        sqlSession.close();
        return resultData;
    }

    @ApiOperation(value = "获取二级分类信息")
    @GetMapping("/c_second")
    public ResultUtils<CategorySecond> SecondCategory(@ApiParam(name = "categoryId", value = "一级分类编号", required = false)
                                                      @RequestParam(defaultValue = "0") int categoryId) {
        Map<String, Object> map = new HashMap<>();
        ResultUtils resultData = new ResultUtils<>();
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        CategoryMapper mapper = sqlSession.getMapper(CategoryMapper.class);
        List<CategorySecond> categorySeconds = mapper.SecondPage(categoryId);
        map.put("total", 200);
        map.put("list", categorySeconds);
        resultData.setCode(200);
        resultData.setMessage("获取成功");
        resultData.setData(map);
        sqlSession.close();

        return resultData;
    }

    @ApiOperation(value = "获取三级分类信息")
    @GetMapping("/c_three")
    public ResultUtils<CategoryThree> ThreeCategory(@ApiParam(name = "categoryId", value = "一级级分类编号", required = false)
                                                    @RequestParam(defaultValue = "0") int categoryId,
                                                    @ApiParam(name = "secondId", value = "二级分类编号", required = false)
                                                    @RequestParam(defaultValue = "0") int secondId) {
        ResultUtils resultData = new ResultUtils<>();
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        CategoryMapper mapper = sqlSession.getMapper(CategoryMapper.class);
        List<CategoryThree> categoryThrees = mapper.ThreePage(categoryId, secondId);
        Map<String, Object> map = new HashMap<>();
        map.put("total", 200);
        map.put("list", categoryThrees);
        resultData.setCode(200);
        resultData.setMessage("获取成功");
        resultData.setData(map);
        sqlSession.close();

        return resultData;
    }

    @ApiOperation(value = "获取四级分类信息")
    @GetMapping("/c_four")
    public ResultUtils<CategoryFour> FourPage(@ApiParam(name = "categoryId", value = "一级级分类编号", required = false)
                                              @RequestParam(defaultValue = "0") int categoryId,
                                              @ApiParam(name = "secondId", value = "二级分类编号", required = false)
                                              @RequestParam(defaultValue = "0") int secondId,
                                              @ApiParam(name = "threeId", value = "三级分类编号", required = false)
                                              @RequestParam(defaultValue = "0") int threeId) {
        ResultUtils resultData = new ResultUtils<>();
        Map<String, Object> map = new HashMap<>();
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        CategoryMapper mapper = sqlSession.getMapper(CategoryMapper.class);
        List<CategoryFour> categoryItem = mapper.FourPage(categoryId, secondId, threeId);
        map.put("total", 200);
        map.put("list", categoryItem);
        resultData.setCode(200);
        resultData.setMessage("获取成功");
        resultData.setData(map);
        sqlSession.close();

        return resultData;
    }

    @ApiOperation(value = "获取五级分类信息")
    @GetMapping("/c_five")
    public ResultUtils<CategoryFive> FivePage(@ApiParam(name = "categoryId", value = "一级级分类编号", required = false)
                                              @RequestParam(defaultValue = "0") int categoryId,
                                              @ApiParam(name = "secondId", value = "二级分类编号", required = false)
                                              @RequestParam(defaultValue = "0") int secondId,
                                              @ApiParam(name = "threeId", value = "三级分类编号", required = false)
                                              @RequestParam(defaultValue = "0") int threeId,
                                              @ApiParam(name = "fourId", value = "四级分类编号", required = false)
                                              @RequestParam(defaultValue = "0") int fourId) {
        ResultUtils resultData = new ResultUtils<>();
        Map<String, Object> map = new HashMap<>();
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        CategoryMapper mapper = sqlSession.getMapper(CategoryMapper.class);
        List<CategoryFive> categoryItem = mapper.FivePage(categoryId, secondId, threeId, fourId);
        map.put("total", 200);
        map.put("list", categoryItem);
        resultData.setCode(200);
        resultData.setMessage("获取成功");
        resultData.setData(map);
        sqlSession.close();

        return resultData;
    }
}
