package com.life.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

/**
 * 加密解密工具类
 *
 * @author fengzhou
 */
public class EnDecryptUtils extends org.springframework.util.DigestUtils {

  private static final Logger logger = LoggerFactory.getLogger(EnDecryptUtils.class);
  private static List<String> SEED;


  static {
    String[] contexts = new String[]{"abcdefjhijklmnopqrstuvwxyz", "ABCDEFJHIJKLMNOPQRSTUVWXYZ"};
    SEED = Arrays.stream(contexts).map(EnDecryptUtils::convertArray).flatMap(Arrays::stream)
        .collect(
            Collectors.toList());
  }

  /**
   * 字符串->数组
   *
   * @param str
   * @return
   */
  public static String[] convertArray(String str) {
    String regex = "";
    return str.split(regex);
  }

  /**
   * base64加密+随机数
   *
   * @param str
   * @return
   */
  public static String encryption(String str) {
    return randomChar() + Base64.getEncoder().encodeToString(str.getBytes());
  }

  /**
   * base64解密
   *
   * @param str
   * @return
   */
  public static String decryption(String str) {
    int startIndex = 6;
    int endIndex = str.length();
    byte[] bytes = str.substring(startIndex, endIndex).getBytes();
    return new String(Base64.getDecoder().decode(bytes));
  }

  /**
   * 产生一个六位数的随机字符
   *
   * @return
   */
  private static String randomChar() {
    int origin = 0;
    int bound = SEED.size();
    StringBuffer stringBuffer = new StringBuffer();
    for (int i = 0; i < 6; i++) {
      int index = ThreadLocalRandom.current().nextInt(origin, bound);
      stringBuffer.append(SEED.get(index));
    }
    return stringBuffer.toString();
  }
}




