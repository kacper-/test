package comt.mongo;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

public class MongoDB {
    public static void main(String[] args) {
        MongoClient mongoClient = MongoClients.create();
        for (String s : mongoClient.listDatabaseNames()) {
            System.out.println(s);
        }
    }
}
