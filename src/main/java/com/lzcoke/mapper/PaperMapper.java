package com.lzcoke.mapper;

import com.lzcoke.pojo.Paper;
import com.lzcoke.pojo.PaperCollect;
import com.lzcoke.pojo.PaperPage;
import com.lzcoke.pojo.PaperViewPojo;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PaperMapper {
    List<PaperPage> paperPage(int startIndex, int pageSize, int categoryId, int secondId, int threeId, int fourId, int fiveId, int userId);

    int paperCollect(int paperId, int userId);

    int paperNotCollect(int paperId, int userId);

    List<PaperCollect> paperCollectPage(int startIndex, int pageSize, int userId);

    PaperCollect paperCollectJunit(int paperId, int userId);

    @Select("select count(*) from paper where paper_status = 0")
    int paperCount();

    @Select("select count(*) from u_collect where user_id = #{userId}")
    int paperCollectCount(int userId);

    int paperView(int paperId, int userId);

    List<PaperViewPojo> paperViewPage(int startIndex, int pageSize, int userId);


    @Select("select count(*) from u_view where user_id = #{userId}")
    int paperViewCount(int userId);

}
