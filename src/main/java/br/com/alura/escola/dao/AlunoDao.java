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
				Aluno aluno = transformaDocumentEmAluno(document);
				alunos.add(aluno);
			}
		}
		return alunos;
	}

	public void insert(Aluno aluno) {
		collection.insertOne(transformaAlunoEmDocument(aluno));
	}

	private Aluno transformaDocumentEmAluno(Document document) {
		String nomeDoCurso = ((Document) document.get("curso")).getString("nome");
		return new Aluno(document.getObjectId("_id").toString(),
				document.getString("nome"),
				document.getDate("data_nascimento"),
				new Curso(nomeDoCurso));
	}

	private Document transformaAlunoEmDocument(Aluno aluno) {
		return new Document("nome", aluno.getNome())
				.append("data_nascimento", aluno.getDataDeNascimento())
				.append("curso", new Document("nome", aluno.getCurso().getNome()));
	}

	@PreDestroy
	public void close() {
		client.close();
	}
}