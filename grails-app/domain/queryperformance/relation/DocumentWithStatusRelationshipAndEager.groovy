package queryperformance.relation

class DocumentWithStatusRelationshipAndEager {
    String name
    DocStatus docStatus

    static constraints = {
    }

    static mapping = {
        docStatus lazy: false
    }
}
