package com.example.demo.image;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

//截图   分辨率1366*768
public class GetImage{
 
    int height = 88;
    int width = 785;
 
    String saveDir = "D:\\sts-workspace\\majsoul\\src\\main\\resources\\static\\img/";
//    String saveDir = "D:/image/";
    int imageName = 1;
    String imageFormat = "jpg";
 
 
    public void image(){
 
        try {
        	
            Rectangle rectangle = new Rectangle(257,636,width,height);
 
            Robot robot  = new Robot();
 
            BufferedImage image = robot.createScreenCapture(rectangle);
 
            ImageIO.write(image, imageFormat, new File(saveDir, imageName++ + "." + imageFormat));
 
        } catch (Exception e) {
            e.printStackTrace();
        }
 
    }
 
    public static void main(String[] args)throws Exception {
//        Timer t = new Timer();
        //在指定时间安排指定任务
        //第一个参数,是安排的任务,第二个参数是执行的时间,第三个参数是过多长时间再重复执行
//        Date date = new Date();
//        t.schedule(new GetImage(), date,30000);
    	Thread.sleep(5000);
    	new GetImage().image();
    }
}