package chat.model;

import java.util.List;
import java.time.LocalTime;
import java.util.ArrayList;

public class Chatbot
{
	private List<Movie> movieList;
	private List<String> shoppingList;
	private List<String> cuteAnimalMemes;
	private String [] verbs;
	private String [] topics;
	private String [] followUps;
	private String [] questions;
	private String username;
	private String content;
	private String intro;
	private LocalTime currentTime;
	
	public Chatbot(String username)
	{
		this.movieList = new ArrayList<Movie>();
		this.shoppingList = new ArrayList<String>();
		this.cuteAnimalMemes = new ArrayList<String>();
		this.questions = new String [10];
		this.username = username;
		this.content = null;
		this.intro = null;
		this.currentTime = LocalTime.now();
		this.topics = new String [7];
		this.verbs = new String [4];
		this.followUps = new String [5];
		
		buildVerbs();
		buildShoppingList();
		buildQuestions();
		buildMovieList();
		buildCuteAnimals();
		processConversation("");
		getCurrentTime();
		buildChatbotResponse();
		buildTopics();
		buildFollowUps();
		getContent();
	}
	
	private void buildVerbs()
	{
		verbs[0] = "like";
		verbs[1] = "dislike";
		verbs[2] = "ambivalent about";
		verbs[3] = "am thinking about";
	}

	private void buildMovieList()
	{
		movieList.add(new Movie (""));
		movieList.add(new Movie ("Spiderman"));
		movieList.add(new Movie ("Hidden Figure"));
		movieList.add(new Movie ("Man of Steel"));
		movieList.add(new Movie ("Monty Python and the Holy Grail"));
		movieList.add(new Movie ("Thor"));
		movieList.add(new Movie ("IronMan"));
	}
	
	private void buildShoppingList()
	{
		shoppingList.add("snacks");
		shoppingList.add("veggies");
		shoppingList.add("protein");
		shoppingList.add("fruits");
		shoppingList.add("grains");
		
	}
	
	private void buildCuteAnimals()
	{
		cuteAnimalMemes.add("otter");
		cuteAnimalMemes.add("kittie");
		cuteAnimalMemes.add("FLOOFER");
		cuteAnimalMemes.add("otter");
		cuteAnimalMemes.add("kittie");
		cuteAnimalMemes.add("FLOOFER");
		cuteAnimalMemes.add("FLOOFER");
		cuteAnimalMemes.add("pupper");
		cuteAnimalMemes.add("PUPPER");
		cuteAnimalMemes.add("pupper");
	}
	
	private void buildQuestions()
	{
		questions[0] = "What is your name?";
		questions[1] = "What is your age?";
		questions[2] = "What is your favorite color?";
		questions[3] = "What is your favorite animal?";
		questions[4] = "What is your favorite movie?";
		questions[5] = "What is the capital of Assyria?";
		questions[6] = "What is the air speed velocity of an unladen swallow?";
		questions[7] = "Why is GIR so amazing?";
		questions[8] = "Do coconuts migrate?";
		questions[9] = "What is your quest?";		
	}
	private void buildTopics()
	{
		topics[0] = "animals";
		topics[1] = "swimming";
		topics[2] = "food";
		topics[3] = "books";
		topics[4] = "politics";
		topics[5] = "computers";
		topics[6] = "Space-X";
	}
	private void buildFollowUps()
	{
		
	}
	
	public String processConversation(String input)
	{
		String chatbotResponse = "";
		chatbotResponse += "You said: " + "\n" + input + "\n";
		chatbotResponse += buildChatbotResponse();
		
		return chatbotResponse; 
	}
	
	private String buildChatbotResponse()
	{
		String response = "I ";
		int random = (int) (Math.random() * verbs.length);
				
		response += verbs[random];
		
		random = (int) (Math.random() * topics.length);
		response += " " + topics[random] + ".\n";
		
		random = (int) (Math.random() * questions.length);
		response += questions[random];
		
		return response; 
	}
	
	public boolean lengthChecker(String input)
	{
		boolean validLength = false;
		
		if (input != null && input.length() > 2)
		{
				validLength = true;
		}
		return validLength;
	}
	
	public boolean htmlTagChecker(String input)
	{
		return false;
	}
	
	public boolean userNameChecker(String input)
	{
		return false;
	}
	
	public boolean contentChecker(String contentCheck)
	{
		return false;
	}
	
	public boolean cuteAnimalMemeChecker(String input)
	{
		return false;
	}
	
	public boolean shoppingListChecker(String shoppingItem)
	{
		return false;
	}
	
	public boolean movieTitleChecker(String title)
	{
		return false;
	}
	
	public boolean movieGenreChecker(String genre)
	{
		return false;
	}

	public boolean quitChecker(String exitString)
	{
		if (exitString.equalsIgnoreCase("quit"))
		{
			return true;
		}
		return false;
	}

	public boolean keyboardMashChecker(String sample)
	{
		return false;
	}
	
	public List<Movie> getMovieList()
	{
		return movieList;
	}
	
	public List<String> getShoppingList()
	{
		return shoppingList;
	}
	
	public List<String> getCuteAnimalMemes()
	{
		return cuteAnimalMemes;
	}

	public String [] getQuestions()
	{
		return questions;
	}
	
	public String[] getVerbs()
	{
		return verbs;
	}

	public String[] getTopics()
	{
		return topics;
	}

	public String[] getFollowUps()
	{
		return followUps;
	}

	public String getUsername()
	{
		return username;
	}
	
	public String getContent()
	{
		return content;
	}

	public String getIntro()
	{
		return null;
	}
	
	public LocalTime getCurrentTime()
	{
		return currentTime;
	}
	
	public void setUsername(String username)
	{
		this.username = username;
	}
	
	public void setContent(String content)
	{
		this.content = content;
	}
}
