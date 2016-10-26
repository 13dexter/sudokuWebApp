package com.example.sudokujava.client;

import com.example.sudokujava.shared.FieldVerifier;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import java.util.*;

//import sudokugame.generator;
//import sudokugame.point;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Sudokujava implements EntryPoint {
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

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		final Button easyButton = new Button("Easy");
		final Button mediumButton = new Button("Medium");
		final Button hardButton = new Button("Hard");
		final Button submitButton = new Button("Submit");
		final Button giveupButton = new Button("Give Up");
		final TextBox [][] element = new TextBox[9][9];
		final Button test = new Button();
		RootPanel.get("test").add(test);
		test.setText("Hi");
		for(int i=0;i<9;i++)
		{
			for(int j=0;j<9;j++)
			{
				element[i][j] = new TextBox();
				element[i][j].setText("9");
				String s="e"+Integer.toString(i+1)+Integer.toString(j+1);
				RootPanel.get(s).add(element[i][j]);
				element[i][j].setMaxLength(1);
				
				
			}
		}
		
		RootPanel.get("easyButton1").add(easyButton);
		easyButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				//int rand=generator.randInt(0,(generator.easy.length)-1);
				for(int i=0;i<9;i++)
				{
					for(int j=0;j<9;j++)
						element[i][j].setText("1");
					//element[i][j].setText(text);
				}
				
			}
			
				});
	/*	nameField.setText("GWT User");
	//	nameField.setEditable(false);
		final Label errorLabel = new Label();

		// We can add style names to widgets
		sendButton.addStyleName("sendButton");

		// Add the nameField and sendButton to the RootPanel
		// Use RootPanel.get() to get the entire body element
		RootPanel.get("nameFieldContainer").add(nameField);
		RootPanel.get("sendButtonContainer").add(sendButton);
		RootPanel.get("errorLabelContainer").add(errorLabel);

		// Focus the cursor on the name field when the app loads
		nameField.setFocus(false);
		nameField.setEnabled(false);
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
		VerticalPanel dialogVPanel = new VerticalPanel();
		dialogVPanel.addStyleName("dialogVPanel");
		dialogVPanel.add(new HTML("<b>Sending name to the server:</b>"));
		dialogVPanel.add(textToServerLabel);
		dialogVPanel.add(new HTML("<br><b>Server replies:</b>"));
		dialogVPanel.add(serverResponseLabel);
		dialogVPanel.setHorizontalAlignment(VerticalPanel.ALIGN_RIGHT);
		dialogVPanel.add(closeButton);
		dialogBox.setWidget(dialogVPanel);

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
			/**
			 * Fired when the user clicks on the sendButton.
			 */
/*			public void onClick(ClickEvent event) {
				sendNameToServer();
			}

			/**
			 * Fired when the user types in the nameField.
			 */
/*			public void onKeyUp(KeyUpEvent event) {
				if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
					sendNameToServer();
				}
			}

			/**
			 * Send the name from the nameField to the server and wait for a response.
			 */
/*			private void sendNameToServer() {
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
}

class generator {
	
	public static int[][][] easy={
						   {{0,0,0,2,6,0,7,0,1},{6,8,0,0,7,0,0,9,0},{1,9,0,0,0,4,5,0,0},{8,2,0,1,0,0,0,4,0},{0,0,4,6,0,2,9,0,0},{0,5,0,0,0,3,0,2,8},{0,0,9,3,0,0,0,7,4},{0,4,0,0,5,0,0,3,6},{7,0,3,0,1,8,0,0,0}},
					       {{1,0,0,4,8,9,0,0,6},{7,3,0,0,0,0,0,4,0},{0,0,0,0,0,1,2,9,5},{0,0,7,1,2,0,6,0,0},{5,0,0,7,0,3,0,0,8},{0,0,6,0,9,5,7,0,0},{9,1,4,6,0,0,0,0,0},{0,2,0,0,0,0,0,3,7},{8,0,0,5,1,2,0,0,4}}
					      };
	
	public static int[][][] intermediate={
								   {{0,2,0,6,0,8,0,0,0},{5,8,0,0,0,9,7,0,0},{0,0,0,0,4,0,0,0,0},{3,7,0,0,0,0,5,0,0},{6,0,0,0,0,0,0,0,4},{0,0,8,0,0,0,0,1,3},{0,0,0,0,2,0,0,0,0},{0,0,9,8,0,0,0,3,6},{0,0,0,3,0,6,0,9,0}}
								  }; 
	
	public static int[][][] hard={
								{{0,0,0,6,0,0,4,0,0},{7,0,0,0,0,3,6,0,0},{0,0,0,0,9,1,0,8,0},{0,0,0,0,0,0,0,0,0},{0,5,0,1,8,0,0,0,3},{0,0,0,3,0,6,0,4,5},{0,4,0,2,0,0,0,6,0},{9,0,3,0,0,0,0,0,0},{0,2,0,0,0,0,1,0,0}}
							   };
	
public static int randInt(int min, int max) {

	    Random rand = new Random();

	    int randomNum = rand.nextInt((max - min) + 1) + min;

	    return randomNum;
	}
	
//	public static int[][] sudoku=

	public static void copy(int[][] copy_to,int[][] copy_from)
	{
		for(int i=0;i<9;i++)
		{
			for(int j=0;j<9;j++)
			{
				copy_to[i][j]=copy_from[i][j];
			}
		}
	}
}

class solver {
	
	public static point findNextCellToFill(int[][] grid)
	{
		point p=new point();
		/*for(p.x=i;p.x<9;p.x++)
		{
			for(p.y=j;p.y<9;p.y++)
			{
				if (grid[p.x][p.y]==0)
					return p;
			}
		}*/
		
		for(p.x=0;p.x<9;p.x++)
		{
			for(p.y=0;p.y<9;p.y++)
			{
				if (grid[p.x][p.y]==0)
					return p;
			}
		}
		
		p.x=-1;
		p.y=-1;
		return p;
	}
	
	public static boolean isValid(int[][]grid,int i,int j,int e)
	{
		boolean rowOk=true,colOk=true,boxOk=true;
		for(int x=0;x<9;x++)			//checking row
		{
			if(e==grid[i][x])
				rowOk=false;
		}
		for(int x=0;x<9;x++)			//checking column
		{
			if(e==grid[x][j])
				colOk=false;
		}
		int boxX=3*(i/3),boxY=3*(j/3);
		for(int x=boxX;x<boxX+3;x++)	//checking box
		{
			for(int y=boxY;y<boxY+3;y++)
			{
				if(e==grid[x][y])
					boxOk=false;
			}
		}
		
		return rowOk&&colOk&&boxOk;
	}
	
	public static boolean solveSudoku(int[][] grid)
	{
		point q=new point();
		int i,j,e;
		q=findNextCellToFill(grid);
		i=q.x;
		j=q.y;
		if(i==-1 || j==-1)
			return true;
		for(e=1;e<10;e++)
		{
			if(isValid(grid,i,j,e))
			{
				grid[i][j]=e;
				if(solveSudoku(grid))
					return true;
				grid[i][j]=0;
			}
		}
		return false;
	}

}

class point{
	public int x,y;
}


