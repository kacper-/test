package comt.hazelcast;

import com.hazelcast.cache.impl.HazelcastServerCachingProvider;
import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;

import javax.cache.Cache;
import javax.cache.CacheManager;
import javax.cache.Caching;
import javax.cache.configuration.MutableConfiguration;
import javax.cache.spi.CachingProvider;
import java.util.concurrent.BlockingQueue;

public class ClientTake {

    public static void main(String[] args) throws Exception {
        ClientConfig clientConfig = new ClientConfig();
        clientConfig.getNetworkConfig().addAddress("ubuntu1");

        HazelcastInstance client = HazelcastClient.newHazelcastClient(clientConfig);
        System.out.println(clientConfig.toString());

        CachingProvider cachingProvider = Caching.getCachingProvider(HazelcastServerCachingProvider.class.getName());
        CacheManager cacheManager = cachingProvider.getCacheManager();

        IMap<Object, Object> map = client.getMap("default");
        System.out.println(map.get("aaa"));

        //BlockingQueue<String> queue = client.getQueue("queue");
        //System.out.println(queue.take());

        HazelcastClient.shutdownAll();
    }
}
