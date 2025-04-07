public class EmailService  implements MessagingServices{

    @Override
    public void sendMessage(String receiver, String Message) {
        System.out.println("Sending Email to " + receiver + " : " + Message);
    }
    
}
