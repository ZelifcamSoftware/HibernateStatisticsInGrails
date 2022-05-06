package queryperformance.relation

import grails.gorm.services.Service

@Service(DocumentWithStatusRelationshipAndJoin)
interface DocumentWithStatusRelationshipAndJoinService {

    DocumentWithStatusRelationshipAndJoin get(Serializable id)

    List<DocumentWithStatusRelationshipAndJoin> list(Map args)

    Long count()

    void delete(Serializable id)

    DocumentWithStatusRelationshipAndJoin save(DocumentWithStatusRelationshipAndJoin documentWithStatusRelationshipAndJoin)

}