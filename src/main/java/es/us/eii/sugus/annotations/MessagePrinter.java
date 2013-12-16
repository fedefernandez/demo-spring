package es.us.eii.sugus.annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessagePrinter {

    @Autowired
    private IMessageService service;

    public void printMessage() {
        System.out.println(this.service.getMessage());
    }
}