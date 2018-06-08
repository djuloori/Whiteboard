function pageReady() {
    $("#add").click(function(){
        loadDoc();
    });

    $("#EditClass").click(function(){
        loadfunction();
    });
    $("#RemoveClass").click(function(){
        deletefunction();
    });
}

function loadDoc() {
    $.ajax(
        {
            datatype: "json",
            type: 'POST',
            data: dataToJSON($("#courseId").val(),$("#courseName").val()),
            contentType: 'application/json',
            url: getContextPath()+"/app/Classes/AddClass",
            success: function(data){
                if(data == 'Inserted'){
                    window.location.replace('courses.jsp');
                }else{
                    alert("Operation not Successful!")
                    window.location.replace('courses.jsp');
                }
            },
        });
}

function loadfunction() {
    $.ajax(
        {
            datatype: "json",
            type: 'PUT',
            data: dataToJSON($("#courseId").val(),$("#courseName").val()),
            contentType: 'application/json',
            url: getContextPath()+"/app/Classes/UpdateClass",
            success: function(data){
                if(data == 'Edited'){
                        window.location.replace('courses.jsp');
                }else{
                    alert("Operation not Successful!")
                    window.location.replace('courses.jsp');
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
            url: getContextPath()+"/app/Classes/DeleteClass" + '/' + $("#courseId").val(),
            success: function(data){
                if(data == 'Removed'){
                    window.location.replace('courses.jsp');
                }else{
                    alert("Operation not Successful!")
                    window.location.replace('courses.jsp');
                }
            },
        });


}

function getContextPath() {
    return window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
}

function dataToJSON(classId,className){
    var str = JSON.stringify({
        "classId": classId,
        "className": className
    });
    return str;
}