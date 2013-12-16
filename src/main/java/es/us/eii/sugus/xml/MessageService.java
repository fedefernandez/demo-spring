package es.us.eii.sugus.xml;

import es.us.eii.sugus.xml.model.Message;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;
import java.util.Random;

public class MessageService implements IMessageService {

    private static final String DEFAULT_MESSAGE = "DEFAULT HELLO WORLD!";

    private SessionFactory sessionFactory;
    private Random random;
    private final TransactionTemplate transactionTemplate;

    // use constructor-injection to supply the PlatformTransactionManager
    public MessageService(PlatformTransactionManager transactionManager) {
        this.transactionTemplate = new TransactionTemplate(transactionManager);
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void setRandom(Random random) {
        this.random = random;
    }

    @Override
    public String getMessage() {
        return (String) transactionTemplate.execute(new TransactionCallback() {
            // the code in this method executes in a transactional context
            public String doInTransaction(TransactionStatus status) {
                Session session = sessionFactory.getCurrentSession();
                List<Message> messages = session.createQuery("from Message").list();
                if (messages == null || messages.isEmpty()) {
                    return DEFAULT_MESSAGE;
                } else {
                    return messages.get(random.nextInt(messages.size())).getMessage();
                }
            }
        });

    }
}
