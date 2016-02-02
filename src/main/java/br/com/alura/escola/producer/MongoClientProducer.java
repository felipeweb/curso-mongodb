package br.com.alura.escola.producer;

import com.mongodb.MongoClient;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;

/**
 * Created by felipeweb on 2/2/16.
 */
public class MongoClientProducer {
	@Produces
	@RequestScoped
	public MongoClient getClient() {
		return new MongoClient("localhost");
	}

	public void close(@Disposes MongoClient client) {
		client.close();
	}
}
