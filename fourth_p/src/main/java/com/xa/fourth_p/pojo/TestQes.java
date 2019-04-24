package com.xa.fourth_p.pojo;

public class TestQes {
    int qesid;
    String question;
    String answer_a;
    String answer_b;
    String answer_c;
    String answer_d;
    String exact_answer;
    String question_status = "false";//问题是否通过审核
    int userid = 0;

    public int getQesid() {
        return qesid;
    }

    public void setQesid(int qesid) {
        this.qesid = qesid;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer_a() {
        return answer_a;
    }

    public void setAnswer_a(String answer_a) {
        this.answer_a = answer_a;
    }

    public String getAnswer_b() {
        return answer_b;
    }

    public void setAnswer_b(String answer_b) {
        this.answer_b = answer_b;
    }

    public String getAnswer_c() {
        return answer_c;
    }

    public void setAnswer_c(String answer_c) {
        this.answer_c = answer_c;
    }

    public String getAnswer_d() {
        return answer_d;
    }

    public void setAnswer_d(String answer_d) {
        this.answer_d = answer_d;
    }

    public String getExact_answer() {
        return exact_answer;
    }

    public void setExact_answer(String exact_answer) {
        this.exact_answer = exact_answer;
    }

    public String getQuestion_status() {
        return question_status;
    }

    public void setQuestion_status(String question_status) {
        this.question_status = question_status;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    @Override
    public String toString() {
        return "TestQes{" +
                "qesid=" + qesid +
                ", question='" + question + '\'' +
                ", answer_a='" + answer_a + '\'' +
                ", answer_b='" + answer_b + '\'' +
                ", answer_c='" + answer_c + '\'' +
                ", answer_d='" + answer_d + '\'' +
                ", exact_answer='" + exact_answer + '\'' +
                ", question_status='" + question_status + '\'' +
                ", userid=" + userid +
                '}';
    }
}
