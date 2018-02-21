package chat.view;

import chat.controller.ChatbotController;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * The JPanel subClass for the chatbot project. 
 * @author Mitch McEntire
 * @version 21/11/17 1.2
 */
public class ChatPanel extends JPanel
{
	private JButton searchButton;
	private JButton saveButton;
	private JButton loadButton;
	private JButton tweetButton;
	
	private JTextArea chatArea; 
	private JTextField inputField;
	private JButton chatButton;
	private SpringLayout appLayout;
	private ChatbotController appController;
	private JButton checkerButton;
	private JLabel infoLabel;
	private JScrollPane chatScrollPane;

	public ChatPanel(ChatbotController appController)
	{
		super();
		this.appController = appController; 
		
		//Initialize GUI data members
		chatButton = new JButton("Chat");
		chatArea = new JTextArea(10, 25);
		inputField = new JTextField(25);
		appLayout = new SpringLayout();
		
		checkerButton = new JButton("Checker");
		
		infoLabel = new JLabel("Type to Chat with the Chatbot");
	
		chatScrollPane = new JScrollPane();
		loadButton = new JButton("load", new ImageIcon(getClass().getResource("/chat/view/images/load.png")));
		searchButton = new JButton("search", new ImageIcon(getClass().getResource("/chat/view/images/search.png")));
		
	
		saveButton = new JButton("save", new ImageIcon(getClass().getResource("/chat/view/images/Save.png")));
		
		tweetButton = new JButton("tweet", new ImageIcon(getClass().getResource("/chat/view/images/tweet.png")));
		
		setupScrollPane();
		setupPanel();
		setupLayout();
		setupListeners();
	}
	/**
	 * This is how you edit and setup your panel and how it looks. 
	 */
	
	private void setupScrollPane()
	{
		chatScrollPane.setViewportView(chatArea);
		chatScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		chatScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	}
	private void setupPanel()
	{
		this.setMinimumSize(new Dimension(800, 600));
		this.setBackground(Color.BLUE);
		this.setLayout(appLayout);
		this.add(chatButton);
		this.add(inputField);
		this.add(chatScrollPane);
		this.add(infoLabel);
		chatArea.setEnabled(false);
		chatArea.setEnabled(false);
		this.add(checkerButton);
		this.add(loadButton);
		this.add(saveButton);
		this.add(searchButton);
		this.add(tweetButton);
		
	}
	/**
	 * This is where you put all of your constraints for your layout. 
	 */
	private void setupLayout()
	{	
		appLayout.putConstraint(SpringLayout.NORTH, chatButton, 0, SpringLayout.NORTH, inputField);
		appLayout.putConstraint(SpringLayout.WEST, chatButton, 11, SpringLayout.EAST, checkerButton);
		appLayout.putConstraint(SpringLayout.NORTH, checkerButton, 0, SpringLayout.NORTH, inputField);
		appLayout.putConstraint(SpringLayout.WEST, checkerButton, 30, SpringLayout.EAST, inputField);
		appLayout.putConstraint(SpringLayout.NORTH, inputField, 6, SpringLayout.SOUTH, infoLabel);
		appLayout.putConstraint(SpringLayout.NORTH, infoLabel, 6, SpringLayout.SOUTH, searchButton);
		appLayout.putConstraint(SpringLayout.EAST, infoLabel, 0, SpringLayout.EAST, searchButton);
		appLayout.putConstraint(SpringLayout.NORTH, searchButton, 6, SpringLayout.SOUTH, chatScrollPane);
		appLayout.putConstraint(SpringLayout.NORTH, loadButton, 0, SpringLayout.NORTH, saveButton);
		appLayout.putConstraint(SpringLayout.EAST, loadButton, -42, SpringLayout.WEST, saveButton);
		appLayout.putConstraint(SpringLayout.NORTH, saveButton, 6, SpringLayout.SOUTH, chatScrollPane);
		appLayout.putConstraint(SpringLayout.EAST, saveButton, -66, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.WEST, tweetButton, 251, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.EAST, inputField, 0, SpringLayout.EAST, tweetButton);
		appLayout.putConstraint(SpringLayout.EAST, searchButton, -31, SpringLayout.WEST, tweetButton);
		appLayout.putConstraint(SpringLayout.NORTH, tweetButton, 0, SpringLayout.NORTH, loadButton);
		appLayout.putConstraint(SpringLayout.NORTH, chatScrollPane, 20, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.WEST, chatScrollPane, 25, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.EAST, chatScrollPane, -25, SpringLayout.EAST, this);
	}
	
	private void setupListeners()
	{
		chatButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent click)
				{
					String userText = inputField.getText();
					String displayText = appController.interactWithChatbot(userText);
					chatArea.append(displayText);
					inputField.setText("");
				}
			});
		
		checkerButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent click)
				{
					String userText = inputField.getText();
					String displayText = appController.useCheckers(userText);
					chatArea.append(displayText);
					inputField.setText("");
				}
			});
	}

}
