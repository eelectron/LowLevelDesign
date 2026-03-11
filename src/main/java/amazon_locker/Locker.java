package amazon_locker;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Locker {
    private List<Compartment> compartments;
    private Map<String, AccessToken> accessTokens;

    public Locker(List<Compartment> compartments) {
        this.compartments = compartments;
    }

    public List<Compartment> getCompartments() {
        return compartments;
    }

    /**
     * Core logic :
     * 1 . Find compartment of appropriate size
     * 2 . Open the compartment
     * 3 . Deposit the package
     * 4 . generate access token
     * 5 . return access token code to customer
     *
     * @param pkg
     * @return
     */
    public String depositPackage(Package pkg) throws Exception {
        Compartment compartment = getAvailableCompartment(pkg);
        if (compartment == null) {
            throw new Exception("No compartment is available");
        }

        compartment.open();

        AccessToken accessToken = generateAccessToken(compartment);
        String code = accessToken.getCode();
        accessTokens.put(code, accessToken);

        compartment.makeUnavailable();
        return code;
    }

    private AccessToken generateAccessToken(Compartment compartment) {
        AccessToken accessToken = new AccessToken();
        String code = UUID.randomUUID().toString(); // some random string
        String access_token = UUID.randomUUID().toString();
        accessToken.setCode(code);
        accessToken.setAccessToken(access_token);
        return accessToken;
    }

    private Compartment getAvailableCompartment(Package pkg) {
        for (Compartment compartment : compartments) {
            if (compartment.isAvailable() && compartment.getSize() == pkg.getSize()) {
                return compartment;
            }
        }
        return null;
    }

    /**
     * Core logic :
     * 1. Lookup the code to get access token
     * 2. get the compartment
     * 3. open the compartment
     * 4. mark it available
     * 5. remove the code from map
     * @param code
     */
    public void pickupPackage(String code) {
        if (code == null || code.isEmpty()) {
            throw new IllegalArgumentException("Invalid code");
        }

        AccessToken accessToken = accessTokens.get(code);
        if (accessToken == null) {
            throw new IllegalArgumentException("accessToken is null");
        }

        Compartment compartment = accessToken.getCompartment();
        compartment.open();
        compartment.makeAvailable();
        accessTokens.remove(code);
    }
}
