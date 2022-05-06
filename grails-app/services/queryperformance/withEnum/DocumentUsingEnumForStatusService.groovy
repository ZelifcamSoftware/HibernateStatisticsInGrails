package queryperformance.withEnum

import grails.gorm.services.Service

@Service(DocumentUsingEnumForStatus)
interface DocumentUsingEnumForStatusService {

    DocumentUsingEnumForStatus get(Serializable id)

    List<DocumentUsingEnumForStatus> list(Map args)

    Long count()

    void delete(Serializable id)

    DocumentUsingEnumForStatus save(DocumentUsingEnumForStatus documentUsingEnumForStatus)

}