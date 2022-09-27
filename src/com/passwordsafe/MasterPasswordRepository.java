package com.passwordsafe;

import at.lecture.singleton.Logger;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MasterPasswordRepository {
    private String masterPasswordPath;
    private final Logger log = Logger.getInstance();

    public MasterPasswordRepository(String masterPasswordPath) {
        this.masterPasswordPath = masterPasswordPath;
    }
    public void setMasterPasswordPlain(String masterPassword) throws Exception {
        this.StoreMasterPasswordToFile(masterPassword);
        log.info("master password changed");
    }
    public String getMasterPasswordPlain() throws Exception {
        return this.GetMasterPasswordFromFile();
    }
    public boolean MasterPasswordIsEqualTo(String masterPassword) throws Exception {
        return masterPassword.equals(this.GetMasterPasswordFromFile());
    }
    private String GetMasterPasswordFromFile() throws Exception {
        File passwordFile = new File(this.masterPasswordPath);
        char[] buffer = null;
        if (passwordFile.exists()) {
            FileReader reader = null;
            try {
                buffer = new char[(int)passwordFile.length()];
                reader = new FileReader(passwordFile);
                reader.read(buffer);
            }
            finally {
                if (reader != null) { try { reader.close(); } catch (IOException ex) { } };
            }
        }
        return buffer == null ? null : new String(buffer);
    }
    private void StoreMasterPasswordToFile(String masterPassword) throws Exception {
        FileWriter writer = null;
        try {
            writer = new FileWriter(this.masterPasswordPath);
            writer.write(masterPassword);
        } finally {
            if (writer != null) try { writer.close(); } catch (IOException ignore) {}
        }
    }
}
