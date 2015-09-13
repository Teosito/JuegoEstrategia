package messages;

public class MessageBuild extends MessageBase{

	public MessageBuild(String typeOfMessage) {
		super(typeOfMessage);
		message = typeOfMessage + "has been built";
	}

}
