import java.util.*;
import java.io.*;
import java.lang.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


class Ping{
private static final Pattern PATTERN = Pattern.compile(
        "^(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.){3}([01]?\\d\\d?|2[0-4]\\d|25[0-5])$");
    
public static boolean validate(final String ip) {
    return PATTERN.matcher(ip).matches();
}
public static void oddPing(String odd)
{
    float f = Float.parseFloat(odd);
    System.out.println("Median of ping : " + f +"\n");
}
public static void evenPing(String mid,String next_mid)
{
    float f1 = Float.parseFloat(mid);
    float f2 = Float.parseFloat(next_mid);
    float f3 = (f1 + f2 )/2 ;
    System.out.println("\nMedian of ping : " + f3 +"\n");
}
public void computeMedian(String ip,int n)
{   
    String pingResult = "";
    
    String pingCmd = "ping " + ip + " -c" +" " + n;

    try{
         Runtime run = Runtime.getRuntime();
         Process processPing = run.exec(pingCmd);
         BufferedReader in = new BufferedReader(new InputStreamReader(processPing.getInputStream()));
         String inputLine;
         while ((inputLine = in.readLine()) != null) {
           System.out.println(inputLine);
           pingResult += inputLine;
    }
    in.close();

    List<String> time = new ArrayList<String>();
    int i = 0;
    for(i=0;i<n;i++)
     {
        pingResult = pingResult.substring(pingResult.indexOf("time="));
        time.add(pingResult.substring(5,10));
        pingResult = pingResult.substring(10); 
     }

     int d = time.size()/2;
     int re = time.size()%2;
     if(re == 1){
        Ping.oddPing(time.get(d));
       }

     else{
       Ping.evenPing(time.get(d-1),time.get(d));
    
}
     }

catch(Exception e)
{
    System.out.println(e);
}
}


	public static void main(String[] args)
	{
        String ip;int n;
        Ping pingObj = new Ping();
        while(true)
        {
        System.out.println("Enter host address : \n");
        Scanner sc = new Scanner(System.in);
        ip = sc.next(); 
        boolean check = validate(ip);
        if(check)
        {
            System.out.println("Enter how many times to ping : \n");
            n = sc.nextInt();
            pingObj.computeMedian(ip,n);
        }
        else{
    
        System.out.println("Please enter valid ip  \n");
    
        }
    }

    }
}

