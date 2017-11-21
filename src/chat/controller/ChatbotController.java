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
			display.displayText("Welcome to Chatbot");
			
//			while (chatbot.lengthChecker(response) && !chatbot.quitChecker(response))
//			{
//				response = popupChat(response);
//				response = display.collectResponse(response);
//			}
	}
	
	public String interactWithChatbot(String input)
	{
		String chatbotSays = "";
		
		if(chatbot.quitChecker(input))
		{
			close();
		}
		
		chatbotSays += chatbot.processConversation(input);
		
		
		return chatbotSays;
	}
	
	public String useCheckers(String text)
	{
		String response = "";
		
		if(chatbot.contentChecker(text))
		{
			response += "This text matches the special content\n";
		}
		if(chatbot.cuteAnimalMemeChecker(text))
		{
			response += "";
		}
		if(chatbot.htmlTagChecker(text))
		{
			response += "";
		}
		if(chatbot.keyboardMashChecker(text))
		{
			response += "";
		}
		if(chatbot.lengthChecker(text)) 
		{
			response += "";
		}
		
		return response;
	}
	private void close()
	{
		display.displayText("Goodbye");
		System.exit(0);
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
