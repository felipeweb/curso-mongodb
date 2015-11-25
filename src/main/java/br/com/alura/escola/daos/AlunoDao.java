package br.com.alura.escola.daos;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import java.net.UnknownHostException;
import javax.annotation.PostConstruct;

/**
 * Created by felipeweb on 11/25/15.
 */
public class AlunoDao {
	private DBCollection collection;

	@PostConstruct
	public void startCollection() throws UnknownHostException {
		DB db = new MongoClient("localhost").getDB("escola");
		this.collection = db.getCollection("aluno");
	}
}