package br.com.alura.escola.daos;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.net.UnknownHostException;
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
}