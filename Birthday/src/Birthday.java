import java.util.*;
public class Birthday {
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		System.out.print("What month, day, and year were you born? ");
		int month = console.nextInt();
		int day = console.nextInt();
		int year = console.nextInt();
		Date birthday = new Date(year,month,day);
		Date today = new Date(); // 2010,1,30 for test
		general(birthday);
		calculate(birthday,today);
	}
	
	// print birthday and leap year.
	public static void general(Date birthday){
		System.out.print("You were born on "+birthday.toString());
		System.out.println(", which was a "+birthday.getDayOfWeek()+".");
		if(birthday.isLeapYear()){
			System.out.println(birthday.getYear()+" was a leap year.");
		}
	}
	
	
	/*
	 * calculate # days until next birthday
	 * calculate # days from birthday to today
	 */
	public static void calculate(Date b,Date t){
		Date temp1 = new Date(b.getYear(),b.getMonth(),b.getDay());
		Date temp2 = new Date(t.getYear(),t.getMonth(),t.getDay());
		if(b.getDay()==t.getDay() && b.getMonth()==t.getMonth()){
			int a = t.getYear()-b.getYear();
			System.out.println("Happy birthday! You are now age "+a+".");
		}
		else{
			int count=0;
			while(!(temp2.getDay()==b.getDay() && temp2.getMonth()==b.getMonth())){
				temp2.nextDay();
				count++;
			}
			System.out.println("It will be your birthday in "+count+" days.");
		}
		
		int num=0;
		while(!(temp1.getYear()==t.getYear() && temp1.getMonth()==t.getMonth() && temp1.getDay()==t.getDay())){
			temp1.nextDay();
			num++;
		}
		System.out.println("You are "+num+" days old.");
	}
	

}
