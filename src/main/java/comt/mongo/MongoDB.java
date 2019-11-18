package comt.mongo;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

public class MongoDB {
    public static void main(String[] args) {
        MongoClient mongoClient = MongoClients.create();
        for (String s : mongoClient.listDatabaseNames()) {
            System.out.println(s);
            mongoClient.getDatabase(s);
            for(String c : mongoClient.getDatabase(s).listCollectionNames()) {
                System.out.println("\t"+c);
                System.out.println("\t\t"+mongoClient.getDatabase(s).getCollection(c).countDocuments());
            }
        }
    }
}
