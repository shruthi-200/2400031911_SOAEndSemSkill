
package com.example.EndSem;

import java.util.Map;

public class JwtResponse {

    private boolean valid;

    private Map<String, Object> claims;

    public JwtResponse(boolean valid, Map<String, Object> claims) {
        this.valid = valid;
        this.claims = claims;
    }

    public boolean isValid() {
        return valid;
    }

    public Map<String, Object> getClaims() {
        return claims;
    }
}
