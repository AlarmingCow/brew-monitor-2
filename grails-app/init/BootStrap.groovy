import brew_monitor.ThermReading

class BootStrap {

    def init = { servletContext ->
        long oneMinute = 60*1000
        long now = new Date().time
        new ThermReading(temp: 80, time: new Date(now - 10*oneMinute)).save()
        new ThermReading(temp: 82, time: new Date(now - 9*oneMinute)).save()
        new ThermReading(temp: 83, time: new Date(now - 8*oneMinute)).save()
        new ThermReading(temp: 85, time: new Date(now - 7*oneMinute)).save()
        new ThermReading(temp: 81, time: new Date(now - 6*oneMinute)).save()
        new ThermReading(temp: 78, time: new Date(now - 5*oneMinute)).save()
        new ThermReading(temp: 78, time: new Date(now - 4*oneMinute)).save()
        new ThermReading(temp: 75, time: new Date(now - 3*oneMinute)).save()
        new ThermReading(temp: 72, time: new Date(now - 2*oneMinute)).save()
        new ThermReading(temp: 76, time: new Date(now - 1*oneMinute)).save()
    }
    def destroy = {
    }
}
