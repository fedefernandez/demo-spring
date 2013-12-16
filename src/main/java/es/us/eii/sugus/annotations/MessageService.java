package es.us.eii.sugus.annotations;

import org.springframework.context.annotation.Configuration;

public class MessageService implements IMessageService {

    @Override
    public String getMessage() {
        return "Hello World!";
    }
}
