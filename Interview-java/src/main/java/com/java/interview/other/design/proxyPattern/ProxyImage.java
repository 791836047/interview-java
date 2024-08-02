package com.java.interview.other.design.proxyPattern;

/**
 * @author liaowenhui
 * @date 2023/4/6 11:01
 */
public class ProxyImage implements Image{

    private RealImage realImage;
    private String fileName;

    public ProxyImage(String fileName){
        this.fileName = fileName;
    }

    @Override
    public void display() {
        if(realImage == null){
            realImage = new RealImage(fileName);
        }
        realImage.display();
    }
}
