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

    private static final String GRPC_SERVER_HOST =
            System.getenv("GRPC_SERVER_HOST") == null ? "localhost" : System.getenv("GRPC_SERVER_HOST");
    public static void main(String[] args) throws InterruptedException, IOException {
        ManagedChannel channel = Grpc.newChannelBuilder(GRPC_SERVER_HOST+":7565",
                InsecureChannelCredentials.create())
                .build();
        PersonServiceGrpc.PersonServiceBlockingStub stub = PersonServiceGrpc.newBlockingStub(channel);
        for(int x = 0; x<100; x++) {
            int age = RandomName.Age.next();
            PersonResponse response = stub.post(PersonRequest.newBuilder()
                    .setFirstName(RandomName.FirstName.next())
                    .setLastName(RandomName.LastName.next())
                    .setAge(age)
                    .build());
            System.out.println(response);
            Thread.sleep(age*10);
        }
        channel.awaitTermination(5, TimeUnit.SECONDS);
    }
}
