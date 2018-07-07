package pl.shopkeeper.shopkeeper.auth;

public class SecurityConstants {
    public static final String SECRET = "g9e8rj8ngj8dvd98jmkjbuy12g56vciuasnopkfdsnkn";
    public static final long EXPIRATION_TIME = 864_000_000; // 10 days
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String SIGN_UP_URL = "/users/";
}