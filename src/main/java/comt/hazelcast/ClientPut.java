package comt.hazelcast;

import com.hazelcast.cache.impl.HazelcastServerCachingProvider;
import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.config.NearCacheConfig;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;

import javax.cache.Cache;
import javax.cache.CacheManager;
import javax.cache.Caching;
import javax.cache.configuration.MutableConfiguration;
import javax.cache.spi.CachingProvider;
import java.util.concurrent.BlockingQueue;

import static com.hazelcast.cache.HazelcastCachingProvider.propertiesByInstanceItself;

public class ClientPut {

    public static void main(String[] args) throws Exception {
        NearCacheConfig nearCacheConfig = new NearCacheConfig("test");

        ClientConfig clientConfig = new ClientConfig();
        clientConfig.getNetworkConfig().addAddress("ubuntu1");
        clientConfig.addNearCacheConfig(nearCacheConfig);

        HazelcastInstance client = HazelcastClient.newHazelcastClient(clientConfig);
        System.out.println(clientConfig.toString());

        IMap<Object, Object> map = client.getMap("default");
        map.put("aaa", "bbb");

        //BlockingQueue<String> queue = client.getQueue("queue");
        //queue.put("Hello!");

        System.out.println("Message sent by Hazelcast Client!");

        HazelcastClient.shutdownAll();
    }
}
