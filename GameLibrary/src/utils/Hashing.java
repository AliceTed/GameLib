package utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.DatatypeConverter;

/**
 *  文字列のハッシュ化
 *  @author Hiroya
 *	@date 17/12/26
 */
public class Hashing
{
	private MessageDigest messageDigest;

	public Hashing(String hashAlgorithm) throws NoSuchAlgorithmException
	{
		//soltを加える
		messageDigest = MessageDigest.getInstance(hashAlgorithm);
	}

	/**
	 * 受け取った文字列からハッシュ値を生成
	 * @param value
	 * @return hash
	 */
	public String toHash(String value)
	{
		return toHashString(toHashValue(value));
	}

	/**
	 * 文字列からハッシュ値生成
	 * @param value
	 * @return hash(byte)
	 */
	private byte[] toHashValue(String value)
	{
		messageDigest.update(value.getBytes());
		return messageDigest.digest();
	}

	/**
	 * byteを文字列に変換
	 * 生成されたhashを文字列に変換する
	 * @param bytes
	 * @return hash(String)
	 */
	private String toHashString(byte[] bytes)
	{
		return DatatypeConverter.printHexBinary(bytes);
	}
}
