package brew_monitor

import grails.rest.RestfulController

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class ThermReadingController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond ThermReading.list(params), model:[thermReadingCount: ThermReading.count()]
    }

    def show(ThermReading thermReading) {
        respond thermReading
    }

    def create() {
        respond new ThermReading(params)
    }

    @Transactional
    def save(ThermReading thermReading) {
        if (thermReading == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (thermReading.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond thermReading.errors, view:'create'
            return
        }

        thermReading.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'thermReading.label', default: 'ThermReading'), thermReading.id])
                redirect thermReading
            }
            '*' { respond thermReading, [status: CREATED] }
        }
    }

    def edit(ThermReading thermReading) {
        respond thermReading
    }

    @Transactional
    def update(ThermReading thermReading) {
        if (thermReading == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (thermReading.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond thermReading.errors, view:'edit'
            return
        }

        thermReading.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'thermReading.label', default: 'ThermReading'), thermReading.id])
                redirect thermReading
            }
            '*'{ respond thermReading, [status: OK] }
        }
    }

    @Transactional
    def delete(ThermReading thermReading) {

        if (thermReading == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        thermReading.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'thermReading.label', default: 'ThermReading'), thermReading.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'thermReading.label', default: 'ThermReading'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
