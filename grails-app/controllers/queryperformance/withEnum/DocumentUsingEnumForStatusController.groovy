package queryperformance.withEnum

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class DocumentUsingEnumForStatusController {

    DocumentUsingEnumForStatusService documentUsingEnumForStatusService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond documentUsingEnumForStatusService.list(), model:[documentUsingEnumForStatusCount: documentUsingEnumForStatusService.count()]
    }

    def show(Long id) {
        respond documentUsingEnumForStatusService.get(id)
    }

    def create() {
        respond new DocumentUsingEnumForStatus(params)
    }

    def save(DocumentUsingEnumForStatus documentUsingEnumForStatus) {
        if (documentUsingEnumForStatus == null) {
            notFound()
            return
        }

        try {
            documentUsingEnumForStatusService.save(documentUsingEnumForStatus)
        } catch (ValidationException e) {
            respond documentUsingEnumForStatus.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'documentUsingEnumForStatus.label', default: 'DocumentUsingEnumForStatus'), documentUsingEnumForStatus.id])
                redirect documentUsingEnumForStatus
            }
            '*' { respond documentUsingEnumForStatus, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond documentUsingEnumForStatusService.get(id)
    }

    def update(DocumentUsingEnumForStatus documentUsingEnumForStatus) {
        if (documentUsingEnumForStatus == null) {
            notFound()
            return
        }

        try {
            documentUsingEnumForStatusService.save(documentUsingEnumForStatus)
        } catch (ValidationException e) {
            respond documentUsingEnumForStatus.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'documentUsingEnumForStatus.label', default: 'DocumentUsingEnumForStatus'), documentUsingEnumForStatus.id])
                redirect documentUsingEnumForStatus
            }
            '*'{ respond documentUsingEnumForStatus, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        documentUsingEnumForStatusService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'documentUsingEnumForStatus.label', default: 'DocumentUsingEnumForStatus'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'documentUsingEnumForStatus.label', default: 'DocumentUsingEnumForStatus'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
