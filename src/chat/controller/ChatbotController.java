package chat.controller;

import chat.view.*;
import chat.model.Chatbot;
import chat.model.CTECTwitter;
public class ChatbotController 
{
	private PopupDisplay display;
	private Chatbot chatbot;
	private ChatFrame appFrame;
	private CTECTwitter myTwitter;
	
	public ChatbotController()
	{
		chatbot = new Chatbot("Mitch McEntire");
		//View inialized after Model 
		display = new PopupDisplay();
		appFrame = new ChatFrame(this);
		myTwitter = new CTECTwitter(this);
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
			response += "This text matches the animals memes\n";
		}
		if(chatbot.htmlTagChecker(text))
		{
			response += "This text matches the html tag\n";
		}
		if(chatbot.keyboardMashChecker(text))
		{
			response += "This text matches the keyboard mash\n";
		}
		if(chatbot.lengthChecker(text)) 
		{
			response += "This text matches the length\n";
		}
		if(chatbot.movieGenreChecker(text))
		{
			response += "This text matches the movie genre\n";
		}
		if(chatbot.movieTitleChecker(text))
		{
			response += "This text matches the movie title\n";
		}
		if(chatbot.shoppingListChecker(text))
		{
			response += "This text matches the shopping list\n";
		}
		if(chatbot.userNameChecker(text))
		{
			response += "This text matches the username\n";
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
	public void handleErrors(Exception error)
	{
		display.displayText(error.getMessage());
	}
	public void tweet(String text)
	{
		myTwitter.sentTweet(text);
	}
	public String search(String text)
	{
		return myTwitter.getMostCommonWord(text);
	}
}
