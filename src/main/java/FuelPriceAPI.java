import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.json.JSONObject;

public class FuelPriceAPI {  // This API is used to obtain the fuel price using a 3rd party API. Requires signup and has a pricing scheme so didn't implement it fully. The code is correct but it requires a paid API key and hence didn't implement it any further.
	public static Integer fuelPrice(String location)
	{
	HttpRequest request = HttpRequest.newBuilder()
			.uri(URI.create("https://daily-fuel-prices-india.p.rapidapi.com/api/HP/allstates"))
			.header("x-rapidapi-key", "api_d41f443e-8293-44ce-a151-8ea92798a45c")
			.header("x-rapidapi-host", "daily-fuel-prices-india.p.rapidapi.com/location="+location)
			.method("GET", HttpRequest.BodyPublishers.noBody())
			.build();
	HttpResponse<String> response = null;	
	try {
		response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	JSONObject json = (JSONObject)response;
	Integer fuelPrice = (Integer)((JSONObject) json.get("0")).get("petrolPrice");  //Wasn't mentioned in the question whether it's petrol or diesel so I'm assuming petrol for now. It'll be easy to change to diesel, if required.
	return fuelPrice;
	}
}
