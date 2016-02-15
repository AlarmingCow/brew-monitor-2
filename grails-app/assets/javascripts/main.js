var cToF = function(temp) {
    return temp*9/5 + 32;
};

$(document).ready(function() {
    jQuery('#event-form').submit(function(event) {
        event.preventDefault();
        var minutesAgo = parseInt(jQuery('#event-form-minutes-ago').val());
        var formData = {
            'title': jQuery('#event-form-title').val(),
            'time': moment().subtract(minutesAgo, 'minutes').valueOf()
        };
        jQuery.ajax({
            type: "POST",
            url: '/events',
            data: JSON.stringify(formData),
            contentType: 'application/json'
        });
    });

    var updateTemp = function() {
        jQuery.ajax({
            url: "/thermReading?max=1&sort=time&order=desc",
            success: function(temps) {
                jQuery("#most-recent-temp").text(Math.round(cToF(temps[0].temp)) + " ºF");
                jQuery("#most-recent-temp-time").text(moment(temps[0].time).fromNow());
            },
            dataType: "json"
        });
    };

    var updateGraph = function() {
        d3.json("/thermReading/recent?minutesAgo=60", function (temps) {
            temps.forEach(function (d) {
                d.time = d3.time.format.iso.parse(d.time);
                d.temp = cToF(+d.temp);
            });
            d3.json("/event/recent?minutesAgo=60", function (events) {
                var markers = events.map(function (event) {
                    return {'label': event.title, 'time': new Date(event.time)};
                });
                MG.data_graphic({
                    title: "Temperature (ºC)",
                    data: temps,
                    width: 1000,
                    height: 500,
                    min_y_from_data: true,
                    target: '#graph',
                    transition_on_update: false,
                    x_accessor: 'time',
                    y_accessor: 'temp',
                    interpolate_tension: 0.9,
                    markers: markers
                });
            });
        });
    };

    var updatePage = function() {
        updateTemp();
        updateGraph();
    };
    updatePage();
    setInterval(updatePage, 1000);
});
