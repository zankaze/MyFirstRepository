package com.xa.fourth_p.mapper;

import com.xa.fourth_p.dto.Qesdto;
import com.xa.fourth_p.pojo.PageBean;
import com.xa.fourth_p.pojo.TestQes;

import java.util.List;

public interface TestQesMapper {
    public List<TestQes> getqes(PageBean pb);
    public TestQes getEXqes(Qesdto dto);
    public void inserQes(TestQes tq);
    public void updateQes(TestQes tq);
    public TestQes getOneQES(int tid);

    public List<TestQes> getAllQes(PageBean pb);
    public int getQesNum();

    public List<TestQes>getAll();
}
