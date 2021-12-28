package grpc;

import io.grpc.stub.StreamObserver;
import io.quarkus.grpc.GrpcService;
import ru.ched.DeleteRequest;
import ru.ched.DeleteResponse;
import ru.ched.AppServiceGrpc;

@GrpcService
public class IntService extends AppServiceGrpc.AppServiceImplBase {

    @Override
    public void deleteApp(DeleteRequest request, StreamObserver<DeleteResponse> responseObserver) {
        String code = request.getCode();
        DeleteResponse.Builder response = DeleteResponse.newBuilder();


        if (code != null){
            response.setStatus("Success delete!");
        } else {
            response.setStatus("Error delete!");
        }

        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }
}
