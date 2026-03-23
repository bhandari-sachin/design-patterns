import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AccessControlService {
    private static AccessControlService instance;
    private Map<String, Set<String>> accessMap;

    private AccessControlService() {
        accessMap = new HashMap<>();
    }
    public static AccessControlService getInstance() {
        if (instance == null) {
            instance = new AccessControlService();
        }
        return instance;
    }
    public void allowAccess(String username, String documentId){
        accessMap.putIfAbsent(username, new HashSet<>());
        accessMap.get(username).add(documentId);
    }
    public boolean isAllowed(String username, String documentId){
        return accessMap.containsKey(username) && accessMap.get(username).contains(documentId);
    }
}
