package com.xa.fourth_p.service.imp;

import com.xa.fourth_p.dto.Qesdto;
import com.xa.fourth_p.mapper.TestQesMapper;
import com.xa.fourth_p.pojo.PageBean;
import com.xa.fourth_p.pojo.TestQes;
import com.xa.fourth_p.service.TestQesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestQesServiceImp implements TestQesService {
    @Autowired
    TestQesMapper tqm;

    public List<TestQes> getqes(PageBean pb) {
        return tqm.getqes(pb);
    }

    public TestQes getEXqes(Qesdto dto) {
        return tqm.getEXqes(dto);
    }

    public boolean inserQes(TestQes tq) {
        tqm.inserQes(tq);
        return true;
    }

    public boolean updateQes(TestQes tq) {
        tqm.updateQes(tq);
        return true;
    }

    public TestQes getOneQES(int tid) {
        return tqm.getOneQES(tid);
    }

    @Override
    public List<TestQes> getAllQes(PageBean pb) {
        return tqm.getAllQes(pb);
    }

    @Override
    public int getQesNum() {
        return tqm.getQesNum();
    }

    @Override
    public List<TestQes> getAll() {
        return tqm.getAll();
    }
}
