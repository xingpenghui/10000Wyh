package com.wyh10000.provider.invest;

import com.wyh10000.domain.invest.Increment;
import com.wyh10000.mapper.invest.IncrementMapper;
import com.wyh10000.service.invest.IncrementService;
import com.wyh10000.service.invest.InvestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *@Author feri
 *@Date Created in 2018/9/27 10:35
 */
@Service
public class IncrementProvider implements IncrementService {
    @Autowired
    private IncrementMapper incrementMapper;
    @Override
    public Increment selectByIid(int iid) {
        return incrementMapper.selectByIid(iid);
    }

    @Override
    public List<Increment> selectByUid(int uid) {
        return incrementMapper.selectByUid(uid);
    }
}
