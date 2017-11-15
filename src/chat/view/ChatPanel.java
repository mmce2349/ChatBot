package chat.view;

import chat.controller.ChatbotController;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.SpringLayout;
import javax.swing.JButton;

public class ChatPanel extends JPanel
{
	private JTextArea responseArea; 
	private JTextField input;
	private JButton submit;
	private SpringLayout layout;

	public ChatPanel()
	{
		responseArea = new JTextArea();
		input = new JTextField();
		submit = new JButton();
		layout = new SpringLayout();
	}
}
