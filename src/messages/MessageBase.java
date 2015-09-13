package messages;

public abstract class MessageBase {
	protected String message;
	protected String typeOfMessage;
	public MessageBase(String typeOfMessage) {
		this.typeOfMessage=typeOfMessage;
	}
	public String getMessage() {
		return message;
	}
}
