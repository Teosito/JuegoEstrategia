package messages;

public abstract class MessageExplore extends MessageBase{
	protected String characterName;
	public MessageExplore(String typeOfMessage, String characterName) {
		super(typeOfMessage);
		this.characterName = characterName;
	}

}
