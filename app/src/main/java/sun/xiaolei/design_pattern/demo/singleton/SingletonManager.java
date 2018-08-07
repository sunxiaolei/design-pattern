package sun.xiaolei.design_pattern.demo.singleton;

import java.util.HashMap;
import java.util.Map;

/*
 * @author sun
 * description:容器管理
 */
public class SingletonManager {

    private static Map<String, Object> instances = new HashMap<>();

    private SingletonManager() {

    }

    public static void registerService(String key, Object instance) {
        if (!instances.containsKey(key)) {
            instances.put(key, instance);
        }
    }

    public static Object getService(String key) {
        return instances.get(key);
    }


}
