package queryperformance.withEnum

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class DocumentUsingEnumForStatusServiceSpec extends Specification {

    DocumentUsingEnumForStatusService documentUsingEnumForStatusService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new DocumentUsingEnumForStatus(...).save(flush: true, failOnError: true)
        //new DocumentUsingEnumForStatus(...).save(flush: true, failOnError: true)
        //DocumentUsingEnumForStatus documentUsingEnumForStatus = new DocumentUsingEnumForStatus(...).save(flush: true, failOnError: true)
        //new DocumentUsingEnumForStatus(...).save(flush: true, failOnError: true)
        //new DocumentUsingEnumForStatus(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //documentUsingEnumForStatus.id
    }

    void "test get"() {
        setupData()

        expect:
        documentUsingEnumForStatusService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<DocumentUsingEnumForStatus> documentUsingEnumForStatusList = documentUsingEnumForStatusService.list(max: 2, offset: 2)

        then:
        documentUsingEnumForStatusList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        documentUsingEnumForStatusService.count() == 5
    }

    void "test delete"() {
        Long documentUsingEnumForStatusId = setupData()

        expect:
        documentUsingEnumForStatusService.count() == 5

        when:
        documentUsingEnumForStatusService.delete(documentUsingEnumForStatusId)
        sessionFactory.currentSession.flush()

        then:
        documentUsingEnumForStatusService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        DocumentUsingEnumForStatus documentUsingEnumForStatus = new DocumentUsingEnumForStatus()
        documentUsingEnumForStatusService.save(documentUsingEnumForStatus)

        then:
        documentUsingEnumForStatus.id != null
    }
}
