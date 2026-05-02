package br.com.pescador;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;


// acesso ao banco
public class Repository {
    private final MongoCollection<Document> collection;
    public Repository() {
        this.collection = MongoConnection.getDatabase().getCollection("pescadores");
    }

    // CREATE (cadastrar)
    public void salvar(Pescador pescador) {
        // chave, valor
        Document doc = new Document("nome", pescador.getNome());
        doc.append("cpf", pescador.getCpf());
        doc.append("senha", pescador.getSenha());
        doc.append("dataNascimento", pescador.getDataNascimento());
        doc.append("telefone", pescador.getTelefone());

        // insere as informações do pescador no banco de dados
        collection.insertOne(doc);
    }

    // READ (listar os pescadores)
    public List<Pescador> listarPescadores() {
        List<Pescador> pescadores = new ArrayList<>();

        FindIterable<Document> docParaPescador = collection.find();
        for(Document doc : docParaPescador) {
            Pescador p = new Pescador();
            p.setId(doc.getObjectId("_id").toString());
            p.setNome(doc.getString("nome"));
            p.setCpf(doc.getString("cpf"));
            p.setSenha(doc.getString("senha"));
            p.setDataNascimento(doc.getString("dataNascimento"));
            p.setTelefone(doc.getString("telefone"));

            pescadores.add(p);
        }
        return pescadores;
    }

    // READ (buscar por cpf)
    public Pescador procurarPescador(String cpf) {
        Pescador p = new Pescador();
        Document doc = collection.find(new Document("cpf", cpf)).first();
        if(doc != null) {
            p.setId(doc.getObjectId("_id").toString());
            p.setNome(doc.getString("nome"));
            p.setCpf(doc.getString("cpf"));
            p.setSenha(doc.getString("senha"));
            p.setDataNascimento(doc.getString("dataNascimento"));
            p.setTelefone(doc.getString("telefone"));
            return p;
        } else {
            return null;
        }
    }

    // UPDATE (atualizar)
    public void atualizarDados(Pescador pescador) {
        // seleciona quem será atualizado (feito através de um dado, como o CPF)
        collection.updateOne(
                new Document("cpf", pescador.getCpf()),
                // a partir do $set, ele indica ao Mongo que irá fazer atualizações nos campos (chaves)
                new Document("$set", new Document("nome", pescador.getNome())
                        .append("senha", pescador.getSenha())
                        .append("dataNascimento", pescador.getDataNascimento())
                        .append("telefone", pescador.getTelefone())
                )
        );
    }

    // DELETE (remover o cadastro do pescador)
    public void removerCadastro(Pescador pescador) {
        collection.deleteOne(new Document("_id", pescador.getId()));
    }

}
