package queryperformance.relation

import grails.gorm.services.Service

@Service(DocumentWithStatusRelationship)
interface DocumentWithStatusRelationshipService {

    DocumentWithStatusRelationship get(Serializable id)

    List<DocumentWithStatusRelationship> list(Map args)

    Long count()

    void delete(Serializable id)

    DocumentWithStatusRelationship save(DocumentWithStatusRelationship documentWithStatusRelationship)

}