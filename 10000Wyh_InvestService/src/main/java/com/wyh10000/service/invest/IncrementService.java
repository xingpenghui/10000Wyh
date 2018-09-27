package com.wyh10000.service.invest;

import com.wyh10000.domain.invest.Increment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *@Author feri
 *@Date Created in 2018/9/27 10:34
 */
public interface IncrementService {

    Increment selectByIid(int iid);
    List<Increment> selectByUid(int uid);
}
