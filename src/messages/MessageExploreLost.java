package messages;

public class MessageExploreLost extends MessageExplore{

	public MessageExploreLost(String typeOfMessage, String characterName) {
		super(typeOfMessage, characterName);
		message = characterName + "didn't return";
	}
	
}
