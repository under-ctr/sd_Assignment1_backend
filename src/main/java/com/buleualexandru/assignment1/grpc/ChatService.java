package com.buleualexandru.assignment1.grpc;

import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


@GRpcService
public class ChatService extends ChatServiceGrpc.ChatServiceImplBase {


    private final Map<StreamObserver<ChatMessage>, String> subscribers = new ConcurrentHashMap<>();
    private final List<ChatMessage> messages = new ArrayList<>();
    @Override
    public void subscribeToChat(Subscription request, StreamObserver<ChatMessage> responseObserver) {
        String id = request.getId();
        subscribers.put(responseObserver, id);
        responseObserver.onNext(ChatMessage.newBuilder()
                .setMessage("Welcome to the chat, your client id is " + id)
                .build());
        messages.forEach(responseObserver::onNext);
        responseObserver.onCompleted();

    }

    @Override
    public void unsubscribeFromChat(Subscription request, StreamObserver<ChatMessage> responseObserver) {
        String id = request.getId();
        subscribers.remove(request.getId());
        responseObserver.onNext(ChatMessage.newBuilder()
                .setMessage("Bye client:  " + id)
                .build());
        messages.forEach(responseObserver::onNext);
        responseObserver.onCompleted();

    }

    @Override
    public void sendMessage(ChatMessage request, StreamObserver<ChatMessage> responseObserver) {

        String receivedMessage = request.getMessage();
        String id = request.getId();

        ChatMessage message = ChatMessage.newBuilder()
                .setMessage(receivedMessage)
                .setId(id)
                .build();

        responseObserver.onNext(message);
        responseObserver.onCompleted();

    }
}
