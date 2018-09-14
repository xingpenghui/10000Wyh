package com.wyh10000.service.user;

import com.wyh10000.common.result.R;
import com.wyh10000.domain.Rank;

import java.util.List;

/**
 *@Author feri
 *@Date Created in 2018/9/14 10:12
 */
public interface RankService {
    R save(Rank rank);
    List<Rank> queryByUid(int uid);

}
