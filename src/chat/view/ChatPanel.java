package chat.view;

import chat.controller.ChatbotController;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.SpringLayout;
import javax.swing.JButton;

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
	private void setupPanel()
	{
		
	}
	
	private void setupLayout()
	{
		
	}
	
	private void setupListeners()
	{
		
	}

}
