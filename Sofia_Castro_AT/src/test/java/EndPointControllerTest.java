
import io.javalin.Javalin;
import io.javalin.http.Context;
import org.example.EndPointController;
import org.example.Mensalista;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class EndPointControllerTest {
    @Test
    public void getHelloTest() {
        Context ctx = Mockito.mock(Context.class);
        EndPointController.getHello(ctx);

        Mockito.verify(ctx).status(200);
        Mockito.verify(ctx).result("Hello, javalin!");
    }

    @Test
    public void criarMensalistaTest() {
        Context ctx = Mockito.mock(Context.class);
        Mensalista novo = new Mensalista("Sofia", "123");
        Mockito.when(ctx.bodyAsClass(Mensalista.class)).thenReturn(novo);

        EndPointController.criarMensalista(ctx);

        Mockito.verify(ctx).status(201);
        Mockito.verify(ctx).result("Mensalista criado com sucesso!!!");
    }

    @Test
    public void buscarMensalistaTest() {
        Context ctx = Mockito.mock(Context.class);
        EndPointController.mensalistas.clear();
        EndPointController.mensalistas.add(new Mensalista("Sofia", "123"));

        Mockito.when(ctx.pathParam("matricula")).thenReturn("123");

        EndPointController.buscarMensalista(ctx);

        Mockito.verify(ctx).json(Mockito.argThat(m -> ((Mensalista) m).nome.equals("Sofia")));
    }

    @Test
    public void listarMensalistasTest() {
        Context ctx = Mockito.mock(Context.class);
        EndPointController.mensalistas.clear();
        EndPointController.mensalistas.add(new Mensalista("Sofia", "12345"));

        EndPointController.listarMensalistas(ctx);

        Mockito.verify(ctx).json(Mockito.argThat(lista ->
                lista instanceof List &&
                        ((List<?>) lista).size() > 0 &&
                        ((List<?>) lista).get(0) instanceof Mensalista
        ));
    }



}
