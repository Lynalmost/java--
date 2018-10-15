/**
 * @author Lyn
 * 作用：用户类，用于存放用户个人信息
 * 版本1 2018.9.25	完成基本信息设定
 * 版本2 2018.9.27 	新增resetPassword()方法
 * 版本3 2018.9.28	新增静态数组secruity_ques用于存放密保问题，setSecruity_qa方法
 */
package yin.li.second.menu;
import java.util.ArrayList;
import java.util.*;
import java.util.Scanner;

@SuppressWarnings("unused")
public class User {
	//用于存放注册用户信息
	@SuppressWarnings({ "unchecked", "rawtypes" })
	static ArrayList<User> userinfo = new ArrayList();
	static String[] secruity_ques = new String[5]; 	
	static boolean userstatus;
	private String username;
	private String nickname;
	private String password;
	private String mailbox;
	private String[] secruity_qa = new String[2];
	
	//初始化secruity_ques
	static {
		secruity_ques[0] = "1.你的母校名？";
		secruity_ques[1] = "2.你的出生地在哪里？";
		secruity_ques[2] = "3.你的高中班主任名字？";
		secruity_ques[3] = "4.你的兴趣爱好？";
		secruity_ques[4] = "5.你的大学名？";
	}	
	public String getUsername() {
		return username;
	}
	//设置用户名
	@SuppressWarnings("resource")
	public void setUsername(String username) {
		Scanner in = new Scanner(System.in);
		//判断用户名是否存在
		boolean isExists = true;
		while(isExists) {
			boolean isBreak = false;
			for (User u:userinfo) {
				if (u.getUsername().equals(username)) {
					System.out.println("用户名已存在，请重新输入：");
					username = in.nextLine();
					isBreak = true;
					break;
				}				
			}
			if (!isBreak)
				isExists = false;
		}			
		String username_regex = "^[a-zA-Z]([_a-zA-Z0-9]{5,19})$";
		while (!username.matches(username_regex)) {
			System.out.println("用户名输入有误！请重新输入:");
			username = in.nextLine();
		}
		this.username = username;
	}
	public String getNickname() {
		return nickname;
	}
	//设置昵称
	@SuppressWarnings("resource")
	public void setNickname(String nickname) {
		Scanner in = new Scanner(System.in);
		String nickname_regex = "^.{3,20}$";
		while (!nickname.matches(nickname_regex)) {
			System.out.println("昵称输入有误！请重新输入:");
			nickname = in.nextLine();
		}
		this.nickname = nickname;
	}
	public String getPassword() {
		return password;
	}
	//设置密码
	@SuppressWarnings("resource")
	public void setPassword(String password) {
		String password_check;
		Scanner in = new Scanner(System.in);
		String password_regex = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[$@$!%*#?&.])[\\w$@$!%*#?&.]{8,30}$";
		boolean last_ack = false;
		while (!last_ack) {
			while (!password.matches(password_regex)) {
				System.out.println("密码格式有误！请重新输入:");
				password = in.nextLine();
			}
			System.out.println("请确认密码：");	
			password_check = in.nextLine();
			if (password.equals(password_check)) {
				last_ack = true;
				this.password = password;
			}
			else {
				System.out.println("密码格式有误！请重新输入:");
			}
		}
	}
	public String getMailbox() {
		return mailbox;
	}
	
	//设置邮箱
	@SuppressWarnings("resource")
	public void setMailbox(String mailbox) {
		Scanner in = new Scanner(System.in);
		//判断邮箱是否存在
		boolean isExists = true;
		while(isExists) {
			boolean isBreak = false;
			for (User u:userinfo) {
				if (u.getMailbox().equals(mailbox)) {
					System.out.println("邮箱已绑定，请重新输入：");
					mailbox = in.nextLine();
					isBreak = true;
					break;
				}				
			}
			if (!isBreak)
				isExists = false;
		}	
		String mailbox_regex  = "[\\w!#$%&'*+/=?^_`{|}~-]+(?:\\.[\\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\\w](?:[\\w-]*[\\w])?\\.)+[\\w](?:[\\w-]*[\\w])?";
		while (!mailbox.matches(mailbox_regex)) {
			System.out.println("邮箱格式有误！请重新输入:");
			mailbox = in.nextLine();
		}
		this.mailbox = mailbox;
	}
	
	@SuppressWarnings("resource")
	public void setSecruity_qa(int question_num) {
		Scanner in = new Scanner(System.in);
		this.secruity_qa[0] = secruity_ques[question_num - 1];
		System.out.println("请输入问题答案：");
		this.secruity_qa[1] = in.nextLine();
	}
	
	//重置密码
	@SuppressWarnings("resource")
	public void resetPassword() {
		String password;
		String password_check;
		Scanner in = new Scanner(System.in);
		System.out.println("请输入新密码：");	
		System.out.println("必须包含字母数字和特殊符号，密码最短为 8 位，最长不能超过 30 位");
		String password_regex = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[$@$!%*#?&.])[\\w$@$!%*#?&.]{8,30}$";
		boolean last_ack = false;
		while (!last_ack) {
			password = in.nextLine();
			while (!password.matches(password_regex)) {
				System.out.println("密码格式有误！请重新输入:");
				password = in.nextLine();
			}
			System.out.println("请确认密码：");	
			password_check = in.nextLine();
			if (password.equals(password_check)) {
				last_ack = true;
				this.password = password;
			}
			else {
				System.out.println("密码格式有误！请重新输入:");
			}
		}
	}
	//忘记密码
	@SuppressWarnings("resource")
	public boolean forgetPassword() {
		Scanner in = new Scanner(System.in);
		System.out.println("请回答密保问题：" + this.secruity_qa[0].substring(2));
		if (in.nextLine().equals(this.secruity_qa[1])) {
			resetPassword();
			return true;
		} else {
			return false;
		}		
	}
	
	public void showUserinfo() {
		System.out.println("\n用户信息：");
		System.out.println("用户名：" + this.username);
		System.out.println("昵称：" + this.nickname);
		System.out.println("邮箱：" + this.mailbox);
		
	}
}
