package queryperformance

import grails.gorm.transactions.Transactional
import queryperformance.relation.DocStatus
import queryperformance.relation.DocumentWithStatusRelationship
import queryperformance.relation.DocumentWithStatusRelationshipAndEager
import queryperformance.relation.DocumentWithStatusRelationshipAndJoin
import queryperformance.withEnum.DocStatusEnum
import queryperformance.withEnum.DocumentUsingEnumForStatus

@Transactional
class BootstrapService {

    def createTestData() {
        createDocStatuses()
        createDocuments()
    }

    def createDocStatuses(){
        DocStatusEnum.values().each {
            new DocStatus(status: it.name()).save()
        }
    }

    def createDocuments(){
        (0..500).each {
            new DocumentWithStatusRelationship(name: "DWSR$it", docStatus: DocStatus.find('from DocStatus order by rand()')).save()
            new DocumentWithStatusRelationshipAndEager(name: "DWSRE$it", docStatus: DocStatus.find('from DocStatus order by rand()')).save()
            new DocumentWithStatusRelationshipAndJoin(name: "DWSRJ$it", docStatus: DocStatus.find('from DocStatus order by rand()')).save()
            new DocumentUsingEnumForStatus(name: "DUEFS$it", docStatus: DocStatusEnum.randomStatus).save()
        }
    }
}
