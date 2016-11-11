/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

// When the document is ready, populate our summary table
$(document).ready(function () {
    loadDvds();

    // add the onclick handling for our add button
    $('#add-button').click(function (event) {
        event.preventDefault();
        // need to submit this via AJAX
        $.ajax({
            type: 'POST',
            url: 'dvd',
            // make the JSON contact
            data: JSON.stringify({
                title: $('#add-title').val(),
                releaseDate: $('#add-release-date').val(),
                rating: $('#add-rating').val(),
                director: $('#add-director').val(),
                studio: $('#add-studio').val(),
                userRating: $('#add-user-rating').val()
            }),
            contentType: 'application/json; charset=utf-8',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            dataType: 'json'
        }).success(function (data, status) {
            // clear the form and reload the summary table
            $('#add-title').val('');
            $('#add-release-date').val('');
            $('#add-rating').val('');
            $('#add-director').val('');
            $('#add-studio').val('');
            $('#add-user-rating').val('');

            // reload the summary table
            $('#validationErrors').empty();
            loadContacts();
        }).error(function (data, status) {
            $('#validationErrors').empty();
            $.each(data.responseJSON.fieldErrors, function (index, validationError) {
                var errorDiv = $('#validationErrors');
                errorDiv.append(validationError.message).append($('<br>'));
            });
        });
    });

    $('#edit-button').click(function (event) {
        event.preventDefault();
        // update our contact via AJAX
        $.ajax({
            type: 'PUT',
            url: 'dvd/' + $('#edit-dvd-id').val(),
            data: JSON.stringify({
                dvdId: $('#edit-dvd-id').val(),
                title: $('#edit-title').val(),
                releaseDate: $('#edit-release-date').val(),
                rating: $('#edit-rating').val(),
                director: $('#edit-director').val(),
                studio: $('#edit-studio').val(),
                userRating: $('#edit-user-Rating').val()
            }),
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            'dataType': 'json'
        }).success(function () {
            loadDvds();
        });
    });

    $("#search-button").click(function (event) {
        event.preventDefault();
        $.ajax({
            type: 'POST',
            url: 'search/dvds',
            dataType: 'json',
            data: JSON.stringify({
                title: $('#search-title').val(),
                releaseDate: $('#search-release-Date').val(),
                rating: $('#search-rating').val(),
                director: $('#search-director').val(),
                studio: $('#search-studio').val(),
                userRating: $('#search-user-rating').val()
            }),
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        }).success(function (searchResults, status) {
            $('#search-title').val('');
            $('#search-release-date').val('');
            $('#search-rating').val('');
            $('#search-director').val('');
            $('#search-studio').val('');
            $('search-user-rating').val();

            fillContactTable(searchResults, status);
        });
    });
});

// Load contacts into our summary table
function loadDvds() {
    //  Get our JSON object from the endpoint
    $.ajax({
        url: 'dvds'
    }).success(function (data, status) {
        fillDvdTable(data, status);
    });
}

// used with Search button and loadContact function
function fillDvdTable(dvdCollection, status) {
    // clear the previous list
    cleardvdTable();

    // store our tbody in a variable 
    var summaryTable = $('#contentRows');

    $.each(dvdCollection, function (arrayPosition, movie) {
        summaryTable.append($('<tr>')
                .append($('<td>')
                        .append($('<a>')
                                .attr({
                                    'data-dvd-id': movie.DvdId,
                                    'data-toggle': 'modal',
                                    'data-target': '#detailsModal'
                                })
                                .text((arrayPosition) + ' - ' + movie.title + ' ')))
                .append($('<td>').text(movie.releaseDate))
                .append($('<td>')
                        .append($('<a>')
                                .attr({
                                    'data-dvd-id': movie.dvdId,
                                    'data-toggle': 'modal',
                                    'data-target': '#editModal'
                                })
                                .text('Edit')))
                .append($('<td>')
                        .append($('<a>')
                                .attr({
                                    'onClick': 'deleteDvd(' + movie.dvdId + ')'
                                })
                                .text('Delete'))));
    });
}

// Clear all the rows from our summary table
function clearDvdTable() {
    $('#contentRows').empty();
}

// Run in response to the show.bs.modal event
// It gets the contact data and renders it to the dialog
$('#detailsModal').on('show.bs.modal', function (event) {
    var element = $(event.relatedTarget);
    var dvdId = element.data('dvd-id');
    var modal = $(this);
    // Get our object via AJAX
    $.ajax({
        type: 'GET',
        url: 'dvd/' + dvdId
    }).success(function (sampleDvd) {
        modal.find('#dvd-id').text(sampleDvd.dvdId);
        modal.find('#dvd-title').text(sampleDvd.title);
        modal.find('#dvd-releaseDate').text(sampleDvd.releaseDate);
        modal.find('#dvd-rating').text(sampleDvd.rating);
        modal.find('#dvd-director').text(sampleDvd.director);
        modal.find('#dvd-studio').text(sampleDvd.studio);
        modal.find('#dvd-userRating').text(sampleDvd.userRating);
    });
});

$('#editModal').on('show.bs.modal', function (event) {
    var element = $(event.relatedTarget);
    var dvdId = element.data('dvd-id');
    var modal = $(this);

    // get our object via AJAX
    $.ajax({
        type: 'GET',
        url: 'dvd/' + dvdId
    }).success(function (sampleEditDvd) {
        modal.find('#edit-dvd-id').val(sampleEditDvd.dvdId);
        modal.find('#edit-title').val(sampleEditDvd.title);
        modal.find('#edit-releaseDate').val(sampleEditDvd.releaseDate);
        modal.find('#edit-rating').val(sampleEditDvd.rating);
        modal.find('#edit-director').val(sampleEditDvd.director);
        modal.find('#edit-studio').val(sampleEditDvd.studio);
        modal.find('#edit-userRating').val(sampleEditDvd.userRating);
    });
});

function deleteDvd(id) {
    var answer = confirm('Do you really want to delete this dvd?');

    if (answer === true) {
        $.ajax({
            type: 'DELETE',
            url: 'dvd/' + id
        }).success(function () {
            // reload summary
            loadDvds();
        });
    }
}        