package com.jason.boot.utils;

import java.io.UnsupportedEncodingException;
import java.security.Key;
import java.util.Date;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import org.apache.tomcat.util.codec.binary.Base64;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
/**
 * 
 * @author jason
 *
 */
public class Jwt {
    public static String createJWT( String userNo,long TTLMillis, String base64Security) 
    {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);

        //生成签名密钥
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(base64Security);
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

          //添加构成JWT的参数
        JwtBuilder builder = Jwts.builder().setHeaderParam("typ", "JWT")
        				   .setHeaderParam("alg", "HS256")
        				   .claim("userNo",userNo)
        				   .setIssuedAt(now)
        				   .setExpiration(new Date(nowMillis+TTLMillis))
        				   .signWith(signatureAlgorithm, signingKey);
                                        /*.claim("role", role)
                                        .claim("userName", name)
                                        .claim("userId", userId)
                                        .setIssuer(issuer)
                                        .setAudience(audience)
                                        .signWith(signatureAlgorithm, signingKey);*/
         //添加Token过期时间
        if (TTLMillis >= 0) {
            long expMillis = nowMillis + TTLMillis;
            Date exp = new Date(expMillis);
            builder.setExpiration(exp).setNotBefore(now);
        }
         //生成JWT
        return builder.compact();
    } 
    
	 public static Claims parseJWT(String jsonWebToken, String base64Security){
	        try
	        {
	            Claims claims = Jwts.parser()
	                       .setSigningKey(DatatypeConverter.parseBase64Binary(base64Security))
	                       .parseClaimsJws(jsonWebToken).getBody();
	            return claims;
	        }
	        catch(Exception ex)
	        {
	            return null;
	        }
	    }
    
    public static void main(String[] args) throws UnsupportedEncodingException {
	String Str64 = Base64.encodeBase64URLSafeString("jason".getBytes());
	long time = 30*60*1000;
	String result = createJWT("1705177",time,Str64);
	System.out.println(result);
	//eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.
	//eyJ1c2VyTm8iOiIxNzA1MTc3IiwiaWF0IjoxNTI5OTE3NzgxLCJleHAiOjE1Mjk5MTk1ODEsIm5iZiI6MTUyOTkxNzc4MX0.
	//iZtw_oiQhNPDozLZdyOxHsgjU92HDQ7ooFz1-tVQL0k
	String header = new String(Base64.decodeBase64("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9"),"UTF-8");
	String payload = new String(Base64.decodeBase64("eyJ1c2VyTm8iOiIxNzA1MTc3IiwiaWF0IjoxNTI5OTE3NzgxLCJleHAiOjE1Mjk5MTk1ODEsIm5iZiI6MTUyOTkxNzc4MX0"),"UTF-8");
	String HS256 = new String(Base64.decodeBase64("iZtw_oiQhNPDozLZdyOxHsgjU92HDQ7ooFz1"),"UTF-8");
	System.out.println(header);
	System.out.println(payload);
	System.out.println(HS256);
	System.out.println("---------------------------------------------------------");
	Claims claims = parseJWT(result,Str64);
	System.out.println(claims.getIssuedAt().getTime());
	System.out.println(claims.getExpiration().getTime());
	System.out.println(claims.getIssuedAt().getTime());
	System.out.println(claims.get("userNo"));
    }
}
