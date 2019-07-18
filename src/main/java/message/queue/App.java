package message.queue;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.DeleteMessageRequest;
import com.amazonaws.services.sqs.model.Message;
import com.amazonaws.services.sqs.model.ReceiveMessageRequest;
import com.amazonaws.services.sqs.model.SendMessageRequest;

import java.util.List;

// sources:
// http://opensourceforgeeks.blogspot.com/2018/07/how-to-fix-unable-to-find-region-via.html
// https://docs.aws.amazon.com/AWSSimpleQueueService/latest/SQSDeveloperGuide/standard-queues-getting-started-java.html

public class App {

    final static AmazonSQS sqs = AmazonSQSClientBuilder.standard().withRegion(Regions.US_EAST_1).build();
    static String url = "https://sqs.us-east-1.amazonaws.com/897695574584/QueueA";

    public static void sendMessage(String message){


        SendMessageRequest send_msg_request = new SendMessageRequest()
                .withQueueUrl(url)
                .withMessageBody(message)
                .withDelaySeconds(2);
        sqs.sendMessage(send_msg_request);
    }

    public static void receiveMessages(){
        final ReceiveMessageRequest receiveMessageRequest =
                new ReceiveMessageRequest(url);
        final List<Message> messages = sqs.receiveMessage(receiveMessageRequest)
                .getMessages();
        for (final Message message : messages) {
            System.out.println("Message");
            System.out.println("  MessageId:     "
                    + message.getMessageId());

            System.out.println("  Body:          "
                    + message.getBody());


            deleteMessage(message.getReceiptHandle());
        }
        System.out.println();

    }

    public static void deleteMessage(String messageReceiptHandle){
        sqs.deleteMessage(new DeleteMessageRequest(url,
                messageReceiptHandle));
    }

    public static void main(String[] args) {

        if(args[0] == "send"){
            System.out.println("Sending message....");
            sendMessage(args[1]);
        }else if(args[0] == "receive"){
            receiveMessages();
        }


    }
}
