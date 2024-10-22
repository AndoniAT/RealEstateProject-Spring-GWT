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
import java.lang.reflect.Type;

import realEstate.client.EstateService;
import realEstate.shared.Estat;

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
	public String sayHello() throws IllegalArgumentException {
		return "heeeelloo";
	}
}
