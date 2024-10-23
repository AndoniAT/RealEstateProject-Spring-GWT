package realEstate.client;

import java.util.List;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.http.client.*;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

import realEstate.shared.Estat;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class RealEstateFrontEnd implements EntryPoint {
	private Label errorMessagePage = new Label();
	private static final String URL_API = "http://localhost:8082/api/estates";

	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network " + "connection and try again.";

	/**
	 * Create a remote service proxy to talk to the server-side Greeting service.
	 */
	private final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);
	private final EstateServiceAsync estateServiceAsync = GWT.create(EstateService.class);

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		final TextBox nameField = new TextBox();
		RootPanel.get("errorMessagePage").add(errorMessagePage);
  	  	chargeEstates();
		
		/*final Button sendButton = new Button("Send");
		final TextBox nameField = new TextBox();
		nameField.setText("GWT User");
		final Label errorLabel = new Label();

		// We can add style names to widgets
		sendButton.addStyleName("sendButton");

		// Add the nameField and sendButton to the RootPanel
		// Use RootPanel.get() to get the entire body element
		RootPanel.get("nameFieldContainer").add(nameField);
		RootPanel.get("sendButtonContainer").add(sendButton);
		RootPanel.get("errorLabelContainer").add(errorLabel);

		// Focus the cursor on the name field when the app loads
		nameField.setFocus(true);
		nameField.selectAll();

		// Create the popup dialog box
		final DialogBox dialogBox = new DialogBox();
		dialogBox.setText("Remote Procedure Call");
		dialogBox.setAnimationEnabled(true);
		final Button closeButton = new Button("Close");
		// We can set the id of a widget by accessing its Element
		closeButton.getElement().setId("closeButton");
		final Label textToServerLabel = new Label();
		final HTML serverResponseLabel = new HTML();

		// Add a handler to close the DialogBox
		closeButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				dialogBox.hide();
				sendButton.setEnabled(true);
				sendButton.setFocus(true);
			}
		});

		// Create a handler for the sendButton and nameField
		class MyHandler implements ClickHandler, KeyUpHandler {
			// Fired when the user clicks on the sendButton.
			 
			public void onClick(ClickEvent event) {
				sendNameToServer();
			}

			// Fired when the user types in the nameField.
			 
			public void onKeyUp(KeyUpEvent event) {
				if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
					sendNameToServer();
				}
			}

			// Send the name from the nameField to the server and wait for a response.
			 
			private void sendNameToServer() {
				// First, we validate the input.
				errorLabel.setText("");
				String textToServer = nameField.getText();
				if (!FieldVerifier.isValidName(textToServer)) {
					errorLabel.setText("Please enter at least four characters");
					return;
				}

				// Then, we send the input to the server.
				sendButton.setEnabled(false);
				textToServerLabel.setText(textToServer);
				serverResponseLabel.setText("");
				greetingService.greetServer(textToServer, new AsyncCallback<String>() {
					public void onFailure(Throwable caught) {
						// Show the RPC error message to the user
						dialogBox.setText("Remote Procedure Call - Failure");
						serverResponseLabel.addStyleName("serverResponseLabelError");
						serverResponseLabel.setHTML(SERVER_ERROR);
						dialogBox.center();
						closeButton.setFocus(true);
					}

					public void onSuccess(String result) {
						dialogBox.setText("Remote Procedure Call");
						serverResponseLabel.removeStyleName("serverResponseLabelError");
						serverResponseLabel.setHTML(result);
						dialogBox.center();
						closeButton.setFocus(true);
					}
				});
			}
		}

		// Add a handler to send the name to the server
		MyHandler handler = new MyHandler();
		sendButton.addClickHandler(handler);
		nameField.addKeyUpHandler(handler);*/
	}
	
	public void chargeEstates() {
		RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, URL_API);

		RequestCallback cb = new RequestCallback() {
		    public void onError(Request request, Throwable exception) {
		    	throw new IllegalStateException(exception) ;
		    }

		    public void onResponseReceived(Request request, Response response) {
		      if (200 == response.getStatusCode()) {
		    	  String jsonResponse = response.getText();
		    	  //l.setText(jsonResponse);
		    	  // Parse date
		    	  estateServiceAsync.parseEstates(jsonResponse, new AsyncCallback<List<Estat>>() {
						public void onFailure(Throwable caught) {
							// Show the RPC error message to the user
							errorMessagePage.setText("Remote Procedure Call - Failure" + caught);
							
						}

						public void onSuccess(List<Estat> result) {
							displayEstates(result);
						}
					});
		      } else {
		    	  errorMessagePage.setText( SERVER_ERROR + response.getStatusCode() );
		      }
		    }
		  };

		try {
			  Request request = builder.sendRequest(null, cb);
			} catch (RequestException e) {
			  // Couldn't connect to server
				errorMessagePage.setText(SERVER_ERROR + e );
			}
	}
	
	public void deleteEstate( Long id, AsyncCallback<String> callBack ) {
			RequestBuilder builder = new RequestBuilder(RequestBuilder.DELETE, URL_API + "/" + id);

			RequestCallback cb = new RequestCallback() {
			    public void onError(Request request, Throwable exception) {
			    	callBack.onFailure( new IllegalStateException(exception) );
			    }

			    public void onResponseReceived(Request request, Response response) {
			      if (200 == response.getStatusCode()) {
			    	  String jsonResponse = response.getText();
			    	  callBack.onSuccess(response.getStatusCode()+"");
			      } else {
			    	  callBack.onFailure( new IllegalStateException(SERVER_ERROR + response.getStatusCode() ) );
			      }
			    }
			  };

			try {
				  Request request = builder.sendRequest(null, cb);
				} catch (RequestException e) {
				  // Couldn't connect to server
					callBack.onFailure( new IllegalStateException( SERVER_ERROR + e  ) );
				}
	}


	/**
	 * Create elements in HTML for each estate
	 * @param estates
	 */
	public void displayEstates(List<Estat> estates) {
		estateServiceAsync.getImageNames(new AsyncCallback<List<String>>() {

			@Override
			public void onFailure(Throwable caught) {
				errorMessagePage.setText("Error reading images directory" );
			}

			@Override
			public void onSuccess(List<String> images) {
				// Show estates
				estates.forEach(est -> {
					VerticalPanel containerEstate = new VerticalPanel();
					containerEstate.addStyleName("containerEstate");

					HorizontalPanel titleContainer = new HorizontalPanel();
					Label title = new Label();
					titleContainer.addStyleName("titleEstateContainer");
					title.setText(est.getTitle());
					titleContainer.add(title);
					
					VerticalPanel bodyContainerEstate = new VerticalPanel();
					bodyContainerEstate.addStyleName("bodyContainerEstate");

					int randomIndex = (int) (Math.random() * images.size());
		            String randomImageName = images.get(randomIndex);
					Image img = new Image("images/" + randomImageName);
					
					HorizontalPanel imageSectionContainer = new HorizontalPanel();
					imageSectionContainer.addStyleName("imageSectionContainer");

					HorizontalPanel imageContainer = new HorizontalPanel();
					imageContainer.addStyleName("imageContainer");
					imageContainer.add(img);
					imageSectionContainer.add(imageContainer);
					
					bodyContainerEstate.add(imageSectionContainer);
					
					HorizontalPanel priceContainer = new HorizontalPanel();
					priceContainer.addStyleName("textContainerDetail");
					
					Label price = new Label();
					price.setText(est.getPrice() + " euros");
					priceContainer.add(price);
					
					// ==== Buttons Action Section ===
					class MyInfoButton implements ClickHandler {

						@Override
						public void onClick(ClickEvent event) {
							VerticalPanel dialogVPanel = new VerticalPanel();
							final DialogBox dialogBox = new DialogBox();
							dialogBox.setAnimationEnabled(true);

							final Button closeButton = new Button("Close");
							
							closeButton.addClickHandler(new ClickHandler() {
								public void onClick(ClickEvent event) {
									dialogBox.hide();
								}
							});

							closeButton.getElement().setId("closeButton");
							dialogVPanel.addStyleName("dialogVPanel");
							dialogVPanel.add(new HTML("<b>Title : </b>"));
							dialogVPanel.add(new Label(est.getTitle()));
							dialogVPanel.add(new HTML("<b>Description : </b>"));
							dialogVPanel.add(new Label(est.getDescription()));
							dialogVPanel.add(new HTML("<b>Price : </b>"));
							dialogVPanel.add(new Label(est.getPrice() + " euros"));
							dialogVPanel.add(new HTML("<b>Surface : </b>"));
							dialogVPanel.add(new Label(est.getSurface() + " m2"));
							dialogVPanel.add(new HTML("<b>Address : </b>"));
							dialogVPanel.add(new Label(est.getAddress()));
							dialogVPanel.add(new HTML("<b>Owner : </b>"));
							dialogVPanel.add(new Label(est.getOwner()));
							//dialogVPanel.add(new HTML("<br><b>Server replies:</b>"));
							//dialogVPanel.add(serverResponseLabel);
							dialogVPanel.setHorizontalAlignment(VerticalPanel.ALIGN_RIGHT);
							dialogVPanel.add(closeButton);
							dialogBox.setWidget(dialogVPanel);
							
							dialogBox.setText("Details");
							dialogBox.center();
							closeButton.setFocus(true);
							
						}
						
					}
					
					class MyDeleteButton implements ClickHandler {

						@Override
						public void onClick(ClickEvent event) {
							deleteEstate( est.getId(), new AsyncCallback<String>() {
									
								public void onFailure(Throwable caught) {
									throw new IllegalStateException( caught );
								}

								public void onSuccess(String result) {
									RootPanel.get().remove(containerEstate);
									containerEstate.removeFromParent();
								}
							} );
							
						}
						
						}

					HorizontalPanel butonsContainer = new HorizontalPanel();
					butonsContainer.addStyleName("buttonsContainer");
					Button btnMoreInfo = new Button("More info");
					Button btnDelete = new Button("Delete");
					
					btnDelete.addStyleName("deleteBtn");
					btnDelete.addStyleName("btn");
					btnDelete.addClickHandler(new MyDeleteButton());
					
					btnMoreInfo.addStyleName("infoBtn");
					btnMoreInfo.addStyleName("btn");
					btnMoreInfo.addClickHandler(new MyInfoButton());
					
					butonsContainer.add(btnMoreInfo);
					butonsContainer.add(btnDelete);
					
					containerEstate.add(titleContainer);
					containerEstate.add(bodyContainerEstate);
					containerEstate.add(priceContainer);
					containerEstate.add(butonsContainer);

					RootPanel.get("estatesContainer").add(containerEstate);
				});
			}
			
		});
	}

}
