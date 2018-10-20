package program;

import java.io.*;
import java.util.Date;
import java.util.Scanner;

public class Diary {
	private  FileWriter myFileWriter;
	private Date date = new Date();
	private Weather weather;
	private Mood mood;
	private String title;
	private File myDiary;
	
	//构造函数
	public Diary(Date date, Weather weather, Mood mood, String title) {
		this.date = date;
		this.weather = weather;
		this.mood = mood;
		this.title = title;
		//新建日记文件
		String filePath = "D:\\" + title + ".txt";
		System.out.println(filePath);
		
		myDiary = new File(filePath);
		try {
			if (!myDiary.exists()) {
				myDiary.createNewFile();
			}
		} catch (Exception e) {
			System.out.println("新建日记文件操作出错！");
			}
	}
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Weather getWeather() {
		return weather;
	}

	public void setWeather(Weather weather) {
		this.weather = weather;
	}

	public Mood getMood() {
		return mood;
	}

	public void setMood(Mood mood) {
		this.mood = mood;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMyDiary() {
		try {
			InputStream is = new FileInputStream(myDiary);
			byte[] diary = new byte[(int) myDiary.length()];
			int i = 0;
			int index = 0;
			while ((i = is.read()) != -1) {
				diary[index] = (byte) i;
				index++;
			}
			is.close();
			return new String(diary);
		} catch (Exception e) {
			System.out.println("读日记失败,日记不存在");
			return null;
		}
	}
	
	public void setMyDiary(String content) {
		Scanner in = new Scanner(System.in);
		try {
			this.myFileWriter = new FileWriter(this.myDiary, true);
			myFileWriter.write(content);
			myFileWriter.close();
		} catch (Exception e) {
			System.out.println("写日记失败");
		}
	}
	
	public String toString() {	
		return "日期：" + this.date + "/h" + 
			   "天气：" + this.weather + "/h" +
			   "心情：" + this.mood + "/h" +
			   this.title + "/h" + 
			   this.getMyDiary();
	}
}
