package com.xa.fourth_p.controller;

import com.xa.fourth_p.dto.Qesdto;
import com.xa.fourth_p.pojo.PageBean;
import com.xa.fourth_p.pojo.TestQes;
import com.xa.fourth_p.pojo.UserInfo;
import com.xa.fourth_p.service.TestQesService;
import com.xa.fourth_p.service.UserService;
import com.xa.fourth_p.utils.EmailUtis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
public class TestQesController {
    @Autowired
    TestQesService tqs;
    @Autowired
    UserService us;
    @RequestMapping("getquestion")//随机出题
    public Object getquestion(HttpSession session){
       Random rd =  new Random();
        List<TestQes> all = tqs.getAll();
        List<TestQes> getqes = new ArrayList<TestQes>();
        for (int i =0;i<5;i++){
            int i1 = rd.nextInt((all.size()+1));
            if(i1!=0){
                getqes.add(all.get(i1-1));
                all.remove(i1-1);
            }else{
                getqes.add(all.get(0));
                all.remove(0);
            }

        }
//        for (TestQes tq:
//                getqes ) {
//            System.out.println(tq);
//        }
        List<Integer> list = new ArrayList<Integer>();
        for(int i2 = 0; i2<getqes.size();i2++){
            list.add(getqes.get(i2).getQesid());
        }
//        for (Integer it:
//                list) {
//            System.out.println(it);
//        }
        session.setAttribute("qid",list);
        return getqes;
//        int i = rd.nextInt(11);
//        if (i<4){
//            i=4;
//        }
//        PageBean pb = new PageBean();
//        pb.setParamMax(i);
//        pb.setParamMin((i-4));
//        List<TestQes> getqes = tqs.getqes(pb);
//        List<Integer> list = new ArrayList<Integer>();
//        for(int i2 = 0; i2<getqes.size();i2++){
//            list.add(getqes.get(i2).getQesid());
//        }
//        session.setAttribute("qid",list);
       // return getqes;
    }

    @RequestMapping("getScore")//得分
    public Object getScore(@RequestBody List<String> answer, HttpSession session){
        List<Integer> list = (ArrayList)session.getAttribute("qid");
        int Score=0;
        if(answer.size()<list.size()){
            return "您还有"+(list.size()-answer.size())+"道题未选择答案哟";
        }
        Qesdto qt = new Qesdto();
        TestQes eXqes = new TestQes();

        for(int i =0; i<list.size();i++){
            qt.setAnswer(answer.get(i));
            qt.setQid(list.get(i));
            eXqes = tqs.getEXqes(qt);
            if(eXqes!=null){

                Score+=10;
            }
            // qt=null;
            eXqes=null;
        }
        session.setAttribute("score",Score);
        return "true";
    }

    @RequestMapping("getScore2")
    public Object getScore2(HttpSession session){
        Integer score = (Integer)session.getAttribute("score");

        return score;
    }

    @RequestMapping("inserQES") //提交问题
    public boolean inserQES(@RequestBody TestQes tq,HttpSession session){
        UserInfo user = (UserInfo) session.getAttribute("user");
        if (tq.getQuestion()!=""&&tq.getExact_answer()!=""&&tq.getAnswer_a()!=""&&tq.getAnswer_b()!=""
                &&tq.getAnswer_c()!=""&&tq.getAnswer_d()!=""){
            tq.setUserid(user.getUserid());
            return tqs.inserQes(tq);
        }else {
            return false;
        }
    }

    @RequestMapping("updateQES")//问题审核通过或驳回
    public boolean updateQES(@RequestParam String tid,@RequestParam String status){
        Integer id = Integer.valueOf(tid);
        TestQes oneQES = tqs.getOneQES(id);
      oneQES.setQuestion_status(status);
        boolean b = tqs.updateQes(oneQES);
        int userid = oneQES.getUserid();
        if(userid!=0){
            UserInfo user = us.getOneUser(userid);
            String email = user.getEmail();
            EmailUtis.sendAuthCodeEmail2(email);
        }

        return b;
    }

    @RequestMapping("getOneQes")//查一个问题
    public Object getOneQes(@RequestParam String tid){
        TestQes oneQES = tqs.getOneQES(Integer.valueOf(tid));

        return oneQES;
    }

    @RequestMapping("getquestionAll")//获取分页数据
    public Object fenye3(@RequestParam String page){
        int pages= Integer.valueOf(page);
        int rows = 5;
        int num1 = (pages*rows+1);
        int num2 = (pages-1)*rows;
        PageBean pb = new PageBean();
        pb.setParamMax(num1);
        pb.setParamMin(num2);
        return tqs.getAllQes(pb);
    }

    @RequestMapping("getNum3")//获取页数
    public Object getNum3(){
        List<Integer> list = new ArrayList<Integer>();
        int rows= 5;
        int rowsnum=tqs.getQesNum();
        int pageNum = rowsnum/rows;
        if (rowsnum % rows !=0){
            pageNum++;
        }
        for (int i =0;i<pageNum;i++){
            list.add(i+1);
        }
        return list;
    }
}
