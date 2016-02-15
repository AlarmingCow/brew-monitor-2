var cToF = function(temp) {
    return temp*9/5 + 32;
};

$(document).ready(function() {
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
                interpolate_tension: 0.9
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
