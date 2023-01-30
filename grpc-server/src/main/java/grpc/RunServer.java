package grpc;

import grpc.demo.PersonService;
import io.grpc.Grpc;
import io.grpc.InsecureServerCredentials;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class RunServer {
    public static void main(String[] args) throws InterruptedException, IOException {
        final Server server = Grpc.newServerBuilderForPort(7565, InsecureServerCredentials.create())
                .addService(new PersonService())
                .build()
                .start();
        Runtime.getRuntime().addShutdownHook(new Thread(){ // graceful shutdown
            @Override
            public void run() {
                if (server != null) {
                    try {
                        server.shutdown().awaitTermination(20, TimeUnit.SECONDS);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
        System.out.println(">>>>> Server is running on port 7565 \n\n");
        if (server != null) {
            server.awaitTermination();
        }
    }
}
