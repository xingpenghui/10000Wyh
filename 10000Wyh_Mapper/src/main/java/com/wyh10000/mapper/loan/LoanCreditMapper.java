package com.wyh10000.mapper.loan;

import com.wyh10000.domain.loan.LoanCredit;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LoanCreditMapper {

    int insert(LoanCredit record);
    LoanCredit selectById(Integer id);
    List<LoanCredit> selectByUId(Integer uid);
    int updateFlag(@Param("id") int id, @Param("flag") int flag);
}