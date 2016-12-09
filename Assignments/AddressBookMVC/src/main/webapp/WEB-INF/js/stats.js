// #1: document ready
$(document).ready(function () {
    drawChart();
});
// #2: draw the bar chart
function drawChart() {
    $.get('stats/chart').success(function (data) {
        // first, create the DataTable from the response data string.
        // our response string is generated on the server by converting the Java
        // Google DataTable object into a JSON string using the Google JsonRenderer
        // object
        var dataTable = new google.visualization.DataTable(data);
        //// set options for the chart - we're setting the main title, the vertical and
        // horizontal axis labels and the height/width of the chart
        var options = {
            title: 'Contacts By Company',
            vAxis: {title: 'Company', titleTextStyle: {color: 'red'}},
            hAxis: {title: 'Num Contacts', titleTextStyle: {color: 'red'}}, 'width': 500,
            'height': 400
        };
        // create the chart (a BarChart here) - pass in the HTML element into which
        // you want to render the chart - here it is the <div> called 'chartDiv'
        // on the jQueryChart.jsp page
        var chart = new google.visualization.BarChart(document.getElementById('chart_div'));
        // finally, draw the chart
        chart.draw(dataTable, options);
    });
}
