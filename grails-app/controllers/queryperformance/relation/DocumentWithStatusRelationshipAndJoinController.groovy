package queryperformance.relation

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class DocumentWithStatusRelationshipAndJoinController {

    DocumentWithStatusRelationshipAndJoinService documentWithStatusRelationshipAndJoinService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond documentWithStatusRelationshipAndJoinService.list(), model:[documentWithStatusRelationshipAndJoinCount: documentWithStatusRelationshipAndJoinService.count()]
    }

    def show(Long id) {
        respond documentWithStatusRelationshipAndJoinService.get(id)
    }

    def create() {
        respond new DocumentWithStatusRelationshipAndJoin(params)
    }

    def save(DocumentWithStatusRelationshipAndJoin documentWithStatusRelationshipAndJoin) {
        if (documentWithStatusRelationshipAndJoin == null) {
            notFound()
            return
        }

        try {
            documentWithStatusRelationshipAndJoinService.save(documentWithStatusRelationshipAndJoin)
        } catch (ValidationException e) {
            respond documentWithStatusRelationshipAndJoin.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'documentWithStatusRelationshipAndJoin.label', default: 'DocumentWithStatusRelationshipAndJoin'), documentWithStatusRelationshipAndJoin.id])
                redirect documentWithStatusRelationshipAndJoin
            }
            '*' { respond documentWithStatusRelationshipAndJoin, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond documentWithStatusRelationshipAndJoinService.get(id)
    }

    def update(DocumentWithStatusRelationshipAndJoin documentWithStatusRelationshipAndJoin) {
        if (documentWithStatusRelationshipAndJoin == null) {
            notFound()
            return
        }

        try {
            documentWithStatusRelationshipAndJoinService.save(documentWithStatusRelationshipAndJoin)
        } catch (ValidationException e) {
            respond documentWithStatusRelationshipAndJoin.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'documentWithStatusRelationshipAndJoin.label', default: 'DocumentWithStatusRelationshipAndJoin'), documentWithStatusRelationshipAndJoin.id])
                redirect documentWithStatusRelationshipAndJoin
            }
            '*'{ respond documentWithStatusRelationshipAndJoin, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        documentWithStatusRelationshipAndJoinService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'documentWithStatusRelationshipAndJoin.label', default: 'DocumentWithStatusRelationshipAndJoin'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'documentWithStatusRelationshipAndJoin.label', default: 'DocumentWithStatusRelationshipAndJoin'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
