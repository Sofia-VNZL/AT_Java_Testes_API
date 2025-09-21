package org.example;
import io.javalin.Javalin;
import io.javalin.http.Context;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EndPointController {
    /// rubrica 1
    public static void config(Javalin app){
        app.get("/hello", EndPointController::getHello);
        System.out.println("Acesse à parte 1 usando http://localhost:7000/hello");

        app.get("/status", EndPointController::getStatus);
        System.out.println("Acesse à parte 2 usando http://localhost:7000/status");

        app.post("/echo", EndPointController::postEcho);
        System.out.println("Acesse à parte 3 usando http://localhost:7000/echo");

        app.get("/saudacao/{nome}", EndPointController::getSaudacao);
        System.out.println("Acesse à parte 4 usando http://localhost:7000/saudacao/Sofia");

    }


    public static void getHello(Context ctx) {
        ctx.status(200);
        ctx.result("Hello, javalin!");

    }

    public static void getStatus(Context ctx) {
        ctx.json(Map.of(
                "status", "ok",
                "timestamp", Instant.now().toString()
        ));
    }

    public static void postEcho(Context ctx) {
        String mensagem = (String) ctx.bodyAsClass(Map.class).get("mensagem");
        ctx.json(Map.of("mensagem", mensagem));
    }



    public static void getSaudacao(Context ctx) {
        String nome = ctx.pathParam("nome");
        ctx.json(Map.of("mensagem", "Olá, " + nome + "!"));
    }

    /// rubrica 2
    public static void iniciarMensalistas(Javalin app) {
        app.get("/mensalistas", EndPointController::listarMensalistas);
        app.get("/mensalistas/{matricula}", EndPointController::buscarMensalista);
        app.post("/mensalistas", EndPointController::criarMensalista);
    }
    public static List<Mensalista> mensalistas = new ArrayList<>();

    public static void criarMensalista(Context ctx) {
        Mensalista novo = ctx.bodyAsClass(Mensalista.class);
        mensalistas.add(novo);
        ctx.status(201);
        ctx.result("Mensalista criado com sucesso!!!");
    }

    public static void buscarMensalista(Context ctx) {
        String matricula = ctx.pathParam("matricula");
        Mensalista encontrado = mensalistas.stream()
                .filter(m -> m.matricula.equals(matricula))
                .findFirst()
                .orElse(null);

        if (encontrado != null) {
            ctx.json(encontrado);
        } else {
            ctx.status(404).result("Mensalista não encontrado!");
        }
    }

    public static void listarMensalistas(Context ctx) {
        ctx.json(mensalistas);
    }



}
