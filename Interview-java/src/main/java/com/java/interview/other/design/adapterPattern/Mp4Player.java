package com.java.interview.other.design.adapterPattern;

/**
 * @author liaowenhui
 * @date 2023/4/6 14:20
 */
public class Mp4Player implements AdvancedMediaPlayer{
    @Override
    public void playVlc(String fileName) {
        //什么也不做
    }

    @Override
    public void playMp4(String fileName) {
        System.out.println("Playing mp4 file. Name: "+ fileName);
    }
}
