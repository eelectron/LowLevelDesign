package amazon_locker;

import java.util.Date;

public class AccessToken {
    private String accessToken;
    private String code;
    private Compartment compartment;
    private Date expiresAt;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Compartment getCompartment() {
        return compartment;
    }

    public void setCompartment(Compartment compartment) {
        this.compartment = compartment;
    }

    public boolean isExpired() {
        return expiresAt != null && expiresAt.before(new Date());
    }
}
