package br.com.alura.escola.dao;

import br.com.alura.escola.model.Aluno;
import br.com.alura.escola.model.Curso;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.inject.Inject;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 * Created by felipeweb on 11/25/15.
 */
public class AlunoDao {
	private final MongoCollection<Document> collection;

	/**
	 * @deprecated CDI eyes only
	 */
	public AlunoDao() {
		this(null);
	}

	@Inject
	public AlunoDao(MongoClient client) {
		this.collection = client.getDatabase("escola").getCollection("aluno");
	}

	public List<Aluno> lista() {
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

	public void insere(Aluno aluno) {
		collection.insertOne(transformaAlunoEmDocument(aluno));
	}

	public void atualiza(Aluno aluno) {
		collection.updateOne(new Document("_id", new ObjectId(aluno.getId())), new Document("$set", transformaAlunoEmDocument(aluno)));
	}

	public void atualizaNota(String id, Integer nota) {
		collection.updateOne(new Document("_id", new ObjectId(id)), new Document("$push", new Document("notas", Arrays.asList(nota))));
	}

	public Aluno listaPorId(String id) {
		Document document = collection.find(new Document("_id", new ObjectId(id))).first();
		return transformaDocumentEmAluno(document);
	}

	public void remove(String id) {
		collection.deleteOne(new Document("_id", new ObjectId(id)));
	}

	private Aluno transformaDocumentEmAluno(Document document) {
		List<Integer> notas = (List<Integer>) document.get("notas");
		String nomeDoCurso = ((Document) document.get("curso")).getString("nome");
		return new Aluno(document.getObjectId("_id").toString(),
				document.getString("nome"),
				document.getDate("data_nascimento"),
				new Curso(nomeDoCurso), notas);
	}

	private Document transformaAlunoEmDocument(Aluno aluno) {
		return new Document("nome", aluno.getNome())
				.append("data_nascimento", aluno.getDataDeNascimento())
				.append("curso", new Document("nome", aluno.getCurso().getNome()))
				.append("notas", aluno.getNotas());
	}
}