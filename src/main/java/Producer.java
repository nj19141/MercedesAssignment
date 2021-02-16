import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import com.maxmind.geoip2.exception.GeoIp2Exception;

public class Producer {

	public static void main(String[] args) {
		InetAddress ip = null;
        String hostname = null;
        try {
            ip = InetAddress.getLocalHost();
            hostname = ip.getHostName();        
        } catch (UnknownHostException e) {
 
            e.printStackTrace();
        }	    
        String cityName=null;
		try {
			cityName = FindLocationAPI.cityForIP(ip);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (GeoIp2Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        User user = new User((long) 1, "Otavio", "Tarelho", (long) 100, "otavio.barros@avenuecode.com",ip);

	    new EventBus().publishEvent(tankOpen(),cityName);

	}
	public static boolean tankOpen() //This function returns true or false based on the external input
	{
		//For now I am using a random function to randomly return true or false
		double a = Math.random()*100;
		if(100-a>a)
		{
			return false;
		}
		else
			return true;
		
	}

}
