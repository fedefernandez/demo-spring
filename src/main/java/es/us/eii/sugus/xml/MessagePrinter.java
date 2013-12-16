package es.us.eii.sugus.xml;

public class MessagePrinter {

    private IMessageService service;

    public void setService(IMessageService service) {
        this.service = service;
    }

    public void printMessage() {
        System.out.println(this.service.getMessage());
    }
}