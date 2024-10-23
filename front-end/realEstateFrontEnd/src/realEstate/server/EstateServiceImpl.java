package realEstate.server;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import java.io.File;
import java.lang.reflect.Type;

import realEstate.client.EstateService;
import realEstate.shared.Estat;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.json.client.JSONNumber;
import com.google.gwt.json.client.JSONValue;

@SuppressWarnings("serial")
public class EstateServiceImpl extends RemoteServiceServlet implements EstateService {

	/**
	 * Create a List of Estate objects from jsonResponse
	 * @param jsonResponse
	 * @return
	 */
	@Override
	public List<Estat> parseEstates(String jsonResponse) throws IllegalArgumentException {
		Gson gson = new Gson();
	    Type estateListType = new TypeToken<List<Estat>>() {}.getType();
	    List<Estat> estateNames = gson.fromJson(jsonResponse, estateListType);
	    return estateNames;
	}
	
	@Override
	public String estateFormToJsonString(
			String title, String description, double price, String country, String city, 
			String cp, int number, String street, int surface, String owner) throws IllegalArgumentException {

		return "{"
		        + "\"owner\": {\"email\": \""+owner+"\"},"
		        + "\"country\": \""+country+"\","
		        + "\"city\": \""+city+"\","
		        + "\"cp\": \""+cp+"\","
		        + "\"number\": \""+number+"\","
		        + "\"street\": \""+street+"\","
		        + "\"surface\": "+surface+","
		        + "\"price\": "+price+","
		        + "\"description\": \""+description+"\","
		        + "\"title\": \""+title+"\""
		        + "}";
	}
	
	/**
	 * Get all the images in directory images/
	 * @return List<String>  with all the image names
	 */
	@Override
	public List<String> getImageNames() {
        String path = getServletContext().getRealPath("/images");
        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();

        List<String> imageNames = new ArrayList<>();
        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (file.isFile() ) {
                    imageNames.add(file.getName());
                }
            }
        }
        return imageNames;
    }
}
