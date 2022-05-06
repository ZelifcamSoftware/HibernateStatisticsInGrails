package queryperformance.relation

import grails.gorm.services.Service

@Service(DocumentWithStatusRelationshipAndEager)
interface DocumentWithStatusRelationshipAndEagerService {

    DocumentWithStatusRelationshipAndEager get(Serializable id)

    List<DocumentWithStatusRelationshipAndEager> list(Map args)

    Long count()

    void delete(Serializable id)

    DocumentWithStatusRelationshipAndEager save(DocumentWithStatusRelationshipAndEager documentWithStatusRelationshipAndEager)

}