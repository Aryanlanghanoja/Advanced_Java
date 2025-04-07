public class DIController {

    MessagingServices getMessagingServices(String type) {

        if(type.equalsIgnoreCase("Email")) {
            return new EmailService();
        }

        else if(type.equalsIgnoreCase("SMS")) {
            return new SMSServices();
        }

        else {
            System.out.println("Invalid Service type");
            return null;
        }
    }
    
}
