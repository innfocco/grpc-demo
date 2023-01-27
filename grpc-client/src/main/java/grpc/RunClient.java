package grpc;

import entity.PersonRequest;
import entity.PersonResponse;
import io.grpc.Grpc;
import io.grpc.InsecureChannelCredentials;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import service.PersonServiceGrpc;


import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class RunClient {
    public static void main(String[] args) throws InterruptedException, IOException {
        ManagedChannel channel = Grpc.newChannelBuilder("localhost:7565", InsecureChannelCredentials.create()).build();
        PersonServiceGrpc.PersonServiceBlockingStub stub = PersonServiceGrpc.newBlockingStub(channel);
        PersonResponse response = stub.post(PersonRequest.newBuilder()
                .setFirstName("Julio")
                .setLastName("Marques")
                .setAge(35)
                .build());
        System.out.println(response);
        channel.awaitTermination(5, TimeUnit.SECONDS);
    }
}
