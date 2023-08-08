package org.example;
import io.grpc.stub.StreamObserver;
import org.example.grpc.GreatingService;
import org.example.grpc.GreetingServiceGrpc;

public class GreetingServiceImplementation extends GreetingServiceGrpc.GreetingServiceImplBase {
    @Override
    public void greeting(GreatingService.HelloRequest request, StreamObserver<GreatingService.HelloResponse> responseObserver) {
        System.out.println(request);

        GreatingService.HelloResponse response = GreatingService.HelloResponse.
                newBuilder().setGreeting("Hello from server "+request.getName()).build();

        responseObserver.onNext(response);

        responseObserver.onCompleted();
    }
}
