package chat.controller;

import chat.view.*;
import chat.model.Chatbot;

public class ChatbotController 
{
	private PopupDisplay display;
	private Chatbot chatbot;
	
	public ChatbotController()
	{
		chatbot = new Chatbot("Mitch McEntire");
		display = new PopupDisplay();
	}
	
	public void start()
	{
			String response = display.collectResponse("What do you want to talk about?");
			
			while (chatbot.lengthChecker(response) && !chatbot.quitChecker(response))
			{
				response = popupChat(response);
			}
	}
	
	public String interactWithChatbot(String input)
	{
		return input;
	}
	private String popupChat(String chat)
	{
		return null;
	}
}
