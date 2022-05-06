package queryperformance.relation

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class DocumentWithStatusRelationshipAndEagerServiceSpec extends Specification {

    DocumentWithStatusRelationshipAndEagerService documentWithStatusRelationshipAndEagerService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new DocumentWithStatusRelationshipAndEager(...).save(flush: true, failOnError: true)
        //new DocumentWithStatusRelationshipAndEager(...).save(flush: true, failOnError: true)
        //DocumentWithStatusRelationshipAndEager documentWithStatusRelationshipAndEager = new DocumentWithStatusRelationshipAndEager(...).save(flush: true, failOnError: true)
        //new DocumentWithStatusRelationshipAndEager(...).save(flush: true, failOnError: true)
        //new DocumentWithStatusRelationshipAndEager(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //documentWithStatusRelationshipAndEager.id
    }

    void "test get"() {
        setupData()

        expect:
        documentWithStatusRelationshipAndEagerService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<DocumentWithStatusRelationshipAndEager> documentWithStatusRelationshipAndEagerList = documentWithStatusRelationshipAndEagerService.list(max: 2, offset: 2)

        then:
        documentWithStatusRelationshipAndEagerList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        documentWithStatusRelationshipAndEagerService.count() == 5
    }

    void "test delete"() {
        Long documentWithStatusRelationshipAndEagerId = setupData()

        expect:
        documentWithStatusRelationshipAndEagerService.count() == 5

        when:
        documentWithStatusRelationshipAndEagerService.delete(documentWithStatusRelationshipAndEagerId)
        sessionFactory.currentSession.flush()

        then:
        documentWithStatusRelationshipAndEagerService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        DocumentWithStatusRelationshipAndEager documentWithStatusRelationshipAndEager = new DocumentWithStatusRelationshipAndEager()
        documentWithStatusRelationshipAndEagerService.save(documentWithStatusRelationshipAndEager)

        then:
        documentWithStatusRelationshipAndEager.id != null
    }
}
