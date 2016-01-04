package br.com.alura.escola.daos;

import br.com.alura.escola.models.Aluno;
import br.com.alura.escola.models.Curso;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import org.bson.Document;

/**
 * Created by felipeweb on 11/25/15.
 */
public class AlunoDao {
	private MongoCollection<Document> collection;

	@PostConstruct
	public void startCollection() throws UnknownHostException {
		MongoDatabase db = new MongoClient("localhost").getDatabase("escola");
		this.collection = db.getCollection("aluno");
	}

	public List<Aluno> listaTudo() {
		List<Aluno> alunos = new ArrayList<>();
		MongoCursor<Document> cursor = collection.find().iterator();
		try {
			while (cursor.hasNext()) {
				Document document = cursor.next();
				Aluno aluno = new Aluno();
				aluno.setId(document.getObjectId("_id").toString());
				aluno.setNome(document.getString("nome"));
				aluno.setDataDeNascimento(document.getDate("data_nascimento"));
				Curso curso = new Curso();
				curso.setNome(document.getString("curso.nome"));
				aluno.setCurso(curso);
				alunos.add(aluno);
			}
		} finally {
			cursor.close();
		}
		return alunos;
	}
}