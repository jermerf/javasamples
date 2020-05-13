public class TMP {
    public static void main(String[] args) {
        String r = "a toyota";

        String r1 = r.replace( "toyot", "TOYOT" );
        String r2 = r.replace( 't','T' );
        r2 = r.replace( 'o','0' );
        r2 = r.replace( 'y','Y' );
        String r3 = r.replace( 't','T' ).replace( 'o', '0' ).replace( 'y', 'Y' );
        String r4 = r.substring( 2, 4 ).toUpperCase();



    }
}
