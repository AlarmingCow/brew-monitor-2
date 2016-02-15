package brew_monitor

import grails.rest.RestfulController

class EventController extends RestfulController<Event> {
    static responseFormats = ['json']

    EventController() {
        super(Event)
    }

    def recent() {
        Integer minutesAgo = params.getInt('minutesAgo') ?: 60
        respond Event.findAllByTimeGreaterThan(new Date(new Date().time - minutesAgo*60*1000))
    }

}
