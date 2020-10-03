package Service;

import Model.User;

public class JwtUtil {
    private String secret;
    public User parseToken(String token){
        try{
            Claims body = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();

            User u = new User();
            u.setUsername(body.getSubject());
            u.setId(Long.parseLong((String) body.get("userId")));
            u.setRole((String) body.get("role"));

            return u;


        }
    } catch(JwtException | ClassCastException e){
        return null;

    }
}
public String generateToken(User u){
    Claims claims=Jwts.claims().setSubject(u.getUsername());
    claims.put("userId",.getId()+"");
    return Jwts.builder()
            .setClaims(claims)
            .setWith(SignatureAlgorithm.HS512,secret)
            .compact();

}
}