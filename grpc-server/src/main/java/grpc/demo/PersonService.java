package grpc.demo;

import entity.PersonRequest;
import entity.PersonResponse;
import io.grpc.stub.StreamObserver;

import java.util.UUID;

public class PersonService extends service.PersonServiceGrpc.PersonServiceImplBase {
    @Override
    public void post(PersonRequest request, StreamObserver<PersonResponse> responseObserver) {
        System.out.println("---------- Request -----------");
        System.out.print(request);
        System.out.println("------------ End -------------");
        responseObserver.onNext(PersonResponse.newBuilder()
                        .setId(UUID.randomUUID().toString())
                        .setAge(request.getAge())
                        .setFirstName(request.getFirstName())
                        .setLastName(request.getLastName())
                        .build());
        responseObserver.onCompleted();
    }
}
