package com.wqy.speech;

import java.util.List;

/**
 * @author WordK 王秋叶
 * @create 2018-07-05 9:18
 * @desc
 **/
public class Ws {
    private int bg;

    private List<Cw> cw ;

    public void setBg(int bg){
        this.bg = bg;
    }
    public int getBg(){
        return this.bg;
    }
    public void setCw(List<Cw> cw){
        this.cw = cw;
    }
    public List<Cw> getCw(){
        return this.cw;
    }

}
