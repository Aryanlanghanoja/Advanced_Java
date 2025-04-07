public class SMSServices implements MessagingServices{

    @Override
    public void sendMessage(String receiver, String Message) {
        System.out.println("Sending SMS to " + receiver + " : " + Message);
    }
    
}