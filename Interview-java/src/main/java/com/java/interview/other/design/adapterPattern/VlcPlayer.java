package com.java.interview.other.design.adapterPattern;

/**
 * @author liaowenhui
 * @date 2023/4/6 14:20
 */
public class VlcPlayer implements AdvancedMediaPlayer{
    @Override
    public void playVlc(String fileName) {
        System.out.println("Playing vlc file. Name: "+ fileName);
    }

    @Override
    public void playMp4(String fileName) {
        //什么也不做
    }
}
