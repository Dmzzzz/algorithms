package patterns.chainOfResponsibility.one;

public class Main {

    public static void main(String[] args) {
        Notifier reportNotifier = new SimpleReportNotifier(Priority.ROUTINE);
        Notifier emailNotifier = new EmailNotifier(Priority.IMPORTANT);
        Notifier smsNotifier = new SmsNotifier(Priority.ASAP);

        reportNotifier.setNextNotifier(emailNotifier);
        emailNotifier.setNextNotifier(smsNotifier);

        reportNotifier.notifyManager("Everything is OK ", Priority.ROUTINE);
        reportNotifier.notifyManager("Something went wrong ", Priority.IMPORTANT);
        reportNotifier.notifyManager("Huston we have Problem ", Priority.ASAP);
    }
}