package chat.model;

import java.util.List;
import java.time.LocalTime;
import java.util.ArrayList;
/** 
 * This is the Chatbot class which creates the topics and checkers. 
 * @author mmce2349
 *@version 21/11/17 1.2
 */
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
	
	/**
	 * This intializes all of the variables and calls the methods. 
	 * @param username
	 */
	public Chatbot(String username)
	{
		this.movieList = new ArrayList<Movie>();
		this.shoppingList = new ArrayList<String>();
		this.cuteAnimalMemes = new ArrayList<String>();
		this.questions = new String [10];
		this.username = username;
		this.content = "";
		this.intro = "";
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
	/**
	 * This builds the verbs for the chatbot to use.
	 */
	private void buildVerbs()
	{
		verbs[0] = "like";
		verbs[1] = "dislike";
		verbs[2] = "ambivalent about";
		verbs[3] = "am thinking about";
	}
/**
 * This builds the list of movies to talk about.
 */
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
	/** 
	 * this builds the shopping items the chatbot can discuss. 
	 */
	private void buildShoppingList()
	{
		shoppingList.add("snacks");
		shoppingList.add("veggies");
		shoppingList.add("protein");
		shoppingList.add("fruits");
		shoppingList.add("grains");
		shoppingList.add("muffins");
		shoppingList.add("drinks");
		shoppingList.add("rope");
		shoppingList.add("coconuts");
		shoppingList.add("candy");
		shoppingList.add("shirts");
		
	}
	/**
	 * This builds the list of cute animals it can talk about. 
	 */
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
	/**
	 * This builds a list of questions the chatbot can ask.
	 */
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
	
	/**
	 * This builds a list of topics the chatbot talks about. 
	 */
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
	/**
	 * This method takes input from the user, and generates a response with many follow up questions. 
	 * @param input This takes the users input from popup display, and states you said this.
	 * @return It returns a statement of verb topic, and then asks a question to keep the conversation going. 
	 */
	public String processConversation(String input)
	{
		String chatbotResponse = "";
		chatbotResponse += "You said: " + "\n" + input + "\n";
		chatbotResponse += buildChatbotResponse();
		
		return chatbotResponse; 
	}
	/**
	 * Takes the lists of topics, verbs, and questions to build a random response.
	 * @return the chatbot response is randomly generated to keep user entertained. 
	 */
	private String buildChatbotResponse()
	{
		String response = "I ";
		int random = (int) (Math.random() * verbs.length);
				
		response += verbs[random];
		
		random = (int) (Math.random() * topics.length);
		response += " " + topics[random] + ".\n";
		
		random = (int) (Math.random() * questions.length);
		response += questions[random];
		
		random = (int)(Math.random()* 2);
		if(random % 2 == 0)
		{
			random = (int) (Math.random() * movieList.size());
			response += "\n" + movieList.get(random).getTitle() + " is a great movie!";
		}
		return response; 
	}
	/**
	 * Make sure the the input is the correct length.	
	 * @param input takes the input from the user and makes sure that it is the correct length.
	 * @return if the length is a validlength or if it is invalid. 
	 */
	public boolean lengthChecker(String input)
	{
		boolean validLength = false;
		
		if (input != null && input.length() > 2)
		{
				validLength = true;
		}
		return validLength;
	}
	/**
	 * This checks if the html tag is correct. 
	 * @param input
	 * @return True or false if it works. 
	 */
	public boolean htmlTagChecker(String input)
	{
		
		return false;
	}
	/**
	 * Checks to see if the Username is correctly inputed
	 * @param input takes the user input and runs a test on it.	
	 * @return a true or false boolean which denies or accepts the username. 
	 */
	public boolean userNameChecker(String input)
	{
		if(!input.equals(null) || !input.contains("@@") || !input.contains(" ") || !input.contains(".com") && input.startsWith("@"))
		{
			return true;
		}
	 if ( input.equals(null))
		{
			return false;
		}
		else
		{
		return false; 
		}
	}
	
	public boolean contentChecker(String contentCheck)
	{
		return false;
	}
	/**
	 * This goes through the list of cute animal memes and checks to see if the correct memes are there. 
	 * @param input takes the input from the build cuteAnimalMemes.
	 * @return a true or false boolean which states if all necessary animals are present. 
	 */
	public boolean cuteAnimalMemeChecker(String input)
	{
		int index = 0;
		for(index = 0; index < cuteAnimalMemes.size(); index +=1)
		{
			if (input.contains("pupper") || input.contains("otter") || input.contains("kittie"))
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		return true;
	}
	/**
	 * Tests to make sure all shopping items are there in the list. 	
	 * @param shoppingItem takes the String statements from shoppingItems and checks to see what's there.
	 * @return a boolean true or false which states if everything needed is there or not. 
	 */
	public boolean shoppingListChecker(String shoppingItem)
	{
		int index = 0; 
	for (index = 0; index < shoppingList.size(); index +=1)
	{
		if (shoppingItem.contains("protein") || shoppingItem.contains("veggies") || shoppingItem.contains("snacks"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
		return true;
	}
	
	public boolean movieTitleChecker(String title)
	{
		int index = 0;
		for(index=0; index < movieList.size(); index +=1)
		{
			if (title.contains("Spiderman") || title.contains("Hidden Figures"))
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		return true;
	}
	
	public boolean movieGenreChecker(String genre)
	{
		if(genre.contains("Documentary") || genre.contains("Thriller"))
		{
			return true;
		}
		else
		{
		return false;
		}
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
		if(sample.contains("sdf") || sample.contains("SDF") || sample.contains("dfg") || sample.contains("cvb") || sample.contains(",./") || 
				sample.contains("kjh") || sample.contains("DFG") || sample.contains("CVB") || sample.contains("KJH"))
		{
			return true;
		}
		else if (sample.contains("S.D.F.") || sample.contains("derf"))
		{
			return false;
		}
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
		return intro;
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
