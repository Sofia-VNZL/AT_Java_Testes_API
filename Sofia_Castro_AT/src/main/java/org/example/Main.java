package org.example;
import io.javalin.Javalin;

public class Main {
    public static void main(String[] args) {
        EndPointController.mensalistas.add(new Mensalista("Sofia", "123"));
        EndPointController.mensalistas.add(new Mensalista("Carlos", "456"));
        EndPointController.mensalistas.add(new Mensalista("Ana", "789"));

        /// Rubrica 1
        var app = Javalin.create().start(7000);
        app.get("/", context -> context.result("Servidor online!"));
        EndPointController.config(app);
        EndPointController.iniciarMensalistas(app);
    }
}