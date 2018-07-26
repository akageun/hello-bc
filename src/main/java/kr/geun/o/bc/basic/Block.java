package kr.geun.o.bc.basic;

import java.util.Arrays;
import java.util.Date;

/**
 * Block Class
 *
 * @author akageun
 */
public class Block {

	private String hash;
	private String previousHash;

	private String data;
	private long timeStamp;

	private int nonce;

	private Block() {

	}

	/**
	 * Block Constructor
	 *
	 * @param data
	 * @param previousHash
	 */
	public Block(String data, String previousHash) {
		this.data = data;
		this.previousHash = previousHash;

		this.timeStamp = new Date().getTime();
		this.hash = calculateHash();
	}

	/**
	 * Hash값 계산하기!
	 *
	 * @return
	 */
	public String calculateHash() {
		return BcUtils.generateHash(previousHash, Long.toString(timeStamp), Integer.toString(nonce), data);
	}

	/**
	 * Mining
	 */
	public void mineBlock() {
		char[] targetChar = new char[BlockChain.DIFFICULTY];
		Arrays.fill(targetChar, '0');
		String target = String.valueOf(targetChar);

		while (hash.substring(0, BlockChain.DIFFICULTY).equals(target) == false) {
			nonce++;
			hash = calculateHash();
		}

		System.out.println("Block Mined!!! : " + hash);
	}

	/**
	 * get previousHash
	 *
	 * @return
	 */
	public String getPreviousHash() {
		return previousHash;
	}

	/**
	 * get Hash
	 *  - digital signature
	 *
	 * @return
	 */
	public String getHash() {
		return hash;
	}

	/**
	 * get TimeStamp
	 *
	 * @return
	 */
	public long getTimeStamp() {
		return timeStamp;
	}

	/**
	 * get Data
	 *
	 * @return
	 */
	public String getData() {
		return data;
	}

	/**
	 * get nonce
	 *
	 * @return
	 */
	public int getNonce() {
		return nonce;
	}
}
