//package message.queue;
///*
// * Copyright 2010-2018 Amazon.com, Inc. or its affiliates. All Rights Reserved.
// *
// * Licensed under the Apache License, Version 2.0 (the "License").
// * You may not use this file except in compliance with the License.
// * A copy of the License is located at
// *
// *  https://aws.amazon.com/apache2.0
// *
// * or in the "license" file accompanying this file. This file is distributed
// * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
// * express or implied. See the License for the specific language governing
// * permissions and limitations under the License.
// *
// */
//
//
//import com.amazonaws.auth.AWSCredentials;
//import com.amazonaws.auth.AWSStaticCredentialsProvider;
//import com.amazonaws.auth.BasicAWSCredentials;
//import com.amazonaws.AmazonClientException;
//import com.amazonaws.AmazonServiceException;
//import com.amazonaws.regions.Region;
//import com.amazonaws.regions.Regions;
//import com.amazonaws.services.sqs.AmazonSQS;
//import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
//import com.amazonaws.services.sqs.model.*;
//
//import java.util.List;
//import java.util.Map.Entry;
//
///**
// * This sample demonstrates how to make basic requests to Amazon SQS using the
// * AWS SDK for Java.
// * <p>
// * Prerequisites: You must have a valid Amazon Web Services developer account,
// * and be signed up to use Amazon SQS. For more information about Amazon SQS,
// * see https://aws.amazon.com/sqs
// * <p>
// * Make sure that your credentials are located in ~/.aws/credentials
// */
//
//public class SQSSimpleJavaClientExample {
//
//    static String url = "https://sqs.us-east-1.amazonaws.com/897695574584/QueueA";
//    static String message = "Hello !!!";
//
//    public static void sendMessage(){
//
//        final AmazonSQS sqs = AmazonSQSClientBuilder.standard().withRegion(Regions.US_EAST_1).build();
//
//        SendMessageRequest send_msg_request = new SendMessageRequest()
//                .withQueueUrl(url)
//                .withMessageBody(message)
//                .withDelaySeconds(2);
//        sqs.sendMessage(send_msg_request);
//    }
//
////    public static void main(String[] args) {
//        /*
//         * Create a new instance of the builder with all defaults (credentials
//         * and region) set automatically. For more information, see
//         * Creating Service Clients in the AWS SDK for Java Developer Guide.
//         */
//
////        sendMessage();
//
////        AmazonSQS sqs = AmazonSQSClientBuilder.defaultClient();
////        sqs.setRegion(Region.getRegion(Regions.US_EAST_1));
////
////        System.out.println("===============================================");
////        System.out.println("Getting Started with Amazon SQS Standard Queues");
////        System.out.println("===============================================\n");
////
////        try {
////            // Create a queue.
////            System.out.println("Creating a new SQS queue called MyQueue.\n");
////            final CreateQueueRequest createQueueRequest =
////                    new CreateQueueRequest("MyQueue");
////            final String myQueueUrl = sqs.createQueue(createQueueRequest)
////                    .getQueueUrl();
////
////            // List all queues.
////            System.out.println("Listing all queues in your account.\n");
////            for (final String queueUrl : sqs.listQueues().getQueueUrls()) {
////                System.out.println("  QueueUrl: " + queueUrl);
////            }
////            System.out.println();
////
////            // Send a message.
////            System.out.println("Sending a message to MyQueue.\n");
////            sqs.sendMessage(new SendMessageRequest(myQueueUrl,
////                    "This is my message text."));
////
////            // Receive messages.
////            System.out.println("Receiving messages from MyQueue.\n");
////            final ReceiveMessageRequest receiveMessageRequest =
////                    new ReceiveMessageRequest(myQueueUrl);
////            final List<Message> messages = sqs.receiveMessage(receiveMessageRequest)
////                    .getMessages();
////            for (final Message message : messages) {
////                System.out.println("Message");
////                System.out.println("  MessageId:     "
////                        + message.getMessageId());
////                System.out.println("  ReceiptHandle: "
////                        + message.getReceiptHandle());
////                System.out.println("  MD5OfBody:     "
////                        + message.getMD5OfBody());
////                System.out.println("  Body:          "
////                        + message.getBody());
////                for (final Entry<String, String> entry : message.getAttributes()
////                        .entrySet()) {
////                    System.out.println("Attribute");
////                    System.out.println("  Name:  " + entry
////                            .getKey());
////                    System.out.println("  Value: " + entry
////                            .getValue());
////                }
////            }
////            System.out.println();
////
////            // Delete the message.
////            System.out.println("Deleting a message.\n");
////            final String messageReceiptHandle = messages.get(0).getReceiptHandle();
////            sqs.deleteMessage(new DeleteMessageRequest(myQueueUrl,
////                    messageReceiptHandle));
////
////            // Delete the queue.
////            System.out.println("Deleting the test queue.\n");
////            sqs.deleteQueue(new DeleteQueueRequest(myQueueUrl));
////        } catch (final AmazonServiceException ase) {
////            System.out.println("Caught an AmazonServiceException, which means " +
////                    "your request made it to Amazon SQS, but was " +
////                    "rejected with an error response for some reason.");
////            System.out.println("Error Message:    " + ase.getMessage());
////            System.out.println("HTTP Status Code: " + ase.getStatusCode());
////            System.out.println("AWS Error Code:   " + ase.getErrorCode());
////            System.out.println("Error Type:       " + ase.getErrorType());
////            System.out.println("Request ID:       " + ase.getRequestId());
////        } catch (final AmazonClientException ace) {
////            System.out.println("Caught an AmazonClientException, which means " +
////                    "the client encountered a serious internal problem while " +
////                    "trying to communicate with Amazon SQS, such as not " +
////                    "being able to access the network.");
////            System.out.println("Error Message: " + ace.getMessage());
////        }
//
//
//
//
////    }
//}