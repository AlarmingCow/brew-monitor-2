<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Most recent temperatures</title>
    <script type="text/javascript" src="assets/bower-components/jquery/dist/jquery.js"></script>
    <script type="text/javascript" src="assets/bower-components/d3/d3.js"></script>
    <script type="text/javascript" src="assets/bower-components/metrics-graphics/dist/metricsgraphics.js"></script>
    <script type="text/javascript" src="//momentjs.com/downloads/moment.js"></script>
    <script type="text/javascript" src="assets/main.js"></script>
    <link href="assets/graph.css" rel="stylesheet"/>
    <link href="assets/bower-components/metrics-graphics/dist/metricsgraphics.css" rel="stylesheet"/>
</head>

<body>
    <div id="content">
        <div id="most-recent-temp"></div>
        <div id="most-recent-temp-time"></div>
        <br/>
        <form id="event-form">
            Add an event: <br/>
            <input id="event-form-title" type="text" name="title"/>
            <input id="event-form-minutes-ago" type="text" name="minutes-ago" value="0"/> Minutes ago
            <button>Add Event</button>
        </form>
        <dif id="graph"></dif>
    </div>
</body>
</html>