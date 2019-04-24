package com.xa.fourth_p.service;

import com.xa.fourth_p.dto.Qesdto;
import com.xa.fourth_p.pojo.PageBean;
import com.xa.fourth_p.pojo.TestQes;

import java.util.List;

public interface TestQesService {
    public List<TestQes> getqes(PageBean pb);
    public TestQes getEXqes(Qesdto dto);
    public boolean inserQes(TestQes tq);
    public boolean updateQes(TestQes tq);
    public TestQes getOneQES(int tid);

    public List<TestQes> getAllQes(PageBean pb);
    public int getQesNum();

    public List<TestQes>getAll();
}
