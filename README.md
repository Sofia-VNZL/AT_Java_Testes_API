Rubrica 1 - Preparar o ambiente para desenvolvimento local com Java (aqui espera-se 4 prints de tela):
Crie um projeto Maven com Javalin e implemente os endpoints abaixo relacionados:

Implemente um endpoint /hello, retornando "Hello, Javalin!".
Implemente um endpoint GET chamado /status que retorna um JSON contendo status: ok e timestamp com a hora atual no formato ISO-8601.
Implemente um endpoint POST chamado /echo, que recebe um JSON com a chave mensagem e retorna o mesmo conteúdo como resposta.
Implemente um endpoint GET com path parameter /saudacao/{nome} que retorna: { "mensagem": "Olá, <nome>!" }
Rubrica 2 - Desenvolver testes unitários usando JUnit:
Implemente os testes relacionados abaixo no projeto criado na Rubrica 1 e que será complementado pela Rubrica 4, enunciada mais adiante:

Escreva um teste para o endpoint /hello, validando status 200 e a resposta "Hello, Javalin!" (endpoint da Rubrica 1).
Escreva um teste para o endpoint de criação (POST), simulando a criação de um novo Mensalista e verificando se o status retornado é 201 (endpoint da Rubrica 4).
Escreva um teste para o endpoint de busca Mensalista pela matrícula (GET com path param), verificando se um item recém-cadastrado pode ser recuperado corretamente (endpoint da Rubrica 4).
Escreva um teste para o endpoint de listagem (GET) de todos os Mensalistas, garantindo que ele retorne um array JSON não vazio após a criação de pelo menos um item (endpoint da Rubrica 4).
Rubrica 3 - Consumir serviços web (RESTful APIs) com Java:
Crie um novo projeto Maven para implementar as classes clientes HttpURLConnection para os endpoints criados nas Rubricas 1 e 4:

Crie um cliente Java que envie uma requisição POST para o endpoint de criação de um Mensalista, com um JSON representando um novo item do seu sistema (endpoint da Rubrica 4).
Crie um cliente Java que realize uma requisição GET para o endpoint de listagem de todos os Mensalistas e imprima os dados retornados no console (endpoint da Rubrica 4).
Crie um cliente Java que envie uma requisição GET com path param, buscando um Mensalista pela matrícula e imprima os dados retornados no console (endpoint da Rubrica 4).
Crie um cliente Java que envie uma requisição GET para o endpoint /status e imprima o JSON com o status e timestamp (endpoint da Rubrica 1).
Rubrica 4 - Desenvolver serviços web (RESTful API) usando Javalin (onde lê-se Spark, leia-se Javalin):
Usando o projeto Maven com Javalin criado na Rubrica 1, implemente os endpoints abaixo relacionados:

Implemente um endpoint GET para a obtenção da lista de todos os Mensalistas.
Implemente um endpoint GET para a obtenção de um Mensalista usando sua matrícula.
Implemente um endpoint POST para a criação de um Mensalista:
Parte 1: Implementação das classes do endpoint.
Parte 2: Validação dos dados de entrada.
