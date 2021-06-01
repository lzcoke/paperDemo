package com.lzcoke.mapper;

import com.lzcoke.pojo.*;

import java.util.List;

public interface CategoryMapper {

    List<CategoryFirst> CategoryPage();

    List<CategorySecond> SecondPage(int categoryId);

    List<CategoryThree> ThreePage(int categoryId, int secondId);

    List<CategoryFour> FourPage(int categoryId, int secondId, int threeId);

    List<CategoryFive> FivePage(int categoryId, int secondId, int threeId, int fourId);

}

