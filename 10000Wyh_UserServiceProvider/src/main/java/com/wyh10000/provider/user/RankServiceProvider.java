package com.wyh10000.provider.user;

import com.wyh10000.common.result.R;
import com.wyh10000.common.util.ResultUtil;
import com.wyh10000.domain.Rank;
import com.wyh10000.mapper.user.RankMapper;
import com.wyh10000.service.user.RankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *@Author feri
 *@Date Created in 2018/9/14 10:17
 */
@Service
public class RankServiceProvider implements RankService {
    @Autowired
    private RankMapper rankMapper;
    @Override
    public R save(Rank rank) {
        return ResultUtil.createResult(rankMapper.insert(rank));
    }

    @Override
    public List<Rank> queryByUid(int uid) {
        return rankMapper.selectByUid(uid);
    }
}
