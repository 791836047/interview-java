package com.java.interview.other.design.templatePattern;

/**
 * @author liaowenhui
 * @date 2022/4/14 14:44
 */
public abstract class Game {
    abstract void initialize();
    abstract void startPlay();
    abstract void endPlay();

    //模板
    public final void play(){

        //初始化游戏
        initialize();

        //开始游戏
        startPlay();

        //结束游戏
        endPlay();
    }
}
