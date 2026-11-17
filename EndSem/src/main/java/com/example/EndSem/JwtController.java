
package com.example.EndSem;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.EndSem.JwtRequest;
import com.example.EndSem.JwtResponse;
import com.example.EndSem.JwtTokenUtil;

@RestController
@RequestMapping("/api")
public class JwtController {

    private final JwtTokenUtil jwtTokenUtil;

    public JwtController(JwtTokenUtil jwtTokenUtil) {
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @PostMapping("/jwt")
    public ResponseEntity<JwtResponse> validateJwt(
            @RequestBody JwtRequest request) {

        Map<String, Object> claims =
                jwtTokenUtil.validateToken(request.getToken());

        return ResponseEntity.ok(
                new JwtResponse(true, claims)
        );
    }

    @GetMapping("/generate-token")
    public String generateToken() {

        return jwtTokenUtil.generateDemoToken();
    }
}
