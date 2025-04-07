public class Test {

    public static void main(String[] args) {

        DIController diController = new DIController();
        MessagingServices sendEmail = diController.getMessagingServices("Email");
        MessagingServices sendSMS = diController.getMessagingServices("SMS");


        NotificationService notificationService = new NotificationService(sendEmail);
        notificationService.sendNotification("Aryan Langhanoja", "Hello From Java");

        NotificationService notificationService_1 = new NotificationService(sendSMS);
        notificationService_1.sendNotification("Aryan Langhanoja", "Hello From Java");

    }
    
}
