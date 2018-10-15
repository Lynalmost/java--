/**
 * @author Lyn
 * Manu.java 
 * 
 * 版本 1 2018.9.10	实现基本菜单功能
 * 版本 2 2018.9.25	实现用户注册功能，新建User类用于存放用户信息
 * 版本 3 2018.9.27	实现用户登录&退出功能
 * 版本 4 2018.9.28	实现用户找回密码功能，验证码功能
 * 
 */
package yin.li.second.program;
import java.util.Random;
import java.util.Scanner;

public class Menu {
	//未登录主菜单
	@SuppressWarnings("resource")
	public static void mainMenu() {
		System.out.println("1.登录系统");
		System.out.println("2.系统设置");
		System.out.println("3.写日记");
		System.out.println("4.查找日记");
		System.out.println("5.退出系统");
		System.out.println("请选择：");
		Scanner in = new Scanner(System.in);
		int choice;
		while (!in.hasNextInt()) {
			System.out.println("输入错误，请重新输入：");
			//清空缓存
			in.nextLine();
		}
		choice = in.nextInt();
		
		switch(choice) {
		case 1:
			subMenu2();
			break;
		case 2:
			if (!User.userstatus) {
				System.out.println("请先登录！");
				mainMenu();
			}
			System.out.println("系统设置中…");
			mainMenu();
			break;
		case 3:
			if (!User.userstatus) {
				System.out.println("请先登录！");
				mainMenu();
			}
			System.out.println("写日记中…");
			mainMenu();
			break;
		case 4:
			if (!User.userstatus) {
				System.out.println("请先登录！");
				mainMenu();
			}
			subMenu1();
			break;
		case 5:
			System.out.println("谢谢使用，再见！");
			System.exit(0);
			break;
		default:
			System.out.println("输入错误！请重新输入！");
			mainMenu();
			break;
		}
	}
	//用户登录后主菜单
	@SuppressWarnings("resource")
	public static void mainMenu_login(User user) {		
		while (true) {
			System.out.println("1.[" + user.getNickname() + "]退出登录");
			System.out.println("2.系统设置");
			System.out.println("3.写日记");
			System.out.println("4.查找日记");
			System.out.println("5.退出系统");
			System.out.println("请选择：");
			Scanner in = new Scanner(System.in);
			int choice;
			while (!in.hasNextInt()) {
				System.out.println("输入错误，请重新输入：");
				//清空缓存
				in.nextLine();
			}
			choice = in.nextInt();
		
			switch(choice) {
			case 1:
				System.out.println("是否确认退出？(yes/no)");
				String logout_check = in.next();
				in.nextLine();
				if ("yes".equalsIgnoreCase(logout_check)) {
					System.out.println("退出成功！");
					User.userstatus = false;
					mainMenu();
				} else if ("no".equalsIgnoreCase(logout_check)){
					System.out.println("自动返回主菜单");
					continue;
				} else {
					System.out.println("输入有误！");
					continue;
				}
				break;
			case 2:
				System.out.println("正在执行，系统设置……");
				break;
			case 3:
				System.out.println("正在执行，写日记……");
				break;
			case 4:
				System.out.println("正在执行，查找日记……");
				break;
			case 5:
				return;
			default:
				System.out.println("输入有误，请重新选择：");
				break;
			}
		}
		
	}
	@SuppressWarnings("resource")
	public static void subMenu1() {
		System.out.println("1.按标题查找");
		System.out.println("2.按内容查找");
		System.out.println("3.按日期查找");
		System.out.println("4.按心情查找");
		System.out.println("5.按天气查找");
		System.out.println("6.返回上一级菜单");
		System.out.println("请选择：");
		Scanner in = new Scanner(System.in);
		int choice;
		while (!in.hasNextInt()) {
			System.out.println("输入错误，请重新输入：");
			//清空缓存
			in.nextLine();
		}
		choice = in.nextInt();
		switch(choice) {
		case 1:
			System.out.println("按标题查找…");
			subMenu1();
			break;
		case 2:
			System.out.println("按内容查找…");
			subMenu1();
			break;
		case 3:
			System.out.println("按日期查找…");
			subMenu1();
			break;
		case 4:
			System.out.println("按心情查找…");
			subMenu1();
			break;
		case 5:
			System.out.println("按天气查找…");
			subMenu1();
			break;
		case 6:
			mainMenu();
			break;
		default:
			System.out.println("输入错误！请重新输入！");
			subMenu1();
			break;
		}
		
	}
	
