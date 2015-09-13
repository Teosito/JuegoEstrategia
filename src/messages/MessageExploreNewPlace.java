package messages;

public class MessageExploreNewPlace extends MessageExplore{
	public MessageExploreNewPlace(String typeOfMessage, String characterName) {
		super(typeOfMessage, characterName);
		message = characterName + "found a new place and it has been added to your map";
	}

}
