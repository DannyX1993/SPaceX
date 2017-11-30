package models.core;

public enum EncryptingAlgorithm {
    SHA1("SHA-1"), SHA256("SHA-256"), SHA384("SHA-384"), SHA512("SHA-512");

    private String text;

    EncryptingAlgorithm(String text) {
        this.text = text;
    }

    public String getName() {
        return this.text;
    }

}
