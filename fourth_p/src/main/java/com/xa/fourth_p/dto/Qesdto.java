package com.xa.fourth_p.dto;

public class Qesdto {
    int qid;
    String answer;

    public int getQid() {
        return qid;
    }

    public void setQid(int qid) {
        this.qid = qid;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "Qesdto{" +
                "qid=" + qid +
                ", answer='" + answer + '\'' +
                '}';
    }
}
