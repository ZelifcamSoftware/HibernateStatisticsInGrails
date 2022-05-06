package queryperformance.relation

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class DocumentWithStatusRelationshipAndEagerController {

    DocumentWithStatusRelationshipAndEagerService documentWithStatusRelationshipAndEagerService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond documentWithStatusRelationshipAndEagerService.list(), model:[documentWithStatusRelationshipAndEagerCount: documentWithStatusRelationshipAndEagerService.count()]
    }

    def show(Long id) {
        respond documentWithStatusRelationshipAndEagerService.get(id)
    }

    def create() {
        respond new DocumentWithStatusRelationshipAndEager(params)
    }

    def save(DocumentWithStatusRelationshipAndEager documentWithStatusRelationshipAndEager) {
        if (documentWithStatusRelationshipAndEager == null) {
            notFound()
            return
        }

        try {
            documentWithStatusRelationshipAndEagerService.save(documentWithStatusRelationshipAndEager)
        } catch (ValidationException e) {
            respond documentWithStatusRelationshipAndEager.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'documentWithStatusRelationshipAndEager.label', default: 'DocumentWithStatusRelationshipAndEager'), documentWithStatusRelationshipAndEager.id])
                redirect documentWithStatusRelationshipAndEager
            }
            '*' { respond documentWithStatusRelationshipAndEager, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond documentWithStatusRelationshipAndEagerService.get(id)
    }

    def update(DocumentWithStatusRelationshipAndEager documentWithStatusRelationshipAndEager) {
        if (documentWithStatusRelationshipAndEager == null) {
            notFound()
            return
        }

        try {
            documentWithStatusRelationshipAndEagerService.save(documentWithStatusRelationshipAndEager)
        } catch (ValidationException e) {
            respond documentWithStatusRelationshipAndEager.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'documentWithStatusRelationshipAndEager.label', default: 'DocumentWithStatusRelationshipAndEager'), documentWithStatusRelationshipAndEager.id])
                redirect documentWithStatusRelationshipAndEager
            }
            '*'{ respond documentWithStatusRelationshipAndEager, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        documentWithStatusRelationshipAndEagerService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'documentWithStatusRelationshipAndEager.label', default: 'DocumentWithStatusRelationshipAndEager'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'documentWithStatusRelationshipAndEager.label', default: 'DocumentWithStatusRelationshipAndEager'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
