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
	
}
