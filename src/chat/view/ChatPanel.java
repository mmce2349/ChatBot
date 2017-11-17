package chat.view;

import chat.controller.ChatbotController;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.SpringLayout;
import javax.swing.JButton;
import java.awt.Color;

public class ChatPanel extends JPanel
{
	private JTextArea chatArea; 
	private JTextField inputField;
	private JButton chatButton;
	private SpringLayout appLayout;
	private ChatbotController appController;

	public ChatPanel(ChatbotController appController)
	{
		super();
		this.appController = appController; 
		
		//Initialize GUI data members
		chatButton = new JButton("Chat");
		chatArea = new JTextArea(10, 25);
		inputField = new JTextField(25);
		appLayout = new SpringLayout();
		
		
		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	/**
	 * This is how you edit and setup your panel and how it looks. 
	 */
	private void setupPanel()
	{
		this.setBackground(Color.BLACK);
		this.setLayout(appLayout);
		this.add(chatButton);
		this.add(inputField);
		this.add(chatArea);
		
	}
	/**
	 * This is where you put all of your constraints for your layout. 
	 */
	private void setupLayout()
	{
		appLayout.putConstraint(SpringLayout.NORTH, inputField, 0, SpringLayout.NORTH, chatButton);
		appLayout.putConstraint(SpringLayout.WEST, inputField, 0, SpringLayout.WEST, chatArea);
		appLayout.putConstraint(SpringLayout.SOUTH, chatButton, -10, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.EAST, chatButton, 0, SpringLayout.EAST, chatArea);
		appLayout.putConstraint(SpringLayout.NORTH, chatArea, 20, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.WEST, chatArea, 25, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.EAST, chatArea, -25, SpringLayout.EAST, this);
	}
	
	private void setupListeners()
	{
		
	}

}
