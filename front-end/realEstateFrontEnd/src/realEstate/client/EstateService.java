package realEstate.client;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import realEstate.shared.Estat;

@RemoteServiceRelativePath("estate")
public interface EstateService extends RemoteService {
	List<Estat> parseEstates(String estates) throws IllegalArgumentException;
	List<String> getImageNames() throws IllegalArgumentException;
	String estateFormToJsonString(String title, String description, double price, String country, String city, String cp, int number, String street, int surface, String owner) throws IllegalArgumentException;
}
