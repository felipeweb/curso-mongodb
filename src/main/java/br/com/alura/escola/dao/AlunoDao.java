package br.com.alura.escola.dao;

import br.com.alura.escola.model.Aluno;
import br.com.alura.escola.model.Curso;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PreDestroy;
import org.bson.Document;

/**
 * Created by felipeweb on 11/25/15.
 */
public class AlunoDao {
	private final MongoCollection<Document> collection;
	private final MongoClient client;

	public AlunoDao() {
		this.client = new MongoClient("localhost");
		this.collection = client.getDatabase("escola").getCollection("aluno");
	}

	public List<Aluno> listaTudo() {
		List<Aluno> alunos = new ArrayList<>();
		try (MongoCursor<Document> cursor = collection.find().iterator()) {
			while (cursor.hasNext()) {
				Document document = cursor.next();
				Aluno aluno = transformaDocumentEmCurso(document);
				alunos.add(aluno);
			}
		}
		return alunos;
	}

	private Aluno transformaDocumentEmCurso(Document document) {
		return new Aluno(document.getObjectId("_id").toString(),
				document.getString("nome"),
				document.getDate("data_nascimento"),
				new Curso(document.getString("curso.nome")));
	}

	@PreDestroy
	public void close() {
		client.close();
	}
}