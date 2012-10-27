package org.nstmframework.util

/**
 * User: Naoyuki Yoshinori
 */
class FileUtils {

    /**
     * ファイルパスからファイルの存在の有無を返す。
     * @param path String
     * @return boolean
     */
    static exists(String path) {
        new File(path).exists()
    }
}
