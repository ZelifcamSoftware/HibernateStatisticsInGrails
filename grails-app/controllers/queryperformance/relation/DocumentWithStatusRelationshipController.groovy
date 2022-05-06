package queryperformance.relation

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class DocumentWithStatusRelationshipController {

    DocumentWithStatusRelationshipService documentWithStatusRelationshipService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond documentWithStatusRelationshipService.list(), model:[documentWithStatusRelationshipCount: documentWithStatusRelationshipService.count()]
    }

    def show(Long id) {
        respond documentWithStatusRelationshipService.get(id)
    }

    def create() {
        respond new DocumentWithStatusRelationship(params)
    }

    def save(DocumentWithStatusRelationship documentWithStatusRelationship) {
        if (documentWithStatusRelationship == null) {
            notFound()
            return
        }

        try {
            documentWithStatusRelationshipService.save(documentWithStatusRelationship)
        } catch (ValidationException e) {
            respond documentWithStatusRelationship.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'documentWithStatusRelationship.label', default: 'DocumentWithStatusRelationship'), documentWithStatusRelationship.id])
                redirect documentWithStatusRelationship
            }
            '*' { respond documentWithStatusRelationship, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond documentWithStatusRelationshipService.get(id)
    }

    def update(DocumentWithStatusRelationship documentWithStatusRelationship) {
        if (documentWithStatusRelationship == null) {
            notFound()
            return
        }

        try {
            documentWithStatusRelationshipService.save(documentWithStatusRelationship)
        } catch (ValidationException e) {
            respond documentWithStatusRelationship.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'documentWithStatusRelationship.label', default: 'DocumentWithStatusRelationship'), documentWithStatusRelationship.id])
                redirect documentWithStatusRelationship
            }
            '*'{ respond documentWithStatusRelationship, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        documentWithStatusRelationshipService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'documentWithStatusRelationship.label', default: 'DocumentWithStatusRelationship'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'documentWithStatusRelationship.label', default: 'DocumentWithStatusRelationship'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
