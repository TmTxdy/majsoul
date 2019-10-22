package com.example.demo.image;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

//图片切割
public class ImageCut {

	public static void splitImage() throws IOException {
		 
        //String originalImg = "C:\\img\\split\\a380_1280x1024.jpg";
        String originalImg = "D:\\sts-workspace\\majsoul\\src\\main\\resources\\static\\img/1.jpg";
        // 读入大图
        File file = new File(originalImg);
        FileInputStream fis = new FileInputStream(file);
        BufferedImage image = ImageIO.read(fis);
 
        // 分割成3*3(9)个小图
        int rows = 1;
        int cols = 13;
        int chunks = rows * cols;
 
        // 计算每个小图的宽度和高度
//        int chunkWidth = (image.getWidth()-90) / cols;
//        int chunkHeight = image.getHeight() / rows;
        int chunkWidth = 52;
        int chunkHeight = 89;
        
        int count = 0;
        BufferedImage imgs[] = new BufferedImage[chunks];
        for (int x = 0; x < rows; x++) {
            for (int y = 0; y < cols; y++) {
            	int juli = 0;
            	if(y>0 && y<12) {
            		juli = 3*y;
            	}
            	if(y==12) {
            		juli = 108;
            	}
                //设置小图的大小和类型
                imgs[count] = new BufferedImage(chunkWidth, chunkHeight, image.getType());
 
                //写入图像内容
                Graphics2D gr = imgs[count++].createGraphics();
                gr.drawImage(image, 0, 0,
                        chunkWidth, chunkHeight,
                        chunkWidth* y+juli, chunkHeight * x,
                        chunkWidth * y+juli + chunkWidth,
                        chunkHeight * x + chunkHeight, null);
                gr.dispose();
            }
        }
 
        // 输出小图
        for (int i = 0; i < imgs.length; i++) {
            //ImageIO.write(imgs[i], "jpg", new File("C:\\img\\split\\img" + i + ".jpg"));
            ImageIO.write(imgs[i], "jpg", new File("D:\\sts-workspace\\majsoul\\src\\main\\resources\\static\\img/" + i + ".jpg"));
        }
 
        System.out.println("完成分割！");
    }
	
}
