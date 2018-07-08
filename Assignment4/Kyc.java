import java.util.*;
import java.text.*;
import java.lang.*;
class Kyc
{
	public static void rangeCalculation(String signup, String current) throws Exception
	{ 
	  SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	  Date date1=null;Date date2=null;
	  Date anni=null;Date original=null;
	  Date plus=null;Date minus=null;

	  //converting string into Date object
	  date1=dateFormat.parse(signup);
	  date2=dateFormat.parse(current);
	  //for calendarculating the year of current date
	  Calendar calendar = Calendar.getInstance();
	  calendar.setTime(date2);
	  int curr_year=calendar.get(Calendar.YEAR);
	  //for calendarculating year of signup date
	  Calendar calendar2 = Calendar.getInstance();
	  calendar2.setTime(date1);
	  int sign_year=calendar2.get(Calendar.YEAR);
	  //calendarculating difference between year of current date and signup date
	  int diff=curr_year-sign_year;
	  //calculating three possible anniversary with curr_year,curr_year-1 and curr_year+1
	  Calendar calendar1 = Calendar.getInstance();
	  calendar1.setTime(date1);
	  calendar1.add(Calendar.YEAR,diff);
	  original=calendar1.getTime();
	 // System.out.println(original);
	  calendar1.add(Calendar.YEAR,-1);
	  minus=calendar1.getTime();
	 // System.out.println(minus);
	  calendar1.add(Calendar.YEAR,2);
	  plus=calendar1.getTime();
	  //System.out.println(plus);
	  
	  //calculating closest anniversary Date 
	  long ori=Math.abs(date2.getTime()-original.getTime());
	  //System.out.println(ori);
	  long min=Math.abs(date2.getTime()-minus.getTime());
	  //System.out.println(min);
	  long plu=Math.abs(date2.getTime()-plus.getTime());
	  //System.out.println(plu);
	  long smallest = Math.min(ori, Math.min(min, plu));
      if(smallest==ori)
      	anni=original;
      else if(smallest==min)
      	anni=minus;
      else
      	anni=plus;
      
       //now calendarculatnig the Range
       Date first=null;
       Date second=null;
       Calendar calendar3 = Calendar.getInstance();
       calendar3.setTime(anni);
       //fist is the date that is before 30 days of anniversary
       calendar3.add(Calendar.DATE,-30);
       first=calendar3.getTime();
       //second is the date that is after 30 days of anniversary
       calendar3.add(Calendar.DATE,60);
       second=calendar3.getTime();
       //System.out.println(second);
       //now comparing dates of Range to not include date of future
        
	  if(!first.before(date2)&&!second.before(date2))
	  	System.out.println("No Range");
	  else if(!second.before(date2))
	     {  String str=dateFormat.format(first);
            String str1=dateFormat.format(date2);
            System.out.println(str+ " " + str1);
	      }
	   else
	   	  { String str2=dateFormat.format(first);
	   	  	String str3=dateFormat.format(second);
	   	  	System.out.println(str2+ " " + str3);
	   	  	 }


    }
    public static void main(String[] args) throws Exception {
    	Scanner sc = new Scanner(System.in);
    	System.out.println("Enter number of test cases : \n");
        int n=sc.nextInt();
       while(n!=0)
    	{ 
    	  System.out.println("Enter the signup date and current date");
    	  String signup=sc.next();
    	  String current=sc.next();
    	  System.out.println("\nRange is");
    	  Kyc.rangeCalculation(signup,current);
    	  n--;
    	}
    }
}