function pageReady() {
    $("#add").click(function(){
        loadDoc();
    });

    $("#edit").click(function(){
        loadfunction();
    });
    $("#remove").click(function(){
        deletefunction();
    });
}

function loadDoc() {
    $.ajax(
        {
            datatype: "json",
            type: 'POST',
            data: dataToJSON($("#schedule_id").val(),$("#location").val(),$("#timings").val(),$("#class-id").val(),$("#day").val()),
            contentType: 'application/json',
            url: getContextPath()+"/app/Schedule/AddSchedule",
            success: function(data){
                if(data == 'Schedule Added'){
                    window.location.replace('schedule.jsp');
                }else{
                    alert("Operation not Successful!")
                    window.location.replace('schedule.jsp');
                }
            },
        });
}

function loadfunction() {
    $.ajax(
        {
            datatype: "json",
            type: 'PUT',
            data: dataToJSON($("#schedule_id").val(),$("#location").val(),$("#timings").val(),$("#class-id").val(),$("#day").val()),
            contentType: 'application/json',
            url: getContextPath()+"/app/Schedule/UpdateSchedule",
            success: function(data){
                if(data == 'Schedule Edited'){
                    window.location.replace('schedule.jsp');
                }else{
                    alert("Operation not Successful!")
                    window.location.replace('schedule.jsp');
                }
            },
        });
}

function deletefunction() {
    $.ajax(
        {
            datatype: "text",
            type: 'DELETE',
            contentType: 'text/plain',
            url: getContextPath()+"/app/Schedule/DeleteSchedule" + '/' + $("#schedule_id").val(),
            success: function(data){
                if(data == 'Schedule Removed'){
                    window.location.replace('schedule.jsp');
                }else{
                    alert("Operation not Successful!")
                    window.location.replace('schedule.jsp');
                }
            },
        });

}

function getContextPath() {
    return window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
}

function dataToJSON(scheduleId,location,timings,classid,day){
    var str = JSON.stringify({
        "timings": timings,
        "location": location,
        "scheduleId": scheduleId,
        "CLASS_ID": classid,
        "day": day
    });
    return str;
}