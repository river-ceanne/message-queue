package message.queue;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.Message;
import com.amazonaws.services.sqs.model.ReceiveMessageRequest;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class AppTest {

    final static AmazonSQS sqs = AmazonSQSClientBuilder.standard().withRegion(Regions.US_EAST_1).build();
    static String url = "https://sqs.us-east-1.amazonaws.com/897695574584/QueueA";


    @Test
    public void testAppSQSSend(){

        App.sendMessage("hello");
        final ReceiveMessageRequest receiveMessageRequest =
                new ReceiveMessageRequest(url);
        final List<Message> messages = sqs.receiveMessage(receiveMessageRequest)
                .getMessages();
        for (final Message message : messages) {
            assertEquals("hello",message.getBody());
        }

    }

    @Test
    public void testAppSQSReceive(){
        App.sendMessage("hello");

        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        App.receiveMessages();

        assertEquals("Message\n" +
                "  Body:          hello\n",outContent.toString());
    }


}
