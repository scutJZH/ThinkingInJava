package io;

public class CodingInJava {

    public static void encode() {
        String name = "nothing is impossible 耐克";
        try{
            byte[] iso8859 = name.getBytes("ISO-8859-1");
            toHex(iso8859);
            byte[] gb2312 = name.getBytes("GB2312");
            toHex(gb2312);
            byte[] gbk = name.getBytes("GBK");
            toHex(gbk);
            byte[] utf16 = name.getBytes("utf-16");
            toHex(utf16);
            byte[] utf8 = name.getBytes("utf-8");
            toHex(utf8);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void toHex(byte[] src){
        StringBuilder stringBuilder = new StringBuilder();
        if (src == null || src.length <= 0) {
            return;
        }
        for (int i = 0; i < src.length; i++) {
            int v = src[i] & 0xFF;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }
        System.out.println(stringBuilder.toString());
    }

    public static void main(String[] args){
        encode();
    }
}
