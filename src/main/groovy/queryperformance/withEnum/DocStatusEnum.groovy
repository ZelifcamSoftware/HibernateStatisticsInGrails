package queryperformance.withEnum

import groovy.transform.CompileStatic

@CompileStatic
enum DocStatusEnum {
    NEW, OPEN, CLOSED

    static DocStatusEnum getRandomStatus() {
        Random random = new Random()
        return values()[random.nextInt(values().length)]
    }
}