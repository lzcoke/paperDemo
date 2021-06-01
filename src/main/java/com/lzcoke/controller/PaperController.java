package com.lzcoke.controller;

import com.lzcoke.mapper.PaperMapper;
import com.lzcoke.pojo.Paper;
import com.lzcoke.pojo.PaperCollect;
import com.lzcoke.pojo.PaperPage;
import com.lzcoke.pojo.PaperViewPojo;
import com.lzcoke.utils.MybatisUtils;
import com.lzcoke.utils.ResultUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.ibatis.session.SqlSession;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(tags = "试卷接口")
@RestController
public class PaperController {

    @ApiOperation("获取试卷列表")
    @GetMapping("/paper")
    public ResultUtils<Paper> getPaper(@ApiParam(name = "page", value = "页码", defaultValue = "1")
                                       @RequestParam(defaultValue = "1") int page,
                                       @ApiParam(name = "limit", value = "最大显示数", defaultValue = "10")
                                       @RequestParam(defaultValue = "10") int limit,
                                       @ApiParam(name = "categoryId", value = "一级分类编号", defaultValue = "0")
                                       @RequestParam(defaultValue = "0") int categoryId,
                                       @ApiParam(name = "secondId", value = "二级分类编号", defaultValue = "0")
                                       @RequestParam(defaultValue = "0") int secondId,
                                       @ApiParam(name = "threeId", value = "三级分类编号", defaultValue = "0")
                                       @RequestParam(defaultValue = "0") int threeId,
                                       @ApiParam(name = "fourId", value = "四级分类编号", defaultValue = "0")
                                       @RequestParam(defaultValue = "0") int fourId,
                                       @ApiParam(name = "fiveId", value = "五级分类编号", defaultValue = "0")
                                       @RequestParam(defaultValue = "0") int fiveId,
                                       @ApiParam(name = "userId", value = "用户信息", defaultValue = "0")
                                       @RequestParam(defaultValue = "0") int userId) {

        ResultUtils resultData = new ResultUtils();
        Map map = new HashMap<>();

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        PaperMapper mapper = sqlSession.getMapper(PaperMapper.class);
        int perpage = (page - 1) * limit;
        List<PaperPage> papers = mapper.paperPage(perpage, limit, categoryId, secondId, threeId, fourId, fiveId, userId);
        int total = mapper.paperCount();
        map.put("total", total);
        map.put("list", papers);
        resultData.setCode(200);
        resultData.setMessage("获取成功");
        resultData.setData(map);
        sqlSession.close();

        return resultData;
    }

    @PostMapping("/collect")
    @ApiOperation("试卷收藏")
    public ResultUtils<Map> paperCollect(@ApiParam(name = "userId", value = "用户编号", defaultValue = "1")
                                         @RequestParam(defaultValue = "0") int userId,
                                         @ApiParam(name = "paperId", value = "试卷编号", defaultValue = "1")
                                         @RequestParam(defaultValue = "0") int paperId) {

        ResultUtils resultData = new ResultUtils();
        Map map = new HashMap<>();
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        PaperMapper mapper = sqlSession.getMapper(PaperMapper.class);
        PaperCollect paperCollectItem = mapper.paperCollectJunit(paperId, userId);
        System.out.println(paperCollectItem);
        if (paperCollectItem == null) {
            int i = mapper.paperCollect(paperId, userId);
            resultData.setCode(200);
            resultData.setMessage("收藏成功");
        } else {
            resultData.setCode(500);
            resultData.setMessage("请不要重复收藏");
        }
        resultData.setData(map);
        return resultData;
    }

    @DeleteMapping("/collect")
    @ApiOperation("取消试卷收藏")
    public ResultUtils<Map> paperNotCollect(@ApiParam(name = "userId", value = "用户编号", defaultValue = "1")
                                            @RequestParam(defaultValue = "0") int userId,
                                            @ApiParam(name = "paperId", value = "试卷编号", defaultValue = "1")
                                            @RequestParam(defaultValue = "0") int paperId) {

        ResultUtils resultData = new ResultUtils();
        Map map = new HashMap<>();
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        PaperMapper mapper = sqlSession.getMapper(PaperMapper.class);
        int i = mapper.paperNotCollect(paperId, userId);
        resultData.setCode(200);
        resultData.setMessage("取消收藏成功");
        resultData.setData(map);
        return resultData;
    }

    @GetMapping("/collect")
    @ApiOperation("试卷收藏列表")
    public ResultUtils<PaperCollect> paperCollectPage(@ApiParam(name = "userId", value = "用户编号", defaultValue = "1")
                                                      @RequestParam(defaultValue = "0") int userId,
                                                      @ApiParam(name = "page", value = "页码", defaultValue = "1")
                                                      @RequestParam(defaultValue = "1") int page,
                                                      @ApiParam(name = "limit", value = "每页显示数", defaultValue = "10")
                                                      @RequestParam(defaultValue = "10") int limit) {
        ResultUtils resultData = new ResultUtils();
        Map map = new HashMap<>();
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        PaperMapper mapper = sqlSession.getMapper(PaperMapper.class);
        int perpage = (page - 1) * limit;
        List<PaperCollect> paperCollects = mapper.paperCollectPage(perpage, limit, userId);
        int total = mapper.paperCollectCount(userId);
        map.put("total", total);
        map.put("list", paperCollects);
        resultData.setCode(200);
        resultData.setMessage("获取收藏列表成功");
        resultData.setData(map);
        return resultData;
    }

    @GetMapping("/view")
    @ApiOperation("历史记录")
    public ResultUtils<PaperViewPojo> paperViewList(@ApiParam(name = "userId", value = "用户编号", defaultValue = "1")
                                                    @RequestParam(defaultValue = "0") int userId,
                                                    @ApiParam(name = "page", value = "页码", defaultValue = "1")
                                                    @RequestParam(defaultValue = "1") int page,
                                                    @ApiParam(name = "limit", value = "每页显示数", defaultValue = "10")
                                                    @RequestParam(defaultValue = "10") int limit) {
        ResultUtils resultData = new ResultUtils();
        Map map = new HashMap<>();
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        PaperMapper mapper = sqlSession.getMapper(PaperMapper.class);
        int perpage = (page - 1) * limit;
        List<PaperViewPojo> paperViewPojos = mapper.paperViewPage(perpage, limit, userId);
        final int total = mapper.paperViewCount(userId);
        map.put("total", total);
        map.put("list", paperViewPojos);
        resultData.setCode(200);
        resultData.setMessage("获取历史记录成功");
        resultData.setData(map);
        return resultData;
    }

    @PostMapping("/view")
    @ApiOperation("生成记录")
    public ResultUtils<Map> paperView(@ApiParam(name = "userId", value = "用户编号", defaultValue = "1")
                                      @RequestParam(defaultValue = "0") int userId,
                                      @ApiParam(name = "paperId", value = "试卷编号", defaultValue = "1")
                                      @RequestParam(defaultValue = "0") int paperId) {

        ResultUtils resultData = new ResultUtils();
        Map map = new HashMap<>();
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        PaperMapper mapper = sqlSession.getMapper(PaperMapper.class);
        int i = mapper.paperView(paperId, userId);
        resultData.setCode(200);
        resultData.setMessage("记录成功");
        resultData.setData(map);
        return resultData;
    }

}
