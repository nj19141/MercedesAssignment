import java.io.File;
import java.io.IOException;
import java.net.InetAddress;

import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CityResponse;

public class FindLocationAPI {

	public static String cityForIP(InetAddress ipString) throws IOException, GeoIp2Exception { 
	    String dbLocation = ""; //Contains the location of the city database on current machine and can also be found at https://dev.maxmind.com/geoip/geoip2/geolite2/, left blank for now. We can also use application.properties file to store it
	        
	    File database = new File(dbLocation);
	    DatabaseReader dbReader = new DatabaseReader.Builder(database).build();
	        
	    InetAddress ipAddress = ipString; // Contains the current IPAddress which is mapped to the city in the database above
	    CityResponse response = dbReader.city(ipAddress);
	        
	    String countryName = response.getCountry().getName();
	    String cityName = response.getCity().getName();        //Only this field is relevant to our needs
	    String postal = response.getPostal().getCode();
	    String state = response.getLeastSpecificSubdivision().getName();
	    
	    return cityName;
	}
}
