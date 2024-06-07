package hieuubuntu.com.profileservice.configuration;

import com.nimbusds.jwt.SignedJWT;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtException;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.stereotype.Component;

import java.text.ParseException;

// Cung cấp cho authentication provider 1 decoder:
// Các thuật toán + thông số như cách đã mã hóa và tạo ra token trước đó

@Component
public class JwtDecoderImpl implements JwtDecoder {
    // JwtDecoder được sử dụng trong vòng lặp forEach, khởi tạo Nimbus 1 lần duy nhất.
    private NimbusJwtDecoder nimbusJwtDecoder = null;

    @Override
    public Jwt decode(String token) throws JwtException {
        try {
            SignedJWT signedJWT = SignedJWT.parse(token);

            return new Jwt(token,
                    signedJWT.getJWTClaimsSet().getIssueTime().toInstant(),
                    signedJWT.getJWTClaimsSet().getExpirationTime().toInstant(),
                    signedJWT.getHeader().toJSONObject(),
                    signedJWT.getJWTClaimsSet().getClaims()
            );
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

    }
}
