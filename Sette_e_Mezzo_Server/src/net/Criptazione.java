/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net;

import dominio.eccezioni.ChiaveNonValida;
import java.util.logging.Logger;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
/**
 *
 * @author marco
 */
public class Criptazione {

    private static Logger log = Logger.getLogger(Criptazione.class.getName());
    private final static String accountSeperator = ":";

  private static String key = "PisoTino";

/**
 * decripta il messaggio
 * 
 * @param message messaggio per la decritptazione
 * @return stringa decriptata
 * @throws Exception 
 */
  private String decrypt(String message) throws Exception {
    byte[] bytesrc = convertHexString(message);
    Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
    DESKeySpec desKeySpec = new DESKeySpec(key.getBytes("UTF-8"));
    SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
    SecretKey secretKey = keyFactory.generateSecret(desKeySpec);
    IvParameterSpec iv = new IvParameterSpec(key.getBytes("UTF-8"));

    cipher.init(Cipher.DECRYPT_MODE, secretKey, iv);
    byte[] retByte = cipher.doFinal(bytesrc);
    return new String(retByte);
  }

  /**
   * encripta il messaggio
   * 
   * @param message messaggio da encriptare
   * @return messaggio encriptato
   * @throws Exception 
   */
  private String encrypt(String message) throws Exception {
    Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
    DESKeySpec desKeySpec = new DESKeySpec(key.getBytes("UTF-8"));
    SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
    SecretKey secretKey = keyFactory.generateSecret(desKeySpec);
    IvParameterSpec iv = new IvParameterSpec(key.getBytes("UTF-8"));
    cipher.init(Cipher.ENCRYPT_MODE, secretKey, iv);
    return toHexString(cipher.doFinal(message.getBytes("UTF-8")));
  }

  private byte[] convertHexString(String ss) {
    byte digest[] = new byte[ss.length() / 2];
    for (int i = 0; i < digest.length; i++) {
      String byteString = ss.substring(2 * i, 2 * i + 2);
      int byteValue = Integer.parseInt(byteString, 16);
      digest[i] = (byte) byteValue;
    }
    return digest;
  }

  private String toHexString(byte b[]) {
    StringBuffer hexString = new StringBuffer();
    for (int i = 0; i < b.length; i++) {
      String plainText = Integer.toHexString(0xff & b[i]);
      if (plainText.length() < 2)
        plainText = "0" + plainText;
      hexString.append(plainText);
    }
    return hexString.toString();
  }

    /**
     *Inserire username e passwor criptati per decriptarli
     * @param userEpw username e password criptati
     * @return ritorna in posizione 0 username e in posizione 1 la password
     */
    public  String[] decodificaAccount(String userEpw) {
    try {
      String origi = decrypt(userEpw);
      String[] parts = origi.split(Criptazione.accountSeperator);
      if (parts.length == 2 && !parts[0].equals("") && !parts[1].equals("")) {
        return parts;
      }
    } catch (Exception e) {
      e.printStackTrace();
      log.warning(e.getMessage());
    }
    return null;
  }

    /**
     *Inserire i dati per criptarli 
     * @param username username del giocatore
     * @param password password del giocatore
     * @return ritorna username e password in messaggio criptato
     */
    public String codificaAccount(String username, String password) {
    String encryptString = null;
    try {
      encryptString =encrypt(username + Criptazione.accountSeperator + password);
    } catch (Exception e) {
      log.warning(e.getMessage());
    }
    return encryptString;
  }
  
    /**
     *Inserire messaggio per codificarlo
     * @param msg messaggio da codificare
     * @return messaggio codificato
     */
    public String codificaMessaggio(String msg){
      String encryptString = null;
    try {
      encryptString = encrypt(msg);
    } catch (Exception e) {
      log.warning(e.getMessage());
    }
    return encryptString;
  }
  
    /**
     *Decodifica un messaggio 
     * @param msg messaggio codificato
     * @return messaggio decodificato
     */
    public String decodificaMessaggio(String msg) {
    try {
      String decript = decrypt(msg);      
        return decript;
      
    } catch (Exception e) {
      e.printStackTrace();
      log.warning(e.getMessage());
    }
    return null;
  }
  
    /**
     *Cambia la chiave di cifratura dei messaggi, deve essere composta da 8 caratteri
     * @param key nuova chiave
     * @throws dominio.eccezioni.ChiaveNonValida
     */
    public void setKey(String key) throws ChiaveNonValida {
        if(key.length()==8)
            Criptazione.key = key;
        else
            throw new ChiaveNonValida();
    }
}
