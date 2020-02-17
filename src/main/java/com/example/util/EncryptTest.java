package com.example.util;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

public class EncryptTest {
	public static void main(String[] args) {
		StandardPBEStringEncryptor pbeEnc = new StandardPBEStringEncryptor();
		pbeEnc.setAlgorithm("PBEWithMD5AndDES");
		pbeEnc.setPassword("kdk");

		String username = "root";
		String password = "root";

		String encName = pbeEnc.encrypt(username);
		String encPwd = pbeEnc.encrypt(password);

		String decName = pbeEnc.decrypt(encName);
		String decPwd = pbeEnc.decrypt(encPwd);

		System.out.println("기존  username :: " + decName + " | 변경 username :: " + encName);
		System.out.println("기존  password :: " + decPwd + " | 변경 password :: " + encPwd);

	}

}
