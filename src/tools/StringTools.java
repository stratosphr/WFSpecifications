package tools;

/**
 * Created by stratosphr on 30/03/15.
 */
public class StringTools {

    public static String join(Object[] children, String separator) {
        if (children == null || children.length == 0) {
            return "";
        } else {
            String res = "";
            for (int i = 0; i < children.length - 1; i++) {
                res += children[i] + separator;
            }
            res += children[children.length - 1];
            return res;
        }
    }

}
