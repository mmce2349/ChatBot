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
	private SpringLayout baseLayout;
	private ChatbotController appController;

	public ChatPanel(ChatbotController appController)
	{
		super();
		this.appController = appController; 
		
	}

}
