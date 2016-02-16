<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Most recent temperatures</title>
    <script type="text/javascript" src="assets/bower-components/jquery/dist/jquery.js"></script>
    <script type="text/javascript" src="assets/bower-components/d3/d3.js"></script>
    <script type="text/javascript" src="assets/bower-components/metrics-graphics/dist/metricsgraphics.js"></script>
    <script type="text/javascript" src="//momentjs.com/downloads/moment.js"></script>
    <script type="text/javascript" src="assets/bootstrap.js"></script>
    <script type="text/javascript" src="assets/main.js"></script>

    <link href="assets/graph.css" rel="stylesheet"/>
    <link href="assets/bootstrap.css" rel="stylesheet"/>
    <link href="assets/bower-components/metrics-graphics/dist/metricsgraphics.css" rel="stylesheet"/>
</head>

<body>
    <div id="content" class="container">
        <div class="row">
            <div class="col-md-3">
                <div id="most-recent-temp"></div>

                <div id="most-recent-temp-time"></div>
                <br/>

                <form id="event-form">
                    <div class="form-group">
                        <label for="event-form-title">Add an Event</label>
                        <input id="event-form-title" class="form-control" type="text" name="title" placeholder="Event title"/>
                    </div>
                    <div class="form-group">
                        <input id="event-form-minutes-ago" class="form-control" type="text" name="minutes-ago"
                               placeholder="Minutes ago (default 0)"/>
                    </div>
                    <button class="btn btn-default">Add Event</button>
                </form>
            </div>

            <div id="graph" class="col-md-9">
            </div>
        </div>
    </div>
</body>
</html>