	@SuppressWarnings("resource")
	public static void subMenu2() {
		String username;
		String nickname;
		String password;
		String mailbox;
		
		System.out.println("1.注册");
		System.out.println("2.登录");
		System.out.println("3.找回密码");
		System.out.println("4.返回上一级菜单");
		System.out.println("请选择：");
		Scanner in = new Scanner(System.in);
		int choice;
		while (!in.hasNextInt()) {
			System.out.println("输入错误，请重新输入：");
			//清空缓存
			in.nextLine();
		}
		choice = in.nextInt();
		switch(choice) {
		case 1:
			User user = new User();
			System.out.println("请输入用户名：");	
			System.out.println("只能包含字母、数字和下划线，并且首字母只能为字母，用户名最短不能少于 6 个字符，最长不" + 
					"能超过 20 个字符");
			//清空缓存
			in.nextLine();
			username = in.nextLine();		
			user.setUsername(username);
			
			System.out.println("请输入昵称：");	
			System.out.println("以包含任意字符，但是最小只能为 3 个字符，最长可以为 20 个字符");
			nickname = in.nextLine();
			user.setNickname(nickname);
			
			System.out.println("请输入密码：");	
			System.out.println("必须包含字母数字和特殊符号，密码最短为 8 位，最长不能超过 30 位");
			password = in.nextLine();
			user.setPassword(password);
			
			System.out.println("*选择密保问题（用于密码找回）：");
			while (true) {
				for (String q:User.secruity_ques)
					System.out.println(q);
				int question_num;
				while (!(in.hasNextInt())) {
					System.out.println("输入有误，请重新输入：");
					//清空缓存
					in.nextLine();
				}
				question_num = in.nextInt();
				if (question_num <= 0 || question_num > 5) {
					System.out.println("输入有误，请重新选择：");
				}
				else {
					user.setSecruity_qa(question_num);
					break;
				}
			}		
			in.nextLine();
			System.out.println("请输入邮箱：");	
			mailbox = in.nextLine();
			
			user.setMailbox(mailbox);
			while(!verification());
			System.out.println("\n注册成功！");
			user.showUserinfo();
			User.userinfo.add(user);	
			subMenu2();
			break;
		case 2:
			User user_login = new User();
			System.out.println("请输入用户名：");
			//清空缓存
			in.nextLine();
			username = in.nextLine();
			for (User u:User.userinfo) {
				if (u.getUsername().equals(username)) {
					user_login = u;
					System.out.println("请输入密码：");
					password = in.nextLine();
					while (!user_login.getPassword().equals(password)) {
						System.out.println("密码错误！请重新输入：");
						password = in.nextLine();
					}
					User.userstatus = true;
					System.out.println("登录成功！");
					mainMenu_login(user_login);
					break;
				}				
			}
			System.out.println("该用户不存在，请前往注册！");
			subMenu2();
			break;
		case 3:
			System.out.println("请输入用户名：");
			//清空缓存
			in.nextLine();
			username = in.nextLine();
			User user_forget = null;
			for (User u:User.userinfo) {
				if (u.getUsername().equals(username)) {
					user_forget = u;
					break;
				}				
			}
			if (user_forget != null) {
				if (user_forget.forgetPassword()) {
					System.out.println("密码重置成功！请登录（自动跳转）");
					subMenu2();
				} else {
					System.out.println("验证失败！");
					subMenu2();
				}
				
			} else {
				System.out.println("该用户不存在，请前往注册！");
				subMenu2();
			}
			
			break;
		case 4:
			mainMenu();
			break;
		default:
			break;		
		}		
	}
	//用户验证
	@SuppressWarnings("resource")
	public static boolean verification() {
		Random random = new Random();
		String operator = "+-x÷";
		int a = random.nextInt(10);
		int b = random.nextInt(10);
		int c = random.nextInt(10);
		int result = 0;
		int operator_index1 = random.nextInt(4);
		int operator_index2 = random.nextInt(4);
		System.out.println("*验证");
		System.out.println("请输入算式答案(四舍五入至整数)：");
		System.out.println(a + Character.toString(operator.charAt(operator_index1)) + b + Character.toString(operator.charAt(operator_index2)) + c + "=");
		
		switch(operator_index1) {
		case 0 :
			if (operator_index2 != 2 && operator_index2 != 3) {
				result = a + b;
			}
			break;
		case 1:
			if (operator_index2 != 2 && operator_index2 != 3) {
				result = a - b;
			}
			break;
		case 2:
			result = a * b;
			break;
		case 3:
			while (b == 0)
				b = random.nextInt(10);
			result = a / b;
			break;
		}
		switch(operator_index2) {
		case 0:
			result += c;
			break;
		case 1:
			result -= c;
			break;
		case 2:
			if (operator_index1 == 0)
				result = a + b * c;
			else if (operator_index1 == 1)
				result = a - b * c;	
			else 
				result *= c;
			
			break;		
		case 3:
			while (c == 0)
				c = random.nextInt(10);
			if (operator_index1 == 0) 
				result = a + b / c;
			else if (operator_index1 == 1)
				result = a - b / c;
			else 
				result /= c;
			break;
		}
		Scanner in = new Scanner(System.in);
		int result_input = in.nextInt();
		
		if (result == result_input)
			return true;
		else {
			System.out.println("输入有误！");
			return false;
		}
	
	}
}
