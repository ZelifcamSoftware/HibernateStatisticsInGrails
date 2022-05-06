package queryperformance.relation

class DocumentWithStatusRelationshipAndJoin {
    String name
    DocStatus docStatus

    static constraints = {
    }

    static mapping = {
        docStatus fetch: 'join'
    }
}
