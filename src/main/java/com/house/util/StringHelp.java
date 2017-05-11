package com.house.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;

public class StringHelp {

	/**
     * 判断字符串是否为空（null/空串）
     * 
     * @param str
     * @return
     */
    public static Boolean isNullOrEmpty(String str) {
        if (str == null)
            return true;
        return str.isEmpty();
    }

    /**
     * 判断字符串是否为空（null/空串/空格）
     * 
     * @param str
     * @return
     */
    public static Boolean isNullOrBlank(String str) {
        if (str == null)
            return true;
        return str.trim().isEmpty();
    }

    /**
     * 判断字符串是否相等 只要有一个是null即判定为不相等
     * 
     * @param str1
     * @param str2
     * @return
     */
    public static Boolean equals(String str1, String str2) {
        if (str1 == null || str2 == null)
            return false;
        return str1.equals(str2);
    }

    /**
     * 返回字符串 长度 字符串为null时返回0
     * 
     * @param str
     * @return
     */
    public static Integer length(String str) {
        if (isNullOrEmpty(str))
            return 0;
        return str.length();
    }

    public static String bytesToHexString(byte[] encrytpByte) {
        if (encrytpByte == null)
            return null;
        StringBuffer result = new StringBuffer();
        for (Byte bytes : encrytpByte) {
            String hex = Integer.toHexString(bytes & 0XFF);
            if (hex.length() == 1) {
                result.append("0");
            }
            result.append(hex);
        }
        return result.toString();
    }

    public static byte[] stringToBytes(String str) {
        if (str == null)
            return null;
        return str.getBytes();
    }

    public static String convertNullToEmpty(String str) {
        if (str == null)
            return "";
        return str;
    }

    public static String convertNullToEmpty(Object str) {
        if (str == null)
            return "";
        return str.toString();
    }

    public static String convertXML(String str) {
        if (str == null)
            return "";
        return str.replace("<", "&lt; ").replace(">", "&gt;").replace("'", "&apos;").replace("\"", "&quot;")
                .replace("&", "&amp;");
    }

    public static String splitString(String input, int length) {
        if (input == null || input.trim().equals("")) {
            return "";
        }
        String str = input.replaceAll("\\&[a-zA-Z]{1,10};", "").replaceAll("<[^>]*>", "");
        str = str.replaceAll("[(/>)<]", "");
        int len = str.length();
        if (len <= length) {
            return str;
        } else {
            str = str.substring(0, length);
            str += "...";
        }
        return str;
    }

    /**
     * 得到网页中图片的地址
     */
    public static List<String> getImgStr(String htmlStr) {
        htmlStr = htmlStr.replaceAll("_src", " ");
        String img = "";
        Pattern p_image;
        Matcher m_image;
        List<String> pics = new ArrayList<String>();

        // String regEx_img = "<img.*src=(.*?)[^>]*?>"; //图片链接地址

        String regEx_img = "<img.*src\\s*=\\s*(.*?)[^>]*?>";
        p_image = Pattern.compile(regEx_img, Pattern.CASE_INSENSITIVE);
        m_image = p_image.matcher(htmlStr);
        while (m_image.find()) {
            img = img + "," + m_image.group();
            // Matcher m =
            // Pattern.compile("src=\"?(.*?)(\"|>|\\s+)").matcher(img); //匹配src

            Matcher m = Pattern.compile("src\\s*=\\s*\"?(.*?)(\"|>|\\s+)").matcher(img);
            while (m.find()) {
                pics.add(m.group(1));
            }
        }
        return pics;
    }

    /**
     * 获取访问者IP
     * 
     * 在一般情况下使用Request.getRemoteAddr()即可，但是经过nginx等反向代理软件后，这个方法会失效。
     * 
     * 本方法先从Header中获取X-Real-IP，如果不存在再从X-Forwarded-For获得第一个IP(用,分割)，
     * 如果还不存在则调用Request .getRemoteAddr()。
     * 
     * @param request
     * @return
     */
    public static String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("X-Real-IP");
        if (!StringUtils.isBlank(ip) && !"unknown".equalsIgnoreCase(ip)) {
            return ip;
        }
        ip = request.getHeader("X-Forwarded-For");
        if (!StringUtils.isBlank(ip) && !"unknown".equalsIgnoreCase(ip)) {
            // 多次反向代理后会有多个IP值，第一个为真实IP。
            int index = ip.indexOf(',');
            if (index != -1) {
                return ip.substring(0, index);
            } else {
                return ip;
            }
        } else {
            return request.getRemoteAddr();
        }
    }
   /**
    * 字符串转成int 
    * 默认1
    * @param str
    * @return
    */
    public static int strToInt(String str){
    	if(!isNullOrBlank(str)){
    		return Integer.parseInt(str);
    	}else{
    		return 1;
    	}
    }
    public static void main(String[] args) {
        String html = "<html>\r\n" + "<head><title>test</title><head>\r\n" + "<body>"
                + "<P><IMG   height=\"100\"       src='abc.png'   weight=\"30\">abcdefg"
                + "<img   src='http://abc.xyz.com/123/456.jpg'   /><br>" + "<IMG   height=\"100\"       \r\n"
                + "       src=\"abc.jpg\"   \r\n" + "   weight=\"30\">abcdefg         \r\n" + "   <img   src=ttt.jpg>"
                + "   <img   src=123.jpg   />" +
                // "<img   alt=\"src='abc'\">" + //这种我也无能为力
                "</body></html>";

        System.out.println(getImgStr(html));
        //HttpServletRequest request=ServletActionContext.getRequest();
       // System.out.println(getIpAddr(request));
    }
    
    
    
}
