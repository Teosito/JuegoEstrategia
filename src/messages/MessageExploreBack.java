package messages;

public class MessageExploreBack extends MessageExplore{

	public MessageExploreBack(String typeOfMessage, String characterName) {
		super(typeOfMessage, characterName);
		message = characterName + "has found" + typeOfMessage;
	}

}
