package realEstate.client;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gwt.user.client.rpc.AsyncCallback;

import realEstate.shared.Estat;

public interface EstateServiceAsync {
	void parseEstates(String estates, AsyncCallback<List<Estat>> callback) throws IllegalArgumentException;
	void getImageNames(AsyncCallback<List<String>> callback) throws IllegalArgumentException;
	void estateFormToJsonString(String title, String description, double price, String country, String city, String cp, int number, String street, int surface, String owner, AsyncCallback<String> callback) throws IllegalArgumentException;
}
