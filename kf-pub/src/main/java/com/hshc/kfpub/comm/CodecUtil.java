package com.hshc.kfpub.comm;

import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;

/**
 * 
 * 加密解密工具类,进行RSA非对称性加解密及base64加解密
 * 
 * @className CodecUtil
 * @author 邢治理
 * @version V1.0 2016年3月16日 上午9:39:54
 */
public class CodecUtil {
    /**
     * RSA私钥
     */
    private RSAPrivateKey privateKey;
    /**
     * RSA私钥 密码器
     */
    private Cipher privateCipher;

    /**
     * RSA公钥
     */
    private RSAPublicKey publicKey;
    /**
     * RSA公钥 密码器
     */
    private Cipher publicCipher;

    /**
     * 随机生成RSA秘钥对
     * 
     * @author 邢治理
     * @since 2016年3月16日
     */
    public CodecUtil() {
        try {
            this.genKeyPair();
            this.createPublicCipher();
            this.createPrivateCipher();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * 使用已有的秘钥对
     * 
     * @param publicKey 公钥
     * @param privateKey 私钥
     * @author 邢治理
     * @since 2016年3月16日
     */
    public CodecUtil(String publicKey, String privateKey) {
        try {
            this.initRSAKey(publicKey, privateKey);
            this.createPublicCipher();
            this.createPrivateCipher();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * 使用已有的秘钥对 创建公钥密钥
     * 
     * @param publicKey 公钥字符串
     * @param privateKey 密钥字符串
     * @author 邢治理
     * @since 2016年3月16日
     */
    private void initRSAKey(String publicKey, String privateKey) {
        this.loadPublicKey(publicKey);
        this.loadPrivateKey(privateKey);

    }

    /**
     * 随机生成密钥对
     * 
     * @author 邢治理
     * @since 2016年3月16日
     */
    private void genKeyPair() {
        KeyPairGenerator keyPairGen = null;
        try {
            keyPairGen = KeyPairGenerator.getInstance("RSA");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("没有算法");
        }
        keyPairGen.initialize(1024, new SecureRandom());
        KeyPair keyPair = keyPairGen.generateKeyPair();
        this.privateKey = (RSAPrivateKey) keyPair.getPrivate();
        this.publicKey = (RSAPublicKey) keyPair.getPublic();
    }

    /**
     * 从字符串中加载公钥
     * 
     * @param publicKeyStr 公钥数据字符串
     * @author 邢治理
     * @since 2016年3月16日
     */
    private void loadPublicKey(String publicKeyStr) {
        try {
            byte[] buffer = Base64.decodeBase64(publicKeyStr);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(buffer);
            this.publicKey = (RSAPublicKey) keyFactory.generatePublic(keySpec);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("无此算法");
        } catch (InvalidKeySpecException e) {
            throw new RuntimeException("公钥非法");
        } catch (NullPointerException e) {
            throw new RuntimeException("公钥数据为空");
        }
    }

    /**
     * 生成公钥密码器
     * 
     * @author 邢治理
     * @since 2016年3月16日
     */
    private void createPublicCipher() {
        try {
            this.publicCipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            this.publicCipher.init(Cipher.ENCRYPT_MODE, this.publicKey);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("无此加密算法");
        } catch (NoSuchPaddingException e) {
            throw new RuntimeException("RSA/ECB/PKCS1Padding 无法使用此填充");
        } catch (InvalidKeyException e) {
            throw new RuntimeException("加密公钥非法,请检查");
        }

    }

    /**
     * 从字符串中加载私钥
     * 
     * @param publicKeyStr 私钥数据字符串
     * @author 邢治理
     * @since 2016年3月16日
     */
    private void loadPrivateKey(String privateKeyStr) {
        try {
            byte[] buffer = Base64.decodeBase64(privateKeyStr);
            PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(buffer);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            this.privateKey = (RSAPrivateKey) keyFactory.generatePrivate(keySpec);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("无此算法");
        } catch (InvalidKeySpecException e) {
            throw new RuntimeException("私钥非法");
        } catch (NullPointerException e) {
            throw new RuntimeException("私钥数据为空");
        }
    }

    /**
     * 生成私钥密码器
     * 
     * @throws Exception 生成私钥密码器时产生的异常
     * @author 邢治理
     * @since 2016年3月16日
     */
    private void createPrivateCipher() {
        try {
            this.privateCipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            this.privateCipher.init(Cipher.DECRYPT_MODE, this.privateKey);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("无此加密算法");
        } catch (NoSuchPaddingException e) {
            throw new RuntimeException("RSA/ECB/PKCS1Padding 无法使用此填充");
        } catch (InvalidKeyException e) {
            throw new RuntimeException("加密私钥非法,请检查");
        }

    }

    /**
     * 使用RSA算法加密
     * 
     * @param plain 明文
     * @return 密文
     * @author 邢治理
     * @since 2016年3月16日
     */
    public byte[] encryptRSA(byte[] plain) {
        byte[] output = null;
        try {
            output = this.publicCipher.doFinal(plain);
        } catch (IllegalBlockSizeException e) {
            throw new RuntimeException("明文长度非法");
        } catch (BadPaddingException e) {
            throw new RuntimeException("明文数据已损坏");
        }
        return output;
    }

    /**
     * 使用RSA算法加密,并对加密后byte[]数组进行base64加密
     * 
     * @param plain 明文
     * @return base64后的密文
     * @author 邢治理
     * @since 2016年3月16日
     */
    public String encryptRSA(String plain) {
        byte[] cipher = this.encryptRSA(plain.getBytes());
        return this.ecodeBase64(cipher);

    }

    /**
     * 使用RSA算法解密
     * 
     * @param cipher 密文
     * @return 明文
     * @author 邢治理
     * @since 2016年3月16日
     */
    public byte[] decryptRSA(byte[] cipher) {
        byte[] output = null;

        try {
            output = this.privateCipher.doFinal(cipher);
        } catch (IllegalBlockSizeException e) {
            throw new RuntimeException("密文长度非法");
        } catch (BadPaddingException e) {
            throw new RuntimeException("密文数据已损坏");
        }

        return output;
    }

    /**
     * 使用RSA算法解密<BR>
     * 先把cipher进行base64解密,然后再进行RSA解密
     * 
     * @param cipher base64后的密文
     * @return 明文
     * @author 邢治理
     * @since 2016年3月16日
     */
    public String decrypt(String cipher) {
        byte[] plain = this.decryptRSA(Base64.decodeBase64(cipher));
        return new String(plain);
    }

    /**
     * base64解密
     * 
     * @param base64String
     * @return byte[]数组
     * @author 邢治理
     * @since 2016年3月16日
     */
    public byte[] decodeBase64(String base64String) {
        return Base64.decodeBase64(base64String);
    }

    /**
     * base64加密
     * 
     * @param binaryData
     * @return string
     * @author 邢治理
     * @since 2016年3月16日
     */
    public String ecodeBase64(byte[] binaryData) {
        return Base64.encodeBase64String(binaryData);
    }

    /**
     * 获取当前RSA公钥的字符串标识
     * 
     * @return RSA PUBLIC KEY
     * @author 邢治理
     * @since 2016年3月16日
     */
    public String getRSAPublicKey() {
        return this.ecodeBase64(this.publicKey.getEncoded());
    }

    /**
     * 获取当前RSA私钥的字符串标识
     * 
     * @return RSA PRIVATE KEY
     * @author 邢治理
     * @since 2016年3月16日
     */
    public String getRSAPrivateKey() {
        return this.ecodeBase64(this.privateKey.getEncoded());
    }

    /**
     * 对data进行md5加密
     * 
     * @param data
     * @return 加密后数据
     * @author 邢治理
     * @since 2016年3月16日
     */
    public String md5(String data) {
        return DigestUtils.md5Hex(data);

    }
}
