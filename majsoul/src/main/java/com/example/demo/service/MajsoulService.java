package com.example.demo.service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo.image.GetImage;
import com.example.demo.image.ImageCut;
import com.example.demo.image.ImgSimilarity;

@Service
public class MajsoulService {

	public Map<String, Integer> query(){
		Map<String, Integer> map = new HashMap<String, Integer>();
		try {
			Thread.sleep(5000);
			new GetImage().image();
			ImageCut.splitImage();
			Double compareImage = ImgSimilarity.getSimilarity(new File("D:\\sts-workspace\\majsoul\\src\\main\\resources\\static\\img/6.jpg"),
					new File("D:\\sts-workspace\\majsoul\\src\\main\\resources\\static\\img/7.jpg"));
			System.out.println("compareImage:"+compareImage);
			Integer patrol = getPatrol();
			
//			map.put("lizhi", value);
//			map.put("nolizhi", value);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return map;
	}
	
	/**
	 * 自动获取巡数
	 * @return
	 * @throws IOException 
	 */
	private Integer getPatrol() throws IOException {
		
		for(int x=0;x<20;x++) {
			Double compareImage1 = ImgSimilarity.getSimilarity(new File("D:\\sts-workspace\\majsoul\\src\\main\\resources\\static\\img/"+x+".jpg"),
					new File("D:\\sts-workspace\\majsoul\\src\\main\\resources\\static\\img/"+(x+1)+".jpg"));
			System.out.println("compareImage1:"+compareImage1);
			if(compareImage1==100) {
				//防止出现两张牌连打的情况
				Double compareImage2 = ImgSimilarity.getSimilarity(new File("D:\\sts-workspace\\majsoul\\src\\main\\resources\\static\\img/"+(x+1)+".jpg"),
						new File("D:\\sts-workspace\\majsoul\\src\\main\\resources\\static\\img/"+(x+2)+".jpg"));
				System.out.println("compareImage2:"+compareImage2);
				if(compareImage2==100) {
					return x-1;
				}
			}
		}
		return -1;
	}
	
	public static void main(String[] args) throws IOException {
		Double compareImage = ImgSimilarity.getSimilarity(new File("D:\\sts-workspace\\majsoul\\src\\main\\resources\\static\\img/12.jpg"),
				new File("D:\\sts-workspace\\majsoul\\src\\main\\resources\\static\\img/13.jpg"));
		System.out.println("compareImage:"+compareImage);
		MajsoulService majsoulService = new MajsoulService();
		Integer patrol = majsoulService.getPatrol();
		System.out.println(patrol);
	}
}
