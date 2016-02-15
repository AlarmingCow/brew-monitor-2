package brew_monitor

import grails.rest.RestfulController

class ThermReadingController extends RestfulController<ThermReading> {
    static responseFormats = ['json']

    ThermReadingController() {
        super(ThermReading)
    }

    def recent() {
        Integer minutesAgo = params.getInt('minutesAgo') ?: 60
        respond ThermReading.findAllByTimeGreaterThan(new Date(new Date().time - minutesAgo*60*1000))
    }
}
