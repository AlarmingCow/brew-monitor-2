package brew_monitor

import grails.rest.Resource

@Resource(uri="/thermReadings")
class ThermReading {
    Double temp
    Date time

    static constraints = {
    }
}
