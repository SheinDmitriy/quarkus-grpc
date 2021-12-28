import io.quarkus.grpc.GrpcClient;
import io.smallrye.mutiny.Uni;
import ru.ched.AppService;
import ru.ched.DeleteRequest;
import ru.ched.DeleteResponse;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/test")
public class ExampleResource {

    @GrpcClient("app")
    AppService appService;

    @GET
    @Path("/{name}")
    public Uni<String> hello(@PathParam("name") String name) {
        return appService.deleteApp(DeleteRequest.newBuilder().setCode(name).build())
                .onItem().transform(DeleteResponse::getStatus);
    }
}
