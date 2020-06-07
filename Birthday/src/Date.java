import java.util.*;
public class Date {
	private int year;
	private int month;
	private int day;
	
	public Date(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;
	}
	
	public Date() {
		int daysSinceEpoch = (int) ((System.currentTimeMillis() + TimeZone.getDefault().getRawOffset()) / 1000 / 60 / 60 / 24);
		Date epochDay= new Date(1970,1,1);
		//using nextDay method to find today's date
		for(int i=daysSinceEpoch; i>0;i--){
			epochDay.nextDay();
		}
		year = epochDay.year;
		month = epochDay.month;
		day = epochDay.day;
		year = 2010;
		month = 1;
		day = 30;
	}
	
	
	public int getDay() {
		return day;
	}
	public int getMonth() {
		return month;
	}
	public int getYear() {
		return year;
	}
	public String toString() {
		return ""+year+"/"+month+"/"+day;
	}
	
	
	public String getDayOfWeek() {
		String[] week = new String[] {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
		Date start = new Date(1753,1,1);
		int i=0;
		while(!this.equals(start)) {
			start.nextDay();
			i += 1;
		}
		return week[i%7];
	}
	
	public boolean isLeapYear() {
		if(year%400==0 || (year%100!=0 && year%4==0)){
			return true;
		}else{
			return false;
		}
	}
	
	public void nextDay() {
		int[] dim = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		int[] dimleap = new int[]{31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		if(this.isLeapYear()){
			next(dimleap);
		}else{
			next(dim);
		}
	}
	public void next(int[] dim){
		if(day < dim[month-1]){
			day++;
		}else if(month < 12){
			day=1;
			month++;
		}else{
			day=1;
			month=1;
			year++;
		}
	}
	
	public boolean equals(Object o) {
		if (o instanceof Date) {
			Date other = (Date) o;
			return other.getDay()==day && other.getMonth()==month && other.getYear()==year;
		}else {
			return false;
		}
	}

}
