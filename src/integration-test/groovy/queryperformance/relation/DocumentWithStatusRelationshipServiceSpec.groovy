package queryperformance.relation

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class DocumentWithStatusRelationshipServiceSpec extends Specification {

    DocumentWithStatusRelationshipService documentWithStatusRelationshipService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new DocumentWithStatusRelationship(...).save(flush: true, failOnError: true)
        //new DocumentWithStatusRelationship(...).save(flush: true, failOnError: true)
        //DocumentWithStatusRelationship documentWithStatusRelationship = new DocumentWithStatusRelationship(...).save(flush: true, failOnError: true)
        //new DocumentWithStatusRelationship(...).save(flush: true, failOnError: true)
        //new DocumentWithStatusRelationship(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //documentWithStatusRelationship.id
    }

    void "test get"() {
        setupData()

        expect:
        documentWithStatusRelationshipService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<DocumentWithStatusRelationship> documentWithStatusRelationshipList = documentWithStatusRelationshipService.list(max: 2, offset: 2)

        then:
        documentWithStatusRelationshipList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        documentWithStatusRelationshipService.count() == 5
    }

    void "test delete"() {
        Long documentWithStatusRelationshipId = setupData()

        expect:
        documentWithStatusRelationshipService.count() == 5

        when:
        documentWithStatusRelationshipService.delete(documentWithStatusRelationshipId)
        sessionFactory.currentSession.flush()

        then:
        documentWithStatusRelationshipService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        DocumentWithStatusRelationship documentWithStatusRelationship = new DocumentWithStatusRelationship()
        documentWithStatusRelationshipService.save(documentWithStatusRelationship)

        then:
        documentWithStatusRelationship.id != null
    }
}
