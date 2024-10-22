package realEstate.client;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gwt.user.client.rpc.AsyncCallback;

import realEstate.shared.Estat;

public interface EstateServiceAsync {
	void parseEstates(String estates, AsyncCallback<List<Estat>> callback) throws IllegalArgumentException;
	void getImageNames(AsyncCallback<List<String>> callback) throws IllegalArgumentException;
}
