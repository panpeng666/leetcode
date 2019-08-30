//package test;
//
//import java.security.NoSuchAlgorithmException;
//
//public class test {
//
//    public static String getSecretKey(String appkey, String appsecret, String method) throws NoSuchAlgorithmException {
//        StringBuffer sb = new StringBuffer();
//        sb.append(SystemParametersEnum.APPKEY.getName()).append(appkey).append(SystemParametersEnum. APPSECRET.getName()).append(appsecret).append(SystemParametersEnum.METHOD.getName()).append( method);
//        return MD5Util.encryptMD5(sb.toString()); }
//}
