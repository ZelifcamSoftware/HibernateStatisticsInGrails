package queryperformance.relation

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class DocumentWithStatusRelationshipAndJoinServiceSpec extends Specification {

    DocumentWithStatusRelationshipAndJoinService documentWithStatusRelationshipAndJoinService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new DocumentWithStatusRelationshipAndJoin(...).save(flush: true, failOnError: true)
        //new DocumentWithStatusRelationshipAndJoin(...).save(flush: true, failOnError: true)
        //DocumentWithStatusRelationshipAndJoin documentWithStatusRelationshipAndJoin = new DocumentWithStatusRelationshipAndJoin(...).save(flush: true, failOnError: true)
        //new DocumentWithStatusRelationshipAndJoin(...).save(flush: true, failOnError: true)
        //new DocumentWithStatusRelationshipAndJoin(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //documentWithStatusRelationshipAndJoin.id
    }

    void "test get"() {
        setupData()

        expect:
        documentWithStatusRelationshipAndJoinService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<DocumentWithStatusRelationshipAndJoin> documentWithStatusRelationshipAndJoinList = documentWithStatusRelationshipAndJoinService.list(max: 2, offset: 2)

        then:
        documentWithStatusRelationshipAndJoinList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        documentWithStatusRelationshipAndJoinService.count() == 5
    }

    void "test delete"() {
        Long documentWithStatusRelationshipAndJoinId = setupData()

        expect:
        documentWithStatusRelationshipAndJoinService.count() == 5

        when:
        documentWithStatusRelationshipAndJoinService.delete(documentWithStatusRelationshipAndJoinId)
        sessionFactory.currentSession.flush()

        then:
        documentWithStatusRelationshipAndJoinService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        DocumentWithStatusRelationshipAndJoin documentWithStatusRelationshipAndJoin = new DocumentWithStatusRelationshipAndJoin()
        documentWithStatusRelationshipAndJoinService.save(documentWithStatusRelationshipAndJoin)

        then:
        documentWithStatusRelationshipAndJoin.id != null
    }
}
