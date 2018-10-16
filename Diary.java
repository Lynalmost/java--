/**
 * @author Lyn
 * @time 2018.10.16
 */
package yin.li.second.program;
import java.io.*;
import java.util.Date;

public class Diary {
	private  FileWriter myFileWriter;
	private  FileReader myFileReader;
	private Date date = new Date();
	private Weather weather = Weather.NULL;
	private Mood mood = Mood.NULL;
	private String title;
	private File myDiary;
	
	//构造函数
	public Diary(Date date, Weather weather, Mood mood, String title) {
		this.date = date;
		this.weather = weather;
		this.mood = mood;
		this.title = title;
		//新建日记文件
		String fileName = "D:\\" + date + title + ".txt";
		myDiary = new File(fileName);
		try {
			if (!myDiary.exists()) {
				myDiary.createNewFile();
			}
		} catch (Exception e) {
			System.out.println("新建日记操作出错！");
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

	public void getMyDiary() {
		try {
			//按行读取日记
			this.myFileReader = new FileReader(this.myDiary);
			BufferedReader reader = new BufferedReader(myFileReader);
			String tempString = null;  
			while ((tempString = reader.readLine()) != null) {  
			    System.out.println(tempString);  
			}
			myFileReader.close();
			reader.close();
		} catch (Exception e) {
			System.out.println("读日记失败,日记不存在");
		}
	}
	public void setMyDiary() {
		try {
			this.myFileWriter = new FileWriter(this.myDiary, true);
			
		} catch (Exception e) {
			System.out.println("写日记失败");
		}
	}
}
