package com.example.parperproject;

import com.lzcoke.PaperProjectApplication;
import com.lzcoke.mapper.CategoryMapper;
import com.lzcoke.pojo.CategoryFirst;
import com.lzcoke.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest(classes = PaperProjectApplication.class)
class ParperProjectApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void paper() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        CategoryMapper mapper = sqlSession.getMapper(CategoryMapper.class);
        List<CategoryFirst> categoryFirsts = mapper.CategoryPage();
        for (CategoryFirst categoryFirst : categoryFirsts) {
            System.out.println(categoryFirst);
        }
        sqlSession.close();
    }

}
