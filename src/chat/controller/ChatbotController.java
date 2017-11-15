package chat.controller;

import chat.view.*;
import chat.model.Chatbot;

public class ChatbotController 
{
	private PopupDisplay display;
	private Chatbot chatbot;
	private ChatFrame appFrame;
	
	public ChatbotController()
	{
		chatbot = new Chatbot("Mitch McEntire");
		//View inialized after Model 
		display = new PopupDisplay();
		appFrame = new ChatFrame(this);
	}
	
	public void start()
	{
			String response = display.collectResponse("What do you want to talk about?");
			
			while (chatbot.lengthChecker(response) && !chatbot.quitChecker(response))
			{
				response = popupChat(response);
				response = display.collectResponse(response);
			}
	}
	
	public String interactWithChatbot(String input)
	{
		return input;
	}
	private String popupChat(String chat)
	{
		String chatbotSays = "";
		
		chatbotSays += chatbot.processConversation(chat);
		
		return chatbotSays;
	}
	
	public Chatbot getChatbot()
	{
		return chatbot;
	}
}
