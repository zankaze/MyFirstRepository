package com.xa.fourth_p.pojo;

public class PageBean {
    int ParamMin;
    int ParamMax;

    public int getParamMin() {
        return ParamMin;
    }

    public void setParamMin(int paramMin) {
        ParamMin = paramMin;
    }

    public int getParamMax() {
        return ParamMax;
    }

    public void setParamMax(int paramMax) {
        ParamMax = paramMax;
    }

    @Override
    public String toString() {
        return "PageBean{" +
                "ParamMin=" + ParamMin +
                ", ParamMax=" + ParamMax +
                '}';
    }
}
