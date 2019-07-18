
# Messaage Queue - AWS SQS

A repository for a Java application that uses AWS SQS.

### To run:

- To send:

        ./gradlew run --args='send hello'
        
        // ./gradlew run --args='send ['message you want to send]'

- To receive:
       
        ./gradlew run --args='receive'

### API

        public static void sendMessage(String message)
        
        public static void receiveMessages()