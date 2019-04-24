package com.xa.fourth_p;

import com.xa.fourth_p.pojo.PageBean;
import com.xa.fourth_p.pojo.TestQes;
import com.xa.fourth_p.service.TestQesService;
import com.xa.fourth_p.utils.EmailUtis;
import com.xa.fourth_p.utils.MD5;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FourthPApplicationTests {

    @Autowired
    TestQesService tqs;
    @Test
    public void contextLoads() {

        Random rd =  new Random();
        List<TestQes> all = tqs.getAll();
        List<TestQes> getqes = new ArrayList<TestQes>();
        int num = 101;
        for (int i =0;i<5;i++){
            int i1 = rd.nextInt(31);
            if(i1 != num){
                getqes.add(all.get(i1));
                all.remove(i1);
            }
            num=i1;
        }
        for (TestQes tq:
                getqes ) {
            System.out.println(tq);
        }
        List<Integer> list = new ArrayList<Integer>();
        for(int i2 = 0; i2<getqes.size();i2++){
            list.add(getqes.get(i2).getQesid());
        }
        for (Integer it:
                list) {
            System.out.println(it);
        }

    }

}
