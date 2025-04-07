public class NotificationService {

    MessagingServices messagingServices;

    public NotificationService(MessagingServices messagingServices) {
        this.messagingServices = messagingServices;
    }

    void sendNotification(String receiver , String message) {
        messagingServices.sendMessage(receiver, message);
    }
    
}
