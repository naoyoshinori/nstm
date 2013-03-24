package org.nstmframework.command

/**
 * User: Naoyuki Yoshinori
 */
class CommandOptions extends ArrayList<String> {

    def CommandOptions(Collection<? extends String> c) {
        super(c)
    }

    def shift() {
        size() > 0 ? remove(0) : null
    }

    def find(pattern) {
        repeat_to_match { int i ->
            get(i) ==~ pattern ? get(i) : null
        }
    }

    def pop(pattern) {
        repeat_to_match { int i ->
            get(i) ==~ pattern ? remove(i) : null
        }
    }

    private repeat_to_match(func) {
        def size = this.size()
        def result

        for (int i = 0; i < size; i++) {
            result = func(i)
            if (result) break
        }
        result
    }
}
