package org.nstmframework.util

/**
 * User: Naoyuki Yoshinori
 */
class ArgumentUtils {

    /**
     * リストの先頭の値を返す。さらにリストの先頭の値は削除される。
     * @param args List
     * @return Object
     */
    static shift(List args) {
        return args?.size() > 0 ? args.remove(0) : null
    }
}
