package entregavel;

public class User {
    private EmailNotificationService emailNotificationService;

    public User() {
        this.emailNotificationService = new EmailNotificationService();
    }

    public void notifyUser(String message) {
        emailNotificationService.sendNotification(message);
    }
}

class EmailNotificationService {
    public void sendNotification(String message) {
        // Envia e-mail
    }
}


