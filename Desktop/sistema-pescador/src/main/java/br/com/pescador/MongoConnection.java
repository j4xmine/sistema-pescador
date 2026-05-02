package br.com.pescador;

import com.mongodb.client.MongoClient; // É A CONEXÃO ENTRE O PROGRAMA E O BANCO DE DADOS
import com.mongodb.client.MongoClients; // CLASSE USADA PARA FAZER A AÇÃO DE CIMA (CONEXÃO COM O BANCO DE DADOS)
import com.mongodb.client.MongoDatabase; // REPRESENTA O BANCO DE DADOS AQUI NO CÓDIGO (COMO SE FOSSE O BD AQUI NO CÓDIGO)

public class MongoConnection {

    private static final String URI = System.getenv("MONGO_URI");

    // método que retorna o banco de dados
    public static MongoDatabase getDatabase() {
        MongoClient mongoClient = MongoClients.create(URI);
        return mongoClient.getDatabase("pescadb");
    }

}